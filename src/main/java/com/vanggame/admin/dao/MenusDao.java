package com.vanggame.admin.dao;

import java.util.List;

import com.vanggame.admin.entity.Menus;

public interface MenusDao {
	
	List<Menus> getAllMenus();
	
	void save(Menus menus);
	
	

}
