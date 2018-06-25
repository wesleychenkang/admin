package com.vanggame.admin.dao;

import java.util.List;

import com.vanggame.admin.entity.Admin;

public interface AdminDao {
	
	Admin queryByAccount(String account);
	
	void addAdmin(Admin admin);
	
	void deleteAdminById(Integer id);
	
	List<Admin> queryAllAccount();
	
	void updateAdmin(Admin admin);
	
	
	
}
