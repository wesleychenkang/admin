package com.vanggame.admin.web;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.vanggame.admin.entity.Admin;
import com.vanggame.admin.util.CommonConst;

public class BaseControl {
	
	public String renderState(boolean suc, String msg) {
		JSONObject json = new JSONObject();
		json.put("state", suc ? 1 : 0);
		json.put("msg", msg);
		return json.toJSONString();
	}
	
	
	
	public Admin getSessionAdmin(HttpSession session){
		Admin admin = (Admin)session.getAttribute(CommonConst.STRING_ADMIN);
		return admin;
	}
}
