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
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	function delete_sure(param) {
		var flag = confirm("确定删除" + param + "号用户？");
		if (flag) {
			window.location = "delete.action?id=" + param;
		}
	}
</script>
</head>
<body>
	<!-- 引入导航栏 -->
	<c:import url="header.jsp"></c:import>
	<!-- 内容模块1 -->
	<div class="d2 allwidth">
		<h1>博客列表</h1>
		<table class="table table-hover">
			<caption>基本的表格布局</caption>
			<tr>
				<th>作者</th>
				<th>标题</th>
				<th>类型</th>
				<th>发表时间</th>
				<th>浏览量</th>
			</tr>
			<c:forEach items="${list}" var="blogs">
				<tr>
					<td><a href="personblogschemalist.action?uid=${blogs.uid }">作者：${blogs.userName} <a></td>
					<td><a href="bloginfo.action?id=${blogs.id }">标题：${blogs.title }</a></td>
					<td><a href="bloglist.action?type=2&kid=${blogs.kid }">${blogs.blogKindName }</a></td>
					<fmt:parseDate value="${blogs.datetime}" var="blogsdatetime"
						pattern="yyyy-MM-dd HH:mm:ss" />
					<fmt:formatDate value="${blogsdatetime}" var="blogsdate"
						pattern="yyyy-MM-dd" />
					<td>${blogsdate }</td>
					<td>${blogs.clicks }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!--内容部分结束-->
	<!-- 引入底部信息 -->
	<c:import url="footer.jsp"></c:import>
</body>
</html>