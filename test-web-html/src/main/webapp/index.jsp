<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/tab_public.jsp" %>
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
		<%@include file="header.jsp" %>
		<!--nav start-->
		<%@include file="nav.jsp" %>
		<!--banner start-->
		<div class="banner">
			<div class="bd">
				<ul style="position: relative; width: 1519px; height: 350px;">
					<li class="first" style="position: absolute; width: 1519px; left: 0px; top: 0px; display: none;"><a href="javascript:void(0);"></a></li>
					<li class="second" style="position: absolute; width: 1519px; left: 0px; top: 0px; display: none;"><a href="javascript:void(0);"></a></li>
					<li class="third" style="position: absolute; width: 1519px; left: 0px; top: 0px; display: none;"><a href="javascript:void(0);"></a></li>
					<li class="fourth" style="position: absolute; width: 1519px; left: 0px; top: 0px; display: list-item;"><a href="javascript:void(0);"></a></li>
				</ul>
			</div>
			<div class="hd"><ul><li class="">1</li><li class="">2</li><li class="">3</li><li class="on">4</li></ul></div>
		</div>
		<!--notice start-->
		<div class="notice_wrap">
			<div class="notice">
				<div class="bd fl">
					<b>通知公告：</b>
					<div class="tempWrap" style="overflow:hidden; position:relative; height:45px">
					<ul class="infoList" style="position: relative; padding: 0px; margin: 0px; top: -90px;">
					
					
						<c:forEach items="${schoolNotices}" var="notice">
							<li style="height: 45px;"><span class="date">${notice.dateStr }</span><a href="${basePath}notices/front/${notice.id}.do">${notice.noticeHead }</a></li>
						</c:forEach>
						<!-- <li style="height: 45px;"><span class="date">[2016-05-05]</span><a href="nDetail.html">通知公告名称通知公告名称，通知公告名称通知公告名称通知公告，名称通知公告名...</a></li>
						<li style="height: 45px;"><span class="date">[2016-05-05]</span><a href="nDetail.html">通知公告名称通知公告名称，通知公告名称通知公告名称通知公告...</a></li>
						<li style="height: 45px;"><span class="date">[2016-05-05]</span><a href="nDetail.html">通知公告名称通知公告名称，通知公告名称通知公告名称</a></li>
						<li style="height: 45px;"><span class="date">[2016-05-05]</span><a href="nDetail.html">通知公告名称通知公告名称，通知公告名称通知公告名称通知公告，名称通知公告名名称通知公告名...</a></li> -->
					</ul>
					</div>
				</div>
				<a href="notice.html" class="more fr">更多+</a>
				<div class="clear"></div>
			</div>
		</div>
		<!--content start-->
		<div class="content">
			<!--about、news and hot-->
			<div class="box1">
				<div class="fl">
					<div class="about">
						<div class="b_title">
							<h3>中心概况</h3>
							<a href="about.html" class="more">更多+</a>
						</div>
						<div class="b_wrap">
							<div class="a_img fl">
								<img src="images/about.jpg">
							</div>
							<div class="a_text fl">
								<p>基础教育语文研究中心基础，教育语文研究中心基础教育语文，研究中心基础教育语文研究中心基础教育语文研究中心。基础教育语文研究中心基础，教育语文研究中心基础教育语文，研究中心基础教育语文研究中心基础教育语文研究中心。基础教育语文研究中心基础，教育语文研究中心基础教育语文，研究中心基础教育语文研究中心基础教育语文研究中心。</p>
								<p>基础教育语文研究中心基础，教育语文研究中心基础教育语文，研究中心基础教育语文研究中心基础教育语文研究中心。基础教育语文研究中心基础，教育语文研究中心基础教育语文，研究中心基础教育语文研究中心基础教育语文研究中心...</p>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="news">
						<div class="b_title">
							<h3>新闻热点</h3>
							<a href="news.html" class="more">更多+</a>
						</div>
						<div class="b_wrap">
							<div class="fl n_list">
								<h4>教育 · 新闻</h4>
								<ul>
									<li class="special">
										<div class="n_img">
											<img src="images/n1.jpg">
										</div>
										<div class="n_text">
											<b>新闻标题新闻标题新闻标题新闻标题</b>
											<p>新闻标题新闻标题新闻标题新闻,标题新,标题新闻标题新闻标题新闻标题...<a href="nDetail.html" class="detail">详细</a></p>
										</div>
									</li>
									<li><a href="nDetail.html">新闻标题新闻标题新闻标题新闻</a></li>
									<li><a href="nDetail.html">新闻标题新闻标题新闻标题新闻</a></li>
									<li><a href="nDetail.html">新闻标题新闻标题新闻标题新闻</a></li>
								</ul>
							</div>
							<div class="fr n_list">
								<h4>工作 · 动态</h4>
								<ul>
									<li class="special">
										<div class="n_img">
											<img src="images/n2.jpg">
										</div>
										<div class="n_text">
											<b>新闻标题新闻标题新闻标题新闻标题</b>
											<p>闻标题新闻标题新闻标题新闻标题新闻,标题新闻标题新闻标题新闻标题...<a href="nDetail.html" class="detail">详细</a></p>
										</div>
									</li>
									<li><a href="nDetail.html">新闻标题新闻标题新闻标题新闻</a></li>
									<li><a href="nDetail.html">新闻标题新闻标题新闻标题新闻</a></li>
									<li><a href="nDetail.html">新闻标题新闻标题新闻标题新闻</a></li>
								</ul>
							</div>
							<div class="clear"></div>
						</div>
					</div>
				</div>
				<div class="hot fr">
					<div class="b_title">
						<h3>热门话题</h3>
						<a href="topic.html" class="more">更多+</a>
					</div>
					<div class="b_wrap">
						<ul>
							<li>
								<div class="h_img">
									<img src="images/favicon.jpg">
								</div>
								<div class="h_text">
									<b><a href="tDetail.html">话题名称话题名称话题名称</a></b>
									<p>话题名称话题名称话题名称,话题名称话题名称话题名称...<a href="tDetail.html" class="detail">详细</a></p>
								</div>
							</li>
							<li>
								<div class="h_img">
									<img src="images/favicon.jpg">
								</div>
								<div class="h_text">
									<b><a href="tDetail.html">话题名称话题名称话题名称</a></b>
									<p>话话题名称话题名称话名称,话题名称话题名称话题名称...<a href="tDetail.html" class="detail">详细</a></p>
								</div>
							</li>
							<li>
								<div class="h_img">
									<img src="images/favicon.jpg">
								</div>
								<div class="h_text">
									<b><a href="tDetail.html">话题名称话题名称话题名称</a></b>
									<p>话题名称话称话题名称,话题名称话题名称话题名称...<a href="tDetail.html" class="detail">详细</a></p>
								</div>
							</li>
							<li>
								<div class="h_img">
									<img src="images/favicon.jpg">
								</div>
								<div class="h_text">
									<b><a href="tDetail.html">话题名称话题名称话题名称</a></b>
									<p>话题名称称话题名称,话题名称话题名称话题名称...<a href="tDetail.html" class="detail">详细</a></p>
								</div>
							</li>
							<li>
								<div class="h_img">
									<img src="images/favicon.jpg">
								</div>
								<div class="h_text">
									<b><a href="tDetail.html">话题名称话题名称话题名</a></b>
									<p>题名称话题名称话题名称话题名称话题名称...<a href="tDetail.html" class="detail">详细</a></p>
								</div>
							</li>
							<li>
								<div class="h_img">
									<img src="images/favicon.jpg">
								</div>
								<div class="h_text">
									<b><a href="tDetail.html">话题名称话题名称话题名称话</a></b>
									<p>名称话题名称话题名称,话题名称话题名话题名称...<a href="tDetail.html" class="detail">详细</a></p>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<!--teachers and course-->
			<div class="box2">
				<div class="teachers fl">
					<div class="b_title">
						<h3>名师风采</h3>
						<a href="teachers.html" class="more">更多+</a>
					</div>
					<div class="b_wrap">
						<div class="fl n_list">
							<h4>名师 · 资源</h4>
							<ul>
								<li><a href="tcDetail.html">论文标题论文标题论文标题论文标题</a></li>
								<li><a href="tcDetail.html">论文标题论文标题论文标题论文标题</a></li>
								<li><a href="tcDetail.html">论文标题论文标题论文标题论文标题</a></li>
								<li><a href="tcDetail.html">论文标题论文标题论文标题论文标题</a></li>
								<li><a href="tcDetail.html">论文标题论文标题论文标题论文标题</a></li>
							</ul>
						</div>
						<div class="fr n_list">
							<h4>名师 · 推荐</h4>
							<ul>
								<li><a href="tcDetail.html">人名：课程名称课程名称课程名称</a></li>
								<li><a href="tcDetail.html">人名：课程名称课程名称课程名称</a></li>
								<li><a href="tcDetail.html">人名：课程名称课程名称课程名称</a></li>
								<li><a href="tcDetail.html">人名：课程名称课程名称课程名称</a></li>
								<li><a href="tcDetail.html">人名：课程名称课程名称课程名称</a></li>
							</ul>
						</div>
						<div class="clear"></div>
						<div class="t_list">
							<h4>名师 · 简介</h4>
							<ul>
								<li><a href="tDetail.html"><img src="images/t1.jpg"><span>老师</span></a></li>
								<li><a href="tDetail.html"><img src="images/t2.jpg"><span>老师</span></a></li>
								<li><a href="tDetail.html"><img src="images/t1.jpg"><span>老师</span></a></li>
								<li><a href="tDetail.html"><img src="images/t2.jpg"><span>老师</span></a></li>
								<li><a href="tDetail.html"><img src="images/t1.jpg"><span>老师</span></a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="course fr">
					<div class="b_title">
						<h3>课程改革</h3>
						<a href="course.html" class="more">更多+</a>
					</div>
					<div class="b_wrap">
						<div class="n_list">
							<div class="intro">
								<img src="images/course.jpg">
								<p>课程改革简介课程改革简介，课程改革简介课程改革简介课程改革，简介课程改革简介课程改革简介课程改革简介，课程改革简介课程改革简介...<a href="nDetail.html" class="detail">详细</a></p>
							</div>
							<ul>
								<li><a href="tcDetail.html">课程名称</a></li>
								<li><a href="tcDetail.html">课程名称课程名称</a></li>
								<li><a href="tcDetail.html">课程名称</a></li>
								<li><a href="tcDetail.html">课程名称课程名称</a></li>
								<li><a href="tcDetail.html">课程名称</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<!--schoolmate-->
			<div class="schoolmate">
				<div class="b_title">
					<h3>学生风采</h3>
					<a href="schoolmate.html" class="more">更多+</a>
				</div>
				<div class="b_wrap">
					<div class="hd">
						<a class="next"></a>
						<a class="prev"></a>
					</div>
					<div class="s_list bd">
						<div class="tempWrap" style="overflow:hidden; position:relative; width:1075px"><ul style="width: 1505px; position: relative; overflow: hidden; padding: 0px; margin: 0px; left: -214.119px;">
							<li style="float: left; width: 204.4px;"><a href="tDetail.html"><img src="images/ac1.jpg"><span>活动名称</span></a></li>
							<li style="float: left; width: 204.4px;"><a href="tDetail.html"><img src="images/ac2.jpg"><span>活动名称</span></a></li>
							<li style="float: left; width: 204.4px;"><a href="tDetail.html"><img src="images/ac1.jpg"><span>活动名称</span></a></li>
							<li style="float: left; width: 204.4px;"><a href="tDetail.html"><img src="images/ac2.jpg"><span>活动名称</span></a></li>
							<li style="float: left; width: 204.4px;"><a href="tDetail.html"><img src="images/ac1.jpg"><span>活动名称</span></a></li>
							<li style="float: left; width: 204.4px;"><a href="tDetail.html"><img src="images/ac1.jpg"><span>活动名称</span></a></li>
							<li style="float: left; width: 204.4px;"><a href="tDetail.html"><img src="images/ac2.jpg"><span>活动名称</span></a></li>
						</ul></div>
					</div>
				</div>
			</div>
			<!--resource and exam-->
			<div class="box3">
				<div class="resource fl">
					<div class="b_title">
						<h3>教学资源</h3>
						<a href="resource.html" class="more">更多+</a>
					</div>
					<div class="b_wrap">
						<div class="fl n_list">
							<h4>文献 · 资料</h4>
							<ul>
								<li><a href="tcDetail.html">文献名称文献名称文献名称文献名称</a></li>
								<li><a href="tcDetail.html">文献名称文献名称文献名称文献名称</a></li>
								<li><a href="tcDetail.html">文献名称文献名称文献名称文献名称</a></li>
								<li><a href="tcDetail.html">文献名称文献名称文献名称文献名称</a></li>
								<li><a href="tcDetail.html">文献名称文献名称文献名称文献名称</a></li>
							</ul>
						</div>
						<div class="fr n_list">
							<h4>学习 · 资料</h4>
							<ul>
								<li><a href="tcDetail.html">资料名称资料名称资料名称资料名称</a></li>
								<li><a href="tcDetail.html">资料名称资料名称资料名称资料名称</a></li>
								<li><a href="tcDetail.html">资料名称资料名称资料名称资料名称</a></li>
								<li><a href="tcDetail.html">资料名称资料名称资料名称资料名称</a></li>
								<li><a href="tcDetail.html">资料名称资料名称资料名称资料名称</a></li>
							</ul>
						</div>
						<div class="clear"></div>
						<div class="t_list">
							<h4>教学 · 视频</h4>
							<ul>
								<li><a href="tcDetail.html"><img src="images/v1.jpg"></a></li>
								<li><a href="tcDetail.html"><img src="images/v1.jpg"></a></li>
								<li><a href="tcDetail.html"><img src="images/v1.jpg"></a></li>
								<li><a href="tcDetail.html"><img src="images/v1.jpg"></a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="exam fr">
					<div class="b_title">
						<h3>考试安排</h3>
						<a href="exam.html" class="more">更多+</a>
					</div>
					<div class="b_wrap">
						<div class="n_list">
							<ul>
								<li><a href="eDetail.html">课程名称</a><span class="plan">2016-06-06&nbsp;&nbsp;10:00-12:00(上午)</span></li>
								<li><a href="eDetail.html">课程名称课程名称</a><span class="plan">2016-06-06&nbsp;&nbsp;10:00-12:00(上午)</span></li>
								<li><a href="eDetail.html">课程名称</a><span class="plan">2016-06-06&nbsp;&nbsp;10:00-12:00(上午)</span></li>
								<li><a href="eDetail.html">课程名称课程名称</a><span class="plan">2016-06-06&nbsp;&nbsp;10:00-12:00(上午)</span></li>
								<li><a href="eDetail.html">课程名称</a><span class="plan">2016-06-06&nbsp;&nbsp;10:00-12:00(上午)</span></li>
								<li><a href="eDetail.html">课程名称</a><span class="plan">2016-06-06&nbsp;&nbsp;10:00-12:00(上午)</span></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<!--friendly link-->
			<div class="friendlink">
				<b>友情链接：</b><a href="">友情链接</a><a href="">友情链接</a><a href="">友情链接</a><a href="">友情链接</a><a href="">友情链接</a>
			</div>
		</div>
		<!--footer start-->
		<%@include file="footer.jsp" %>
		<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
		<script src="js/jquery.SuperSlide.2.1.js" type="text/javascript"></script>
		<script src="js/common.js"></script>
		<script type="text/javascript">
			jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });
			jQuery(".notice").slide({mainCell:".bd ul",autoPage:true,effect:"top",autoPlay:true,vis:1});
			jQuery(".schoolmate .b_wrap").slide({titCell:".hd ul",mainCell:".bd ul",autoPage:true,effect:"left",autoPlay:true,vis:5,trigger:"click"});
		</script>
	

</body></html>