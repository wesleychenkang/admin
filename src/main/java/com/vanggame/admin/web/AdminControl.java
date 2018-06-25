package com.vanggame.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.vanggame.admin.entity.Admin;
import com.vanggame.admin.entity.AdminRole;
import com.vanggame.admin.service.AdminRoleService;
import com.vanggame.admin.service.AdminService;
import com.vanggame.admin.util.EncryptUtils;

@Controller
@RequestMapping(value = "admin")
public class AdminControl {

	@Autowired
	private AdminRoleService roleService;

	@Autowired
	private AdminService adminService;

	
	@RequestMapping(value = "adminRoleManage")
	public String adminRoleManage() {
		return "admin";
	}

	@RequestMapping(value = "getAllAdmins")
	@ResponseBody
	public String getAllAdmins() {
		List<Admin> list = adminService.queryAllAccount();
		JSONArray array = new JSONArray();
		for (Admin admin : list) {
			array.add(admin.toJSON());
		}
		return array.toJSONString();
	}

	@RequestMapping(value = "saveAdmin")
	@ResponseBody
	public String saveAdmin(Admin admin, Integer myRoleID) {
		try {
			AdminRole role = roleService.getAdminRoleByID(myRoleID);
			if (null == role) {
				return renderState(false, "roleId is null");
			}
			if (admin.getUsername() == null || admin.getPassword() == null) {
				return renderState(false, "name or password is null");
			}
			Admin ex = adminService.getByAccount(admin.getUsername());
		    
			if (ex != null) {
				String passWord = ex.getPassword();
				// 说明只是修改信息
				ex.setAdminRoleID(role.getId());
				ex.setAdminRoleName(role.getRoleName());
				if (!passWord.equals(admin.getPassword())) {
					passWord = EncryptUtils.md5(passWord);
				}
				ex.setPassword(passWord);
				adminService.updateAdmin(ex);
			}
			System.out.println(admin.toJSON());
			admin.setAdminRoleName(role.getRoleName());
			admin.setAdminRoleID(role.getId());
			admin.setPassword(EncryptUtils.md5(admin.getPassword()));
			adminService.saveAdmin(admin);
			return renderState(true, "add success");
		} catch (Exception e) {
			e.printStackTrace();

		}
		return renderState(false, "add fail");
	}
	
	
	@RequestMapping(value = "removeAdmin")
	@ResponseBody
	public String removeAdmin(Admin admin) {
		try {
			adminService.removeAdmin(admin);
			return renderState(true, "remove success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return renderState(false, "remove fail");
		
	}
	
	@RequestMapping(value = "adminPermissionManage")
	public String adminPermissionManage() {
		
		return "adminPermissions";
	}
	


	private String renderState(boolean suc, String msg) {
		JSONObject json = new JSONObject();
		json.put("state", suc ? 1 : 0);
		json.put("msg", msg);
		return json.toJSONString();
	}

}
