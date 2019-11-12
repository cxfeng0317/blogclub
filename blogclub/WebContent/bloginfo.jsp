<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title></title>
<!-- 引入 Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="js/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="js/bootstrap.min.js"></script>
<link href="css/style.css" rel="stylesheet" />
<script src="js/bloginfo.js"></script>
</head>
<body>
	<!-- 引入导航栏 -->
	<c:import url="header.jsp"></c:import>
	<!--中间内容部分开始-->
	<div class="container allwidth">
		<h1>blog info</h1>
		<div class="templatemo-container bloginfo">
			<h3 style="font-size: 32px;">${blog.title }</h3>
			<div id="content" class="content">

				<!-- content start -->
				${blog.content }
				<!-- end -->
			</div>
			<!-- 评论开始 -->
			<div class="commentboth">
				<h5 class="comment_title">文章评论</h5>
				<!-- 需要循环的评论内容 -->
				<div id="comment" class="comment"></div>
				<!-- 循环结束 -->
			</div>
			<!-- 评论结束 -->
			<div class="tocomment">
				<input type="hidden" id="bid" value="${blog.id }"> <input
					type="hidden" id="current_user_id" value="${current_user.id }">
				<c:if test="${current_user!=null }">
					<span>发表评论</span>
					<textarea id="comment_content"></textarea>
					<button onclick="comment_submit()" class="btn btn-success">submit</button>
				</c:if>
				<c:if test="${current_user==null }">
					<p>
						还未登录，点击<a href="login.jsp">登录</a>
					</p>
				</c:if>
			</div>
		</div>

	</div>
	<!--内容部分结束-->
	<!-- 引入底部信息 -->
	<c:import url="footer.jsp"></c:import>
</body>
</html>