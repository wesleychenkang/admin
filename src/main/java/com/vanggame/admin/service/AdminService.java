package com.vanggame.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanggame.admin.dao.AdminDao;
import com.vanggame.admin.entity.Admin;
import com.vanggame.admin.log.Log;

@Service
public class AdminService {

	@Autowired
	private AdminDao aDao;

	public Admin getByAccount(String account) {
		return aDao.queryByAccount(account);
	}

	public List<Admin> queryAllAccount() {

		return aDao.queryAllAccount();
	}

	public void saveAdmin(Admin admin) {

		System.out.println("admin" + admin);

		aDao.addAdmin(admin);
	}

	public void updateAdmin(Admin admin) {
		aDao.updateAdmin(admin);
	}

	public void removeAdmin(Admin admin) {

		Log.d("delete admin" + admin.getId());

		aDao.deleteAdminById(admin.getId());
	}

	private boolean login(String name, String password) {

		return false;
	}

}
