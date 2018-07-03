package com.vanggame.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.vanggame.admin.entity.ChannelMaster;
import com.vanggame.admin.service.ChannelMasterService;

@Controller
@RequestMapping(value = "admin/channelMaster")
public class ChannelMasterControl extends BaseControl {

	@Autowired
	private ChannelMasterService masterService;

	@RequestMapping(value = "getAllChannelMaster")
	@ResponseBody
	public String getAllChannelMaster(Integer masterId, String masterName, Integer page, Integer rows) {
		System.out.println("masterId" + masterId + "masterName = " + masterName);
		List<ChannelMaster> list = masterService.getAllChannelMaster(masterId, masterName, page, rows);
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		for (ChannelMaster channelMaster : list) {
			array.add(channelMaster);
		}
		json.put("rows", array);
		json.put("total", list.size());
		System.out.println(json.toJSONString());
		return json.toJSONString();
	}

	@RequestMapping(value = "showChannelMasters")
	public String showChannelMasters() {

		return "channelMaster";

	}

	@RequestMapping(value = "saveMaster")
	@ResponseBody
	public String saveMaster(ChannelMaster master) {
		try {
			masterService.saveChannelMaster(master);
			return renderState(true, "add success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return renderState(false, "add fail");
	}

	@RequestMapping(value = "removeMaster")
	@ResponseBody
	public String removeMaster(Integer currMasterID,String channelName ) {
		try {
			System.out.println("channelId="+currMasterID + "channelName" + channelName);
			masterService.removeChannelMaster(currMasterID);
			return renderState(true, "remove success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return renderState(false, "remove fail");

	}

}
