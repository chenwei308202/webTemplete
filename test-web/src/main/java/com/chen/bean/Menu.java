package com.chen.bean;

import java.util.Date;
import java.util.List;

public class Menu {

	
	private Integer id;
	
	private String menuName;
	
	private String menuUrl;
	
	private Integer parentId;
	
	private Integer menuLevel; 
	
	private Integer navStatus;
	
	private Date createDate;
	
	private List<Menu> subMenus;
	
	
	
	

	public Integer getNavStatus() {
		return navStatus;
	}

	public void setNavStatus(Integer navStatus) {
		this.navStatus = navStatus;
	}

	public List<Menu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<Menu> subMenus) {
		this.subMenus = subMenus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
