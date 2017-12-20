package com.chen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.bean.Menu;
import com.chen.service.usercenter.MenuSettingService;

/**
 * 
 * @Description   菜单管理
 * @date   2017年12月12日 下午5:35:48
 * @author chenwei
 *
 */

@Controller
public class MenuController {

	@Autowired
	private MenuSettingService menuSettingService;
	
	@RequestMapping("/menus")
	public String login(HttpServletRequest request,HttpServletResponse response){
		
		
		List<Menu> menuList= menuSettingService.getTopMenuList();
		request.setAttribute("menuList", menuList);
	    return null;
	}
}
