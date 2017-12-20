<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/tab_public.jsp" %>
<html>
<head>
<title>学校概况介绍</title>
<link type="text/css" rel="stylesheet" href="${basePath}css/style.css" />
</head>
<body>

			<div class="table-margin">
			
				<form action="${basePath}notices/add.do" enctype="multipart/form-data" method="post">
				
				
                          <table class="table table-bordered table-header">
                          	<thead>
                             <tr>
                               <td class="w60">标题</td>
                               <td class="w10"><input type="text" name="noticeHead" ></td>
                             </tr>
                             </thead>
                             <tbody>
                             <tr>
                              <td>通知图片</td>
                              <td>
                              
                              
                             <input name="imgsrc" type="file"> 
                              
                              </td>
                             </tr>
                             <tr>
                              <td>通知内容</td>
                              <td>
								<textarea rows="10" cols="50" name="noticeBody">
								${schoolIntroduce.textBody}
								</textarea>

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