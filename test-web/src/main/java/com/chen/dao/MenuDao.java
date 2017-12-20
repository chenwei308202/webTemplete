package com.chen.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chen.bean.Menu;
@Repository
public interface MenuDao {

	List<Menu> queryBy(Menu menu);
	
	List<Menu>  queryTopMenus(Menu menu);

}
