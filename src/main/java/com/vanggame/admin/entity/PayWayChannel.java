package com.vanggame.admin.entity;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.vanggame.admin.util.TimeUtils;

/**
 * 支付方式类
 * 
 * @author wesley
 *
 */
public class PayWayChannel {

	private Integer tid; // 自动增长主键

	private List<PayWay> payWay;

	private Integer gameId;

	private String sdkVer;

	private Integer channelMasterId;

	private String channelScid;

	private Game game;

	private JSONObject payWays;

	private boolean vachar;

	private String permission; // 添加者

	private Date createTime;

	private Date updateTime;
	
	public JSONObject tJsonObject(){
		JSONObject json = new JSONObject();
		json.put("tid", tid);
		json.put("gameId", gameId);
		json.put("sdkVer", sdkVer);
		json.put("channelMasterId", channelMasterId);
		json.put("channelScid", channelScid);
		json.put("payWays",""+ getPayWays());
		json.put("permission", permission);
		json.put("createTime",TimeUtils.format_default(createTime) );
		json.put("updateTime",TimeUtils.format_default(updateTime));
		return json;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public List<PayWay> getPayWay() {
		return payWay;
	}

	public void setPayWay(List<PayWay> payWay) {
		this.payWay = payWay;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public JSONObject getPayWays() {
		System.out.println("=== getPayWays getPayWay()" + getPayWay().size());
		StringBuilder sb = new StringBuilder();
		for (PayWay p : getPayWay()) {
			sb.append(p.getPayWayId()).append(",");
		}
		if (sb.toString().length() > 0) {
			sb.toString().substring(0, sb.toString().length() - 1);
		}
		JSONObject json = new JSONObject();
		json.put("types", sb.toString());
		int r = vachar ? 1 : 0;
		json.put("voucher", r + "");
		
		return json;
	}

	public void setPayWays(JSONObject payWays) {
		this.payWays = payWays;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
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

	public boolean isVachar() {
		return vachar;
	}

	public void setVachar(boolean vachar) {
		this.vachar = vachar;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getSdkVer() {
		return sdkVer;
	}

	public void setSdkVer(String sdkVer) {
		this.sdkVer = sdkVer;
	}

	public Integer getChannelMasterId() {
		return channelMasterId;
	}

	public void setChannelMasterId(Integer channelMasterId) {
		this.channelMasterId = channelMasterId;
	}

	public String getChannelScid() {
		return channelScid;
	}

	public void setChannelScid(String channelScid) {
		this.channelScid = channelScid;
	}


	@Override
	public String toString() {
		return "PayWayChannel [tid=" + tid +  ", payWay=" + payWay + ", gameId="
				+ gameId + ", sdkVer=" + sdkVer + ", channelMasterId=" + channelMasterId + ", channelScid="
				+ channelScid + ", game=" + game + ", payWays=" + getPayWays() + ", vachar=" + vachar + ", permission="
				+ permission + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
    
	
	
}
