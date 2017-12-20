<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html><head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="keywords" content="基础教育语文研究中心">
		<meta name="description" content="陕西师范大学基础教育语文研究中心">
		<title>基础教育语文研究中心</title>
		<link rel="stylesheet" type="text/css" href="${basePath}css/style1.css">
		<link rel="stylesheet" type="text/css" href="${basePath}css/popup.css">
	</head>
	<body>
		<!--header start-->
		<div class="header_wrap">
			<div class="header">
				<span class="wel_word fl">欢迎访问复兴小学官方网站！</span>
				<span class="corner fr">
					<ul>
						<li><a href="upload.html">上传</a>|</li>
						<li><a href="register.html">注册</a>|</li>
						<li class="login_li"><a href="javascript:void(0);" class="tc">登录</a></li>
						<li class="user_li nLi on">
							<a href="javascript:void(0);">登录名</a>
							<div class="user_handle">
								<a href="personal.html">个人中心</a>
								<a href="ownTopic.html">我的话题</a>
								<a href="javascript:void(0);">退出</a>
							</div>
						</li>
					</ul>
					<div class="clear"></div>
				</span>
				<div class="clear"></div>
			</div>
			<div id="gray"></div>				
			<div class="popup" id="popup" style="cursor: default; top: 20.3px; left: 559.3px;">				
				<div class="top_nav" id="top_nav">
					<div align="center">
						<i></i>
						<span>登录账号</span>
						<a class="guanbi"></a>
					</div>
				</div>					
				<div class="min">					
					<div class="tc_login">											
						<div class="login_register">
							<form method="POST" name="form_login" target="_top">
								<div align="center">
									<span class="error">错误提示</span>
									<i class="icon-mobile-phone"></i>
									<input name="name" id="name" required="required" placeholder="用户名" autocomplete="off" class="input_yh" type="text">
									<input name="pass" id="pass" required="required" placeholder="密码" autocomplete="off" class="input_mm" type="password">
								</div>
								<dd>
									<div class="user">
										<input name="user" id="user" value="记住用户" class="r_user" type="checkbox">记住用户
										<a href="password.html" target="_blank">忘记密码？</a>
									</div>
								</dd>
								<div align="center">
									<input class="button" title="Sign In" value="登录" type="submit">
								</div>
								<dd>
									<div align="center"><a href="register.html" target="_blank">立即注册！</a></div>
								</dd>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
		<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
		<script src="js/jquery.SuperSlide.2.1.js" type="text/javascript"></script>
		<script src="js/common.js"></script>
		<script type="text/javascript">
			jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });
			jQuery(".notice").slide({mainCell:".bd ul",autoPage:true,effect:"top",autoPlay:true,vis:1});
			jQuery(".schoolmate .b_wrap").slide({titCell:".hd ul",mainCell:".bd ul",autoPage:true,effect:"left",autoPlay:true,vis:5,trigger:"click"});
		</script>
	

</body></html>