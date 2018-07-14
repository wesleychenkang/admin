package com.vanggame.admin.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanggame.admin.dao.PayWayDao;
import com.vanggame.admin.entity.PayWay;

@Service
public class PayWayService {

	@Autowired
	private PayWayDao payWayDao;

	public List<PayWay> getAllPayWay() {
		List<PayWay> list = payWayDao.getAllPayWay();
		return list;
	}

	public void addPayWay(PayWay payWay) {
		PayWay way = null;
		if (null!=payWay.getTid()) {
			
			way = payWayDao.queryPayWay(payWay.getTid());
			System.out.println(way.toString());
			
		}
		Date date = new Date();
		if (null == way) {
			//新增的操作
			payWay.setCreateTime(date);
			payWay.setUpdateTime(date);
			payWayDao.savePayWay(payWay);
		} else {
			//更新的操作
			way.setUpdateTime(date);
			payWayDao.updatePayWay(way);
		}
	}

}
