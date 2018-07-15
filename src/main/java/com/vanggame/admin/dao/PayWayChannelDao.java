package com.vanggame.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vanggame.admin.entity.PayWayChannel;

public interface PayWayChannelDao {

	public List<PayWayChannel> queryAllPayWayChannel();

	public int queryAllPayWayChannelCount();

	public void addPayWayChannel(PayWayChannel way);

	public void removePayWayChannel(Integer payWayChannelId);

	public void updatePayWayChannel(PayWayChannel way);

	public void addPayVsChannel(@Param("payWayIds") List<String> payWayIds,
			@Param("payWayChannelId") Integer payWayChannelId);

	public void removePayVsChannel(Integer payWayChannelId);

}
