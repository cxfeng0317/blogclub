<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript">
	var num = 3;
	$(function() {
		back_index();
	});
	function back_index() {
		if (num > 0) {
			$("#num").html(num);
			setTimeout("back_index()", 1000);
			num--;
		} else {
			window.location.href = "index.html";
		}
	}
</script>
</head>
<body>
	<!-- 引入导航栏 -->
	<c:import url="header.jsp"></c:import>

	<!--中间内容部分开始-->

	<div class="container fourzerofour">
		<p>
			<span style="color: red;">${mess }</span>
		</p>
		<p>
			<span style="color: red;" id="num"></span>秒后：跳转<a href="index.html">首页</a>
		</p>
		<img src="img/404.jpg" />
	</div>
	<!--内容部分结束-->

	<!-- 脚部 -->
	<!-- 引入底部信息 -->
	<c:import url="footer.jsp"></c:import>
	<!-- 脚部结束 -->
</body>

</html>