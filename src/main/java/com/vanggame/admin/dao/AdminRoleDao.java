package com.vanggame.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vanggame.admin.entity.AdminRole;

public interface AdminRoleDao {

	public List<AdminRole> getAllAdminRoles();

	AdminRole getAdminRoleByID(Integer adminRoleID);

	void saveAdminRole(AdminRole role);
	
	void deleteAdminRole(Integer adminRoleID);
	
	void updateAdminRole(@Param("adminRoleID")String adminRoleID,@Param("rolePermission")String rolePermission);


}
