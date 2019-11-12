<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--导航栏盒子-->
<div class="d1">
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid allwidth">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">欢迎来到博客园</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="index.html">网站首页</a></li>
					<li><a href="bloglist.action?type=1">博客浏览</a></li>
					<c:if test="${sessionScope.current_user.id==1 }">
						<li><a href="userlist.action">用户列表</a></li>
					</c:if>
					<c:if test="${sessionScope.current_user.id==null }">
						<li><a href="login.jsp">登录</a></li>
						<li><a href="regist.jsp">注册</a></li>
					</c:if>
					<c:if test="${sessionScope.current_user.id!=null }">
						<li><a href="createblog.action?type=1">博客创建</a></li>
						<li><a
							href="personblogschemalist.action?uid=${current_user.id }">我的博客</a></li>
						<li><a href="logout.action">退出</a></li>
					</c:if>
					<li><a onclick="window.history.go(-1)"
						style="cursor: pointer;">返回</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> 博客类型 <b class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<c:forEach items="${blogKinds }" var="kind">
								<li><a href="bloglist.action?type=2&kid=${kind.id }">${kind.name }</a></li>
								<li class="divider"></li>
							</c:forEach>
							<!-- <li><a href="bloglist.action?type=2&kid=1">原创</a></li> -->
							<!-- <li class="divider"></li> -->
							<!-- <li><a href="bloglist.action?type=2&kid=2">经典</a></li> -->
							<!-- <li class="divider"></li> -->
							<!-- <li><a href="bloglist.action?type=2&kid=3">转载</a></li> -->
							<!--  <li class="divider"></li>  -->
							<!--  <li><a href="#">另一个分离的链接</a></li>  -->
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<!--第一个banner的内容-->
<div class="banner1">
	<div class="container">
		<h1>博客园</h1>
		<h2>博客园软件工程师的宝典，让web开发更迅速、简单。</h2>
		<p class="masthead-button-links">
			<a class="btn btn-lg btn-primary btn-shadow"
				href="https://v3.bootcss.com/css/" target="_blank" role="button"
				onclick="_hmt.push(['_trackEvent', 'masthead', 'click', 'masthead-Bootstrap3中文文档'])">Bootstrap3中文文档(v3.3.7)</a>
		</p>
		<ul class="masthead-links">
			<li><a href="https://v3.bootcss.com/css/" target="_blank"
				role="button"
				onclick="_hmt.push(['_trackEvent', 'masthead', 'click', 'masthead-Bootstrap2中文文档'])">Bootstrap2中文文档(v2.3.2)</a>
			</li>
		</ul>
	</div>
</div>
<!--热门社区-->
<div class="bc-social">
	<div class="container">
		<ul class="bc-social-buttons">
			<li class="social-forum"><a class=""
				href="http://wenda.bootcss.com" title="Bootstrap问答社区"
				target="_blank"
				onclick="_hmt.push(['_trackEvent', 'masthead', 'click', 'masthead-Bootstrap问答社区'])">
					<i class="fa fa-comments"></i> Bootstrap问答社区
			</a></li>
			<li class="social-weibo"><a href="http://weibo.com/bootcss"
				title="Bootstrap中文网官方微博" target="_blank"
				onclick="_hmt.push(['_trackEvent', 'masthead', 'click', 'masthead-新浪微博'])"><i
					class="fa fa-weibo"></i> 新浪微博：@Bootstrap中文网</a></li>
		</ul>
	</div>
</div>
