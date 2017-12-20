package com.chen.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.chen.bean.Menu;
import com.chen.bean.Notice;
import com.chen.bean.Page;
import com.chen.service.usercenter.MenuSettingService;
import com.chen.service.usercenter.SchoolNoticeService;

@Controller
public class SchoolNoticeController {

	@Autowired
	private SchoolNoticeService schoolNoticeService;
	@Autowired
	private MenuSettingService menuSettingService;
	
	@RequestMapping("/notices")
	public String getNoticeList(HttpServletRequest request,HttpServletResponse response,Page page,Model model){
		
		page = schoolNoticeService.getNoticeByPage(page);
		
		model.addAttribute("pageList", page);
		return "WEB-INF/jsp/schoolNotice/schoolNotice";
	};
	
	@RequestMapping("/notices/toadd")
	public String toAddNoticePage(HttpServletRequest request,HttpServletResponse response){
		
		return "WEB-INF/jsp/schoolNotice/addNotice";
	};
	
	@RequestMapping("/notices/{id}")
	public String toViewNoticePage(HttpServletRequest request,HttpServletResponse response,@PathVariable Integer id){
		System.out.println(id);
		Notice notice= schoolNoticeService.getNoticeById(id);
		request.setAttribute("notice",notice );
		return "WEB-INF/jsp/schoolNotice/noticeView";
	};
	@RequestMapping("/notices/front/{id}")
	public String toViewNoticeFront(HttpServletRequest request,HttpServletResponse response,@PathVariable Integer id){
		System.out.println(id);
		Notice notice= schoolNoticeService.getNoticeById(id);
		request.setAttribute("notice",notice );
		//导航页
		List<Menu> menus= menuSettingService.getDisplayMenuList();
		request.setAttribute("menusList", menus);
		return "nDetail";
	};
	@RequestMapping("/notices/update")
	public String toupdateNoticePage(HttpServletRequest request,HttpServletResponse response,Notice notice){
		
		schoolNoticeService.updateNotice(notice);	
		
		return "forward:/notices.do";
	};
	
	
	
	@RequestMapping("/notices/add")
	public String doAddNoticePage(HttpServletRequest request,HttpServletResponse response,Notice notice,@RequestParam("imgsrc")CommonsMultipartFile file ){
		
	 String fileOriginalName=	file.getOriginalFilename();
	 System.out.println(fileOriginalName);
	 
	 String webPath=request.getServletContext().getRealPath("/images");
	 
	 String filePath=webPath+"/notice/";
	 
	 File fileParent=new File(filePath);
	 
	 if (!fileParent.exists()) {
		 fileParent.mkdirs();
	 }
	 String imgName= System.currentTimeMillis()+fileOriginalName.substring( fileOriginalName.lastIndexOf("."));
	 String absoluteSrc=filePath+ imgName;
	 File fileImg=new File(absoluteSrc);
	 
	 try {
		file.transferTo(fileImg);
	} catch (IllegalStateException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	 
	 notice.setImgSrc(request.getContextPath()+"/images/notice/"+imgName);
	 notice.setCreateDate(new Date());
	 notice.setIsDel(0);
	 
	 schoolNoticeService.addNotice(notice);	
	 
		return "forward:/notices.do";
	};
	
}
