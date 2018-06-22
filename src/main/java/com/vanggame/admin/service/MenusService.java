package com.vanggame.admin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanggame.admin.dao.MenusDao;
import com.vanggame.admin.entity.AdminRole;
import com.vanggame.admin.entity.Menus;
import com.vanggame.admin.util.StringUtils;

@Service
public class MenusService {

	@Autowired
	private MenusDao sysMenuDao;

	public void saveSysMenu(Menus menu) {
		if (menu.getParentID() == null) {
			menu.setParentID(0);
		}
		if (menu.getId() == null) {
			menu.setCreateTime(new Date());
		}
		sysMenuDao.save(menu);
	}
	
	public List<Menus> getAllMenus() {

		return sysMenuDao.getAllMenus();

	}
	
	public List<Menus> getRootMenus() {
		List<Menus> all = sysMenuDao.getAllMenus();
		List<Menus> roots = new ArrayList<Menus>();

		for (Menus m : all) {
			if (m.getParentID() <= 0) {
				roots.add(m);
			}
		}

		return roots;

	}

	/**
	 * 获取给定权限的所有权限
	 * 
	 * @param role
	 * @return
	 */
	public List<Menus> getMenusByPermission(AdminRole role) {

		if (role.getTopRole() != null && role.getTopRole().equals(1)) {
			return getTreeMenus(getAllMenus());
		}

		List<String> menus = StringUtils.split2list(role.getPermission(), ",");
		List<Menus> matched = new ArrayList<Menus>();

		if (menus != null) {
			List<Menus> all = getAllMenus();

			for (String mid : menus) {
				for (Menus m : all) {
					if (m.getId().equals(Integer.valueOf(mid))) {
						matched.add(m);
						break;
					}
				}
			}

			return getTreeMenus(matched);
		}
		return matched;
	}

	/**
	 * 获取给定权限的所有权限
	 * 
	 * @param permission
	 * @return
	 */
	public String getRealPermission(String permission) {

		List<String> menus = StringUtils.split2list(permission, ",");

		if (menus != null) {

			StringBuilder sb = new StringBuilder();

			List<Menus> all = getAllMenus();
			for (Menus m : all) {
				for (String mid : menus) {
					if (m.getId().equals(Integer.valueOf(mid)) || m.getParentID().equals(Integer.valueOf(mid))) {
						sb.append(m.getId()).append(",");
						break;
					}
				}
			}

			return sb.toString();
		}
		return "";
	}

	/**
	 * 按照树状结构获取功能菜单，目前只支持最多二级菜单
	 * 
	 * @return
	 */
	public List<Menus> getTreeMenus() {

		return getTreeMenus(sysMenuDao.getAllMenus());
	}

	private List<Menus> getTreeMenus(List<Menus> all) {

		List<Menus> roots = new ArrayList<Menus>();

		for (Menus m : all) {
			if (m.getParentID() <= 0) {
				roots.add(m);
			}
		}

		for (Menus m : roots) {

			for (Menus n : all) {

				if (n.getParentID().equals(m.getId())) {
					if (m.getChildren() == null) {
						m.setChildren(new ArrayList<Menus>());
					}
					m.getChildren().add(n);
				}
			}

		}

		return roots;
	}

}
