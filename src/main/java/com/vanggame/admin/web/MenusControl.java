package com.vanggame.admin.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.vanggame.admin.entity.Admin;
import com.vanggame.admin.entity.AdminRole;
import com.vanggame.admin.entity.Menus;
import com.vanggame.admin.log.Log;
import com.vanggame.admin.service.AdminRoleService;
import com.vanggame.admin.service.MenusService;
import com.vanggame.admin.util.CommonConst;

@Controller
@RequestMapping(value = "menus")
public class MenusControl {

	@Autowired
	private MenusService menusService;

	@Autowired
	private AdminRoleService roleService;

	@RequestMapping(value = "getMyMenus")
	@ResponseBody
	public String getMyMenus(HttpSession session) {
		Admin admin = (Admin) session.getAttribute(CommonConst.STRING_ADMIN);
		if (admin == null) {
			return null;
		}
		Log.d("admin" +admin.toJSON());
		AdminRole role = roleService.getAdminRoleByID(admin.getAdminRoleID());
		
		List<Menus> list = menusService.getTreeMenus();
		JSONArray array = new JSONArray();
		if (null != list && list.size() > 0) {
			JSONArray children = new JSONArray();
			for (Menus m : list) {
				JSONObject json = m.toJSON();
				json.put("isChecked", roleService.hasPermission(role, m));

				if (m.getChildren() != null) {
					JSONArray chaildren = new JSONArray();
					for (Menus c : m.getChildren()) {

						JSONObject cj = c.toJSON();
						// cj.put("isChecked",
						// adminRoleManager.hasPermission(role, c));
						children.add(cj);
					}
					json.put("children", children);
				}
				array.add(json);
				
			}
			
			
		}
		Log.d(array.toJSONString().toString());
		return array.toJSONString();
	}
}
