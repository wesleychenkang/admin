package com.vanggame.admin.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.vanggame.admin.entity.Admin;
import com.vanggame.admin.entity.PayWay;
import com.vanggame.admin.service.PayWayService;

@Controller
@RequestMapping(value = "/admin/payway")
public class PayWayControl extends BaseControl {

	@Autowired
	private PayWayService payWayService;

	@RequestMapping(value = "showPayWay")
	public String showPayWay() {
		return "payWay";
	}

	@RequestMapping(value = "getAllPayWay")
	@ResponseBody
	public String getAllPayWay() {
		System.out.println("start");
		List<PayWay> list = payWayService.getAllPayWay();
		JSONArray array = new JSONArray();
		for (PayWay p : list) {
			array.add(p.tJsonObject());
		}

		return array.toJSONString();
	}

	@RequestMapping(value = "savePayWay")
	@ResponseBody
	public String savePayWay(PayWay payWay, HttpSession session) {
		try {
			Admin admin = getSessionAdmin(session);
			payWay.setUpdateTime(new Date());
			payWay.setPermission(admin.getUsername());
			payWayService.addPayWay(payWay);
			return renderState(true, "add success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return renderState(false, "add fail");
	}

}
