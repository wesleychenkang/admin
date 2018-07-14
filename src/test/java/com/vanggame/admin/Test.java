package com.vanggame.admin;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vanggame.admin.entity.Admin;
import com.vanggame.admin.entity.PayWay;
import com.vanggame.admin.entity.PayWayChannel;
import com.vanggame.admin.service.AdminService;
import com.vanggame.admin.service.PayWayChannelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext.xml" })
public class Test {
	@Autowired
	private AdminService admin;

	@Autowired
	private PayWayChannelService pwService;

	@org.junit.Test
	public void test() {
		// fail("Not yet implemented");
		// System.out.println("test okd");
		List<Admin> all = admin.queryAllAccount();
		System.out.println("test" + all.size());
	}

	@org.junit.Test
	public void test2() {
		System.out.println("======");
		List<PayWayChannel> list = pwService.getAllPayWayChannel();
		
		for (int i = 0; i < list.size(); i++) {
			List<PayWay> w = list.get(0).getPayWay(); 
			System.out.println(w.get(0).getPayWayName());
			System.out.println(list.get(i).tJsonObject());
		}
		
		System.out.println("test2===="+list.size());
	}
	
	
	@org.junit.Test
	public void test3(){
		
		System.out.println("count="+ pwService.getAllPayChannelCount());
	}

}
