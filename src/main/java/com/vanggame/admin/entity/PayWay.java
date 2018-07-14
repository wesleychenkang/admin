package com.vanggame.admin.entity;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.vanggame.admin.util.TimeUtils;

public class PayWay {

	private Integer tid; // 主键

	private Integer payWayId; // 支付ID

	private String payWayName;// 支付名称

	private Date createTime; // 创建时间

	private Date updateTime; // 更新时间

	private String permission; // 创建者

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getPayWayId() {
		return payWayId;
	}

	public void setPayWayId(Integer payWayId) {
		this.payWayId = payWayId;
	}

	public String getPayWayName() {
		return payWayName;
	}

	public void setPayWayName(String payWayName) {
		this.payWayName = payWayName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public JSONObject tJsonObject() {
		JSONObject json = new JSONObject();
		json.put("tid", tid);
		json.put("payWayId", payWayId);
		json.put("payWayName", payWayName);
		System.out.println("createTime="+createTime);
		json.put("createTime", TimeUtils.format_default(createTime));
		json.put("updateTime", TimeUtils.format_default(updateTime));
		json.put("permission", permission);
		return json;
	}

	@Override
	public String toString() {
		return "PayWay [tid=" + tid + ", payWayId=" + payWayId + ", payWayName=" + payWayName + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", permission=" + permission + "]";
	}
	
	

}
