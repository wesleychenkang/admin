package com.vanggame.admin.entity;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;

/**
 * 试一下
 * @author chen
 *
 */
public class AdminRole {
	
	private Integer id; // ID,唯一，主键
	private String roleName; // 权限角色名称
	private String roleDesc; // 权限角色描述
	private String permission; // 权限
	private Date createTime; // 创建时间
	private Integer creatorID; // 创建人(管理员)
	private Integer topRole; // 是否为最高权限(如果为1，则所有功能，所有游戏都可以管理)
	
	   public JSONObject toJSON(){
	        JSONObject json = new JSONObject();
	        json.put("id", id);
	        json.put("roleName", roleName);
	        json.put("roleDesc", roleDesc);
	        json.put("permission", permission);
	        json.put("topRole", topRole);
	        return json;
	    }
   
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreatorID() {
		return creatorID;
	}

	public void setCreatorID(Integer creatorID) {
		this.creatorID = creatorID;
	}

	public Integer getTopRole() {
		return topRole;
	}

	public void setTopRole(Integer topRole) {
		this.topRole = topRole;
	}

}
