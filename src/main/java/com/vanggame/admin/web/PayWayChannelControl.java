package com.vanggame.admin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.vanggame.admin.entity.PayWayChannel;
import com.vanggame.admin.service.PayWayChannelService;

@Controller
@RequestMapping(value = "/admin/payway")
public class PayWayChannelControl extends BaseControl {

	@Autowired
	PayWayChannelService payWayService;

	@RequestMapping(value = "payWayChannel")
	public String payWayChannel() {
		return "payWayChannel";
	}

	@RequestMapping(value = "getAllPayWayChannel")
	@ResponseBody
	public String getAllPayWayChannel() {
		JSONObject json = new JSONObject();
		List<PayWayChannel> all = payWayService.getAllPayWayChannel();
		JSONArray array = new JSONArray();
		for (PayWayChannel channel : all) {
			array.add(channel.tJsonObject());
		}
		json.put("rows", array);
		json.put("total", payWayService.getAllPayChannelCount());
		return json.toString();
	}

	@RequestMapping(value = "savePayWayChannnel")
	public void savePayWayChannel(HttpServletRequest request) {
		String ali = request.getParameter("ali");
		System.out.println("ali" + ali);

	}

}
