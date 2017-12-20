package com.chen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.bean.Menu;
import com.chen.bean.User;
import com.chen.service.usercenter.MenuSettingService;
import com.chen.service.usercenter.UserCenterService;


@Controller
public class UserCenterController {
	
	@Autowired
	private UserCenterService userCenterService;
	@Autowired
	private MenuSettingService menuSettingService;
	
	@RequestMapping("/index")
	public String login(HttpServletRequest request,HttpServletResponse response){
	    String userName=request.getParameter("name");
	    String password=request.getParameter("password");
		
		User user=userCenterService.getUserByUserName(userName);
		if (user!=null && StringUtils.isNotBlank(password) && password.equals(user.getPassword())) {
			
			List<Menu> menuList= menuSettingService.getTopMenuList();
			request.setAttribute("menusList", menuList);
			request.setAttribute("user", user);
			return "WEB-INF/jsp/index";
		}
		
		
		
		return null;
	}

	
	
}
