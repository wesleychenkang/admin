package com.vanggame.admin.entity;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Menus {

	private Integer id; // ID,唯一，主键

	private String name; // 名称
	private Integer parentID; // 父功能ID
	private String path; // 相对url
	private Date createTime; // 创建时间
	private List<Menus> children;
	
	
	
	 public JSONObject toJSON(){
	        JSONObject json = new JSONObject();
	        json.put("id", id);
	        json.put("name", name);
	        json.put("path", path);
	        json.put("parentID", parentID);

	        if(children != null && children.size() > 0){
	            JSONArray array = new JSONArray();
	            for(Menus m : children){
	                array.add(m.toJSON());
	            }
	            json.put("children", array);
	        }

	        return json;
	    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<Menus> getChildren() {
		return children;
	}

	public void setChildren(List<Menus> children) {
		this.children = children;
	}
	
	
	

}
