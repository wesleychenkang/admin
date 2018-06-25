package com.vanggame.admin.web;

import com.alibaba.fastjson.JSONObject;

public class BaseControl {
	
	public String renderState(boolean suc, String msg) {
		JSONObject json = new JSONObject();
		json.put("state", suc ? 1 : 0);
		json.put("msg", msg);
		return json.toJSONString();
	}
}
