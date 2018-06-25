package com.vanggame.admin.service;

import java.util.List;

import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanggame.admin.dao.AdminRoleDao;
import com.vanggame.admin.entity.AdminRole;
import com.vanggame.admin.entity.Menus;

@Service
public class AdminRoleService {
	
	@Autowired
	private AdminRoleDao roleDao;
	
	
	public List<AdminRole> getAllAdminRoles(){
		
		return roleDao.getAllAdminRoles();
	}
	public  AdminRole getAdminRoleByID(Integer adminRoleID ) {
		return roleDao.getAdminRoleByID(adminRoleID);
	}
	
	public void addAdminRole(AdminRole role){
		roleDao.saveAdminRole(role);
	}
	
	public void deleteAdminRole(Integer adminRoleID ){
		roleDao.deleteAdminRole(adminRoleID);
		
	}
	
    //指定角色是否有对应的功能权限
    public boolean hasPermission(AdminRole role, Menus menu){
        if(role == null || menu == null){
            return  false;
        }

        String[] menus = null;
        if(!TextUtils.isEmpty(role.getPermission())){
            menus = role.getPermission().split(",");
        }

        if(menus != null){
            for(String mid : menus){
                if(menu.getId().equals(Integer.valueOf(mid))
                        || menu.getParentID().equals(Integer.valueOf(mid))){
                    return true;
                }
            }
        }

        return  false;
    }
	

}
