package com.vanggame.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.NativeWebRequest;

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

		System.out.println("test2====" + list.size());
	}

	@org.junit.Test
	public void test3() {

		PayWayChannel channel = new PayWayChannel();
		channel.setChannelMasterId(3008);
		channel.setChannelScid("test");
		channel.setCreateTime(new Date());
		channel.setUpdateTime(new Date());
		channel.setGameId(10008);
		channel.setPermission("wesley");
		channel.setVachar(false);
		channel.setSdkVer("1234");
		pwService.savePayWayChannel(channel);

		System.out.println("channel" + channel.getTid());

	}

	@org.junit.Test
	public void test4() {
		List<String> types = new ArrayList<String>();
		types.add("1");
		types.add("2");
		types.add("3");
		pwService.savePayVsChannel(types, 3);

	}

}
