package com.vanggame.admin.web;

import java.util.List;
import java.util.Map;

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
@RequestMapping(value = "admin")
public class MenusControl {

	@Autowired
	private MenusService menusService;

	@Autowired
	private AdminRoleService roleService;

	@RequestMapping(value = "getAllMenus")
	@ResponseBody
	public String getMyMenus(HttpSession session) {
		Admin admin = (Admin) session.getAttribute(CommonConst.STRING_ADMIN);
		if (admin == null) {
			return null;
		}
		Log.d("admin" + admin.toJSON());
		AdminRole role = roleService.getAdminRoleByID(admin.getAdminRoleID());

		List<Menus> menus = menusService.getMenusByPermission(role);

		JSONArray array = new JSONArray();
		for (Menus menu : menus) {
			JSONObject json = menu.toJSON();
			if (menu.getChildren() != null && menu.getChildren().size() > 0) {
				JSONArray carray = new JSONArray();
				for (Menus c : menu.getChildren()) {
					carray.add(c.toJSON());
				}
				json.put("childMenus", carray);
			}
			array.add(json);
		}

		Log.d(array.toString());

		System.out.println("返回的" + array.toJSONString().toString());
		return array.toJSONString();
	}
	
//	@RequestMapping(value = "getAllMenus")
//	@ResponseBody
//	public Map<String, Object> getAllMenus() {
//
//		return null;
//	}

	@RequestMapping(value = "getAllRootMenus")
	@ResponseBody
	public String getAllRootMenus() {

		return "";
	}

	
}
