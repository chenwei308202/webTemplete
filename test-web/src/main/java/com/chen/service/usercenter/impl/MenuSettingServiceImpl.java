package com.chen.service.usercenter.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.bean.Menu;
import com.chen.dao.MenuDao;
import com.chen.service.usercenter.MenuSettingService;
@Service
public class MenuSettingServiceImpl implements MenuSettingService {

	@Autowired
	private MenuDao menuDao;
	
	public List<Menu> getMenuList() {
		return menuDao.queryBy(null);
	}

	public List<Menu> getTopMenuList() {
		Menu menu =new Menu();
		menu.setMenuLevel(1);
		return menuDao.queryTopMenus(menu);
	}

	public List<Menu> getDisplayMenuList() {
		Menu menu =new Menu();
		menu.setNavStatus(1);
		menu.setMenuLevel(1);
		return  menuDao.queryTopMenus(menu);
	}

}
