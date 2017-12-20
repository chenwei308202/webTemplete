package com.chen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.bean.SchoolIntroduce;
import com.chen.service.usercenter.SchoolIntroduceService;

@Controller
public class AboutSchoolController {

	@Autowired
	private SchoolIntroduceService schoolIntroduceService;
	
	@RequestMapping("/aboutSchool")
	public String abountSchoolIndex(HttpServletRequest request,HttpServletResponse response){
		
		SchoolIntroduce schoolIntroduce = schoolIntroduceService.getSchoolIntroduce();
		
		request.setAttribute("schoolIntroduce", schoolIntroduce);
	    return "WEB-INF/jsp/schoolAbout/schoolAbout";
	}
	
	
	@RequestMapping("/updateSchool")
	public String modifySchoolAbout(HttpServletRequest request,HttpServletResponse response,SchoolIntroduce schoolIntroduce){
		schoolIntroduce= schoolIntroduceService.updateSchoolIntroduce(schoolIntroduce );
		
		request.setAttribute("schoolIntroduce", schoolIntroduce);
		return "WEB-INF/jsp/schoolAbout/schoolAbout";
	}
	
	
	
}
