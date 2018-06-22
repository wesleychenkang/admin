package com.vanggame.admin.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vanggame.admin.entity.Admin;
import com.vanggame.admin.service.AdminService;
import com.vanggame.admin.util.CommonConst;
import com.vanggame.admin.util.CommonMethod;

@Controller
@RequestMapping(value = "login")
public class LoginControl {
	
	@Autowired
	private AdminService adminService;

	/**
	 * login页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "admin")
	public String admin(HttpServletRequest request) {
		return "login";
	}
	
	@RequestMapping(value = "index")
	public String index(HttpServletRequest request) {
		return "index";
	}

	@RequestMapping(value = "loginCheck")
	@ResponseBody
	public Map<String, Object> login(HttpSession session,String username,String password) {
		Map<String,Object> result=new HashMap<String,Object>();
		if(CommonMethod.isBlank(username)){
			result.put(CommonConst.STRING_STATUS, 0);
			result.put(CommonConst.STRING_MSG, "请输入账号");
		}else if(CommonMethod.isBlank(password)){
			result.put(CommonConst.STRING_STATUS, 0);
			result.put(CommonConst.STRING_MSG, "请输入密码");
		}else{
			Admin admin=adminService.getByAccount(username);
			System.out.println("admin" +admin);
			if(admin==null){
				result.put(CommonConst.STRING_STATUS, 0);
				result.put(CommonConst.STRING_MSG, "该账号不存在");
			}else if(!password.equals(admin.getPassword())){
				result.put(CommonConst.STRING_STATUS, 0);
				result.put(CommonConst.STRING_MSG, "密码错误");
			}else{
				session.setAttribute(CommonConst.STRING_ADMIN, admin);
				result.put(CommonConst.STRING_STATUS, 1);
			}
		}
		return result;
	}
}
