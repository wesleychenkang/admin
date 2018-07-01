package com.vanggame.admin.entity;

import com.alibaba.fastjson.JSONObject;

public class Game {

	private Integer tid;
	private Integer aid;
	private String key;
	private String appSecret; // app_screte 用不了
	private String dec;
	private Integer g_type;
	private String h5_url;
	private String pay_callback;

	public JSONObject toJsonObject() {
		JSONObject json = new JSONObject();
		json.put("tid", tid);
		json.put("appID", aid);
		json.put("appkey", key);
		json.put("appSecret", appSecret);
		System.out.println("app_screte" + appSecret);
		json.put("name", dec);
		json.put("payCallback", pay_callback);
		return json;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDec() {
		return dec;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}

	public Integer getG_type() {
		return g_type;
	}

	public void setG_type(Integer g_type) {
		this.g_type = g_type;
	}

	public String getH5_url() {
		return h5_url;
	}

	public void setH5_url(String h5_url) {
		this.h5_url = h5_url;
	}

	public String getPay_callback() {
		return pay_callback;
	}

	public void setPay_callback(String pay_callback) {
		this.pay_callback = pay_callback;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

}
