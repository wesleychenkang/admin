package com.vanggame.admin.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanggame.admin.dao.AdminDao;
import com.vanggame.admin.entity.Admin;
@Service
public class AdminService {
    
	@Autowired
	private AdminDao aDao;
	
	public Admin getByAccount(String account){
		return aDao.queryByAccount(account);
	}
	
	private boolean login(String name, String password) {

		return false;
	}

}
