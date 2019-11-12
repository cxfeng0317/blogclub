<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("#into").click(
				function() {
					if ($("#name").val().trim() == ""
							|| $("#password").val().trim() == "") {
						alert("用户名、密码不能为空");
					} else {
						$("form").submit();
					}
				});
		$("#out").click(function() {
			window.location.href = "index.html";
		});
	});
	function flash() {
		$("#captcha").attr("src", "captcha.action");
	}
</script>
</head>
<body>
	<!-- 引入导航栏 -->
	<c:import url="header.jsp"></c:import>
	<!--中间内容部分开始-->
	<div class="container widthone">
		<h1>登&nbsp;&nbsp;录</h1>
		<form id="form" class="form-horizontal" role="form" action="tologin.action" method="post">
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">名字</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name" placeholder="请输入名字">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">密码</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password" name="pass" placeholder="请输入密码">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">验证码</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" style="width: 50%; float: left; display: inherit;"
						name="captcha" placeholder="请输入验证码">
					<img id="captcha" style="height: 34px;" alt="验证码" onclick="flash()" src="captcha.action">
					<span style="color: red;">${mess }</span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label>
							<input type="checkbox">
							请记住我
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button id="into" type="button" class="btn btn-success">登录</button>
					<button id="out" type="button" class="btn btn-default">退出</button>
				</div>
			</div>
		</form>
	</div>
	<!--内容部分结束-->
	<!-- 引入底部信息 -->
	<c:import url="footer.jsp"></c:import>
</body>
</html>