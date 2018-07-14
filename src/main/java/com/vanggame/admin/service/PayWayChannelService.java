package com.vanggame.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanggame.admin.dao.PayWayChannelDao;
import com.vanggame.admin.entity.PayWayChannel;

@Service
public class PayWayChannelService {

	@Autowired
	PayWayChannelDao payWayChannelDao;

	public List<PayWayChannel> getAllPayWayChannel() {
		return payWayChannelDao.queryAllPayWayChannel();
	}

	public int getAllPayChannelCount() {

		return payWayChannelDao.queryAllPayWayChannelCount();
	}
}
