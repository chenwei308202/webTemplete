<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html><head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="keywords" content="基础教育语文研究中心">
		<meta name="description" content="陕西师范大学基础教育语文研究中心">
		<title>基础教育语文研究中心</title>
		<link rel="stylesheet" type="text/css" href="${basePath}css/style1.css">
		<link rel="stylesheet" type="text/css" href="${basePath}css/popup.css">
		<script type="text/javascript" src="${basePath }js/jquery-1.11.0.min.js?ran=<%=Math.random()%>"></script>		
		<script>
        
        //抓取公信宝数据
        $(function(){
        	
        	$.ajax({
        		url:'${basePath}navData.do',
        	    type:'POST', 
        	    dataType:"json",
        	    success:function(data){
        	        console.info(data);
        	        var innerStr="";
        	        if(data.length>0){
	        	        $.each(data,
	                            function(index, value) {
	                               
	        	        			innerStr+= "<li class='nLi'><h3><a href='"+"#"+"'>" +value.menuName+ "</a></h3>";
	        	        			if(value.subMenus.length>0){
	        	        				var innerSub="<ul class='sub' style='display: none;'>";
	        	        				$.each(value.subMenus,function(subIndex, subValue){
	        	        					innerSub+="<li><a href='news.html'>"+subValue.menuName+"</a></li>";
	        	        				});
	        	        				innerSub+="</ul>";
	        	        				innerStr+=innerSub;
	        	        			}else{
	        	        				innerStr+="</li>";
	        	        			}
	                            });
	        	        
	        	        $("#nav").find("li").append(innerStr);
        	        }
        	    }
        	})
        	
        	
        })
        
        
    </script>
        
	</head>
	<body>
		<!--nav start-->
		<div class="nav_menu">
			<a href="index.html" class="logo fl"><img src="images/logo.png"></a>
			<div class="nav_list fr">
				<ul id="nav" class="nav clearfix">
					<li class="nLi on"></li>
						<%--   <c:forEach items="${menusList }" var="menu" varStatus="i">
							  <li class="nLi">
								<h3><a href="news.html">${menu.menuName }</a></h3>
								<ul class="sub" style="display: none;">
										<c:forEach items="${menu.subMenus }" var="subMenu">
											<li><a href="news.html">${subMenu.menuName }</a></li>
										</c:forEach>
								</ul>
							</li>
				         </c:forEach> --%>
				</ul>
			</div>
			<div class="clear"></div>
		</div>

</body></html>