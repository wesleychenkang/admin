package com.vanggame.admin.dao;

import java.util.List;

import com.vanggame.admin.entity.PayWay;

public interface PayWayDao {

	public List<PayWay> getAllPayWay();

	public void savePayWay(PayWay payWay);

	public void updatePayWay(PayWay payWay);

	public void deletePayWay(Integer id);

	public PayWay queryPayWay(Integer id);

}
