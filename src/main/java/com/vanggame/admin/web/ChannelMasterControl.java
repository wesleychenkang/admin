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
	public String getAllChannelMaster(Integer channelId, String channelName, Integer page, Integer rows) {
		System.out.println("masterId" + channelId + "masterName = " + channelName);
		List<ChannelMaster> count = masterService.getAllChannelMaster(null, null, null, null);
		List<ChannelMaster> list = masterService.getAllChannelMaster(channelId, channelName, page, rows);
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		for (ChannelMaster channelMaster : list) {
			array.add(channelMaster);
		}
		json.put("rows", array);
		json.put("total", count.size());
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
