package com.chen.service.usercenter;

import java.util.List;

import com.chen.bean.Menu;

public interface MenuSettingService {

	List<Menu> getMenuList();
	
	List<Menu> getTopMenuList();

	List<Menu> getDisplayMenuList();


}
