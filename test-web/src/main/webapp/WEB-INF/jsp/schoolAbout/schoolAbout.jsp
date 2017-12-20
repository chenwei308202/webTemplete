<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/tab_public.jsp" %>
<html>
<head>
<title>学校概况介绍</title>
<link type="text/css" rel="stylesheet" href="${basePath}css/style.css" />
</head>
<body>

			<div class="table-margin">
			
				<form action="${basePath}/updateSchool.do">
				
				
                          <table class="table table-bordered table-header">
                          	<thead>
                             <tr>
                               <td class="w60">标题</td>
                               <td class="w10"><input type="text" name="headName" value="${schoolIntroduce.headName}"></td>
                             </tr>
                             </thead>
                             <tbody>
                             <tr>
                              <td>学校图片</td>
                              <td>
                              <img src="${schoolIntroduce.schoolImg}" >
                              
                              <input type="hidden" name="schoolImg" value="${schoolIntroduce.schoolImg}">
                              <input type="hidden" name="id" value="${schoolIntroduce.id}">
                              <input type="hidden" name="status" value="${schoolIntroduce.status}">
                              
                              </td>
                             </tr>
                             <tr>
                              <td>学校简介</td>
                              <td>
								<textarea rows="10" cols="50" name="textBody">
								${schoolIntroduce.textBody}
								</textarea>

								</td>
                             </tr>
                             <tr>
                              <td> <input type="submit" value="提交"> </td>
                             
                             </tr>
                             </tbody>
                          </table>
                          
                  </form>
          </div>



</body>
</html>