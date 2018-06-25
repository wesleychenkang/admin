package com.vanggame.admin.web;

import java.util.Date;
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
import com.vanggame.admin.service.AdminRoleService;
import com.vanggame.admin.util.CommonConst;

@Controller
@RequestMapping(value = "admin")
public class AdminRoleControl {

	@Autowired
	private AdminRoleService roleService;

	@RequestMapping(value = "saveAdminRole")
	@ResponseBody
	public String saveAdminRole(AdminRole role, HttpSession session) {
		try {
			Admin admin = (Admin) session.getAttribute(CommonConst.STRING_ADMIN);
			if (null == admin) {
				return renderState(false, "add fail pleas login again!");
			}
			role.setCreateTime(new Date());
			role.setCreatorID(admin.getId());
			roleService.addAdminRole(role);
			return renderState(true, "add success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return renderState(false, "add fail");
	}

	@RequestMapping(value = "getAllAdminRoles")
	@ResponseBody
	public String getAllAdminRoles() {
		List<AdminRole> list = roleService.getAllAdminRoles();
		JSONArray array = new JSONArray();
		for (AdminRole role : list) {
			array.add(role.toJSON());
		}

		return array.toJSONString();
	}

	@RequestMapping(value = "updateRolePermission")
	@ResponseBody
	public void updateRolePermission(String adminRoleID,String rolePermission) {
		try {
			roleService.updateAdminRole(adminRoleID,rolePermission);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private String renderState(boolean suc, String msg) {
		JSONObject json = new JSONObject();
		json.put("state", suc ? 1 : 0);
		json.put("msg", msg);
		return json.toJSONString();

	}

}
