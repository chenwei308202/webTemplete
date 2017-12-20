<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/tab_public.jsp" %>
<html>
<head>
<title>学校概况介绍</title>
<link type="text/css" rel="stylesheet" href="${basePath}css/style.css" />
</head>
<body>

			<div class="table-margin">
			
				<form action="${basePath}notices/update.do" method="post">
				
				
                          <table class="table table-bordered table-header">
                          	<thead>
                             <tr>
                               <td class="w60">标题</td>
                               <td class="w10"><input type="text" value="${notice.noticeHead }" name="noticeHead" ></td>
                             </tr>
                             </thead>
                             <tbody>
                             <tr>
                              <td>通知图片</td>
                              <td>
                              <img src="${notice.imgSrc }" height="100px" height="100px">
                              
                             <input name="imgsrc" type="hidden" value="${notice.imgSrc }"> 
                              
                              </td>
                             </tr>
                             <tr>
                              <td>通知内容</td>
                              <td>
								<textarea rows="10" cols="50" name="noticeBody">
								${notice.noticeBody}
								</textarea>
								<input type="hidden" value="${notice.id}">
								</td>
                             </tr>
                             <tr>
                              <td colspan="2"> <input type="submit" value="提交"> </td>
                             
                             </tr>
                             </tbody>
                          </table>
                          
                  </form>
          </div>



</body>
</html>