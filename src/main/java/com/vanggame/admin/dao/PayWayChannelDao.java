package com.vanggame.admin.dao;

import java.util.List;

import com.vanggame.admin.entity.PayWayChannel;

public interface PayWayChannelDao {

	public List<PayWayChannel> queryAllPayWayChannel();

	public int queryAllPayWayChannelCount();

	public void addPayWayChannel(PayWayChannel way);

	public void removePayWayChannel();

	public void updatePayWayChannel();

}
