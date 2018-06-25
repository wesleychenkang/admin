package com.vanggame.admin.entity;

public class Game {
	
	private Integer tid;
	private Integer aid;
	private String key;
	private String app_screte;
	private String dec;
	private Integer g_type;
	private String h5_url;
	private String pay_callback;

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

	public String getApp_screte() {
		return app_screte;
	}

	public void setApp_screte(String app_screte) {
		this.app_screte = app_screte;
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

}
