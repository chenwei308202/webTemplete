<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/tab_public.jsp" %>
<html>
<head>
<title>学校通知</title>
<link type="text/css" rel="stylesheet" href="${basePath}css/style.css" />


<style>
	.add{
	border-bottom: 1px solid #000;
	width: 100%;
	margin: 0px 0px 20px 0px;
	padding: 0px;
	height: 50px;
	line-height: 50px;
		
	}


</style>
</head>
<body>

		<div class="table-margin">
				<div class="add">
				 <a href="${basePath}notices/toadd.do"> <input type="button" value="发布通知" ></a>
				</div>
		
               <table class="table table-bordered table-header">
               	<thead>
                  <tr>
                    <td class="w60">标题</td>
                    <td class="w10">时间</td>
                    <td class="w10">状态</td>
                    <td class="w10">操作</td>
                  </tr>
                  </thead>
                  <tbody>
                  
                  <c:forEach items="${pageList.list }" var="notice" >
                  
                  <tr>
                   <td><a href="${basePath}notices/${notice.id}.do" > ${notice.noticeHead }</a></td>
                   <td>
                   
                   ${notice.dateStr }
                   </td>
                   <td>
                   
                   ${notice.statusDesc }
                   </td>
                   <td>
                   
                   <c:if test="${notice.isDel == 0 }">
                   	下架
                   </c:if>
                   <c:if test="${notice.isDel == 1 }">
                   	正常展示
                   </c:if>
                   </td>
                  </tr>
                  
                  </c:forEach>
                  
                  </tbody>
               </table>
         </div>
</body>
</html>