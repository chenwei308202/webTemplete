<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/tab_public.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台模板管理系统</title>
<link type="text/css" rel="stylesheet" href="${basePath}css/style.css" />
<script type="text/javascript" src="${basePath}js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${basePath }js/menu.js"></script>
</head>

<body>
<div class="top"></div>
<div id="header">
	<div class="logo">校园后台管理系统</div>
	<div class="navigation">
		<ul>
		 	<li>欢迎您！</li>
			<li><a href="">${user.userName }</a></li>
		<!-- 	<li><a href="">修改密码</a></li> -->
		<!-- 	<li><a href="">设置</a></li> -->
			<li><a href="">退出</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="left_menu">
				<ul id="nav_dot">
      
        
        <c:forEach items="${menusList }" var="menu" varStatus="i">
	        <li>
	          <h4 class="M${i.index+1}"><span></span>${menu.menuName }</h4>
	         
		          <div class="list-item none">
			            <c:forEach items="${menu.subMenus }" var="subMenu">
			            	<a href='${subMenu.menuUrl }' target="main">${subMenu.menuName }</a>
			          	</c:forEach>
		          </div>
	        </li>
        </c:forEach>
        
        
        
  </ul>
		</div>
		<div class="m-right">
			<div class="right-nav">
					<ul>
							<li><img src="images/home.png"></li>
								<li style="margin-left:25px;">您当前的位置：</li>
								<li><a href="#">系统公告</a></li>
								<li>></li>
								<li><a href="#">最新公告</a></li>
						</ul>
			</div>
			<div class="main">
				<iframe   name="main" width="100%" height="100%" src=" " frameborder="0"  seamless></iframe>
			</div>
		</div>
</div>
<div class="bottom"></div>
<div id="footer"><p>Copyright©  2015 版权所有 京ICP备05019125号-10  来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p></div>
<script>navList(12);</script>
</body>
</html>
