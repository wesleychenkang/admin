package com.vanggame.admin.entity;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;

public class ChannelMaster {

	private Integer tid;

	private Integer channelId;

	private String channelName;

	private String channelDec;

	private Date createTime;

	private String createAdmin;

	
	public Integer getTid() {
		return tid;
	}


	public void setTid(Integer tid) {
		this.tid = tid;
	}


	public Integer getChannelId() {
		return channelId;
	}


	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}


	public String getChannelName() {
		return channelName;
	}


	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}


	public String getChannelDec() {
		if(null==channelDec){
			channelDec = "";
		}
		return channelDec;
	}


	public void setChannelDec(String channelDec) {
		this.channelDec = channelDec;
	}


	public Date getCreateTime() {
		if(null==createTime){
			createTime = new Date();
		}
		return createTime;
	}


	public void setCreateTime(Date createTime) {
	
		this.createTime = createTime;
	}


	public String getCreateAdmin() {
		if(null== createAdmin){
			createAdmin = "";
		}
		return createAdmin;
	}


	public void setCreateAdmin(String createAdmin) {
		this.createAdmin = createAdmin;
	}


	public JSONObject tJsonObject() {
		JSONObject json = new JSONObject();
		json.put("tid", tid);
		json.put("channelId", channelId);
		json.put("channelName", channelName);
		json.put("channelDec", channelDec);
		json.put("createTime", createTime);
		json.put("createAdmin", createAdmin);
		return json;
	}

}
