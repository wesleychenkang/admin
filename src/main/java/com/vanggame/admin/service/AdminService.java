package com.vanggame.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanggame.admin.dao.AdminDao;
import com.vanggame.admin.entity.Admin;
import com.vanggame.admin.entity.AdminRole;
import com.vanggame.admin.log.Log;

@Service
public class AdminService {

	@Autowired
	private AdminDao aDao;
	
	@Autowired
	private AdminRoleService roleService;

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

	
	 public List<String> getPermissonedGameIDs( Admin admin){
	        AdminRole role = roleService.getAdminRoleByID(admin.getAdminRoleID());
	        
	        if(role.getTopRole() != null && role.getTopRole().equals(1)){ //topRole 代表是管理人员具有最高权限
	            return null;
	        }
	        if(admin.getAdminGames() != null){
	            String[] ids = admin.getAdminGames().split(",");
	            List<String> all = new ArrayList<String>();
	            for(int i=0; i<ids.length;i++){
	                all.add(ids[i]);
	            }
	            return all;
	        }
	        return null;
	    }


}
