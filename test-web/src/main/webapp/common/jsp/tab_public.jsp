<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String contextPath = request.getContextPath();
	String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath;
	String ctx = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + request.getContextPath();
	request.setAttribute("path",  contextPath+"/");
	request.setAttribute("basePath",  contextPath+"/");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<%-- <script type="text/javascript" src="${basePath }common/js/jquery-1.10.0.min.js"></script> --%>


<%-- <link rel="stylesheet" href="${basePath }common/mian/css/main.css" type="text/css"></link> --%>
