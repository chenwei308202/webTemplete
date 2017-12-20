package com.chen.controller.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.util.JSONUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.chen.bean.Menu;
import com.chen.bean.Page;
import com.chen.bean.SchoolIntroduce;
import com.chen.service.usercenter.MenuSettingService;
import com.chen.service.usercenter.SchoolIntroduceService;
import com.chen.service.usercenter.SchoolNoticeService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class FrontController {
	
	@Autowired
	private SchoolIntroduceService schoolIntroduceService;
	@Autowired
	private MenuSettingService menuSettingService;
	@Autowired
	private SchoolNoticeService schoolNoticeService;
	
	

	@RequestMapping("/schoolindex")
	public String index(HttpServletRequest request,HttpServletResponse response,Model model){
		
		
		SchoolIntroduce schoolIntroduce = schoolIntroduceService.getSchoolIntroduce();
		
		//导航页
		List<Menu> menus= menuSettingService.getDisplayMenuList();
		//通知公告
		Page page=new Page();
		page=schoolNoticeService.getNoticeByPage(page);
		
		
		
		
		model.addAttribute("schoolIntroduce", schoolIntroduce);
		model.addAttribute("schoolNotices", page.getList());
		model.addAttribute("menusList", menus);
		
		return "index";
	}
	@RequestMapping("/navData")
	@ResponseBody
	public String navData(HttpServletRequest request,HttpServletResponse response,Model model){
		
		response.setCharacterEncoding("text/html;charset=utf-8");
		//导航页
		List<Menu> menus= menuSettingService.getDisplayMenuList();
		String jsonString= JSONArray.fromObject(menus).toString();
		System.out.println(jsonString);
		return jsonString ;
	}
}
