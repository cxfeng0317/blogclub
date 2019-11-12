
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
		var flag=confirm("确定删除"+param+"号用户？");
		if(flag){                                                                                                                                                            
			window.location = "delete.action?id="+param;                                                                                                                     
		}
	}
</script>
</head>
<body>
	<!-- 引入导航栏 -->
	<c:import url="header.jsp"></c:import>
	<!-- 内容模块1 -->
	<div class="d2 allwidth">
		<h1>用户列表</h1>
		<table class="table table-hover">
			<caption>基本的表格布局</caption>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>电话号码</th>
				<th>地址</th>
				<th>注册时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${requestScope.list }" var="user">
				<tr>
					<td><a href="#">${user.id }<a></td>
					<td><a href="#">作者：${user.name }</a></td>
					<td><a href="#"> <c:if test="${user.sex=='f' }">女 </c:if>
							<c:if test="${user.sex=='m' }">男 </c:if>
					</a></td>
					<td>${user.age }</td>
					<td>${user.tel }</td>
					<td>${user.provinceId }-${user.cityId }-${user.areaId }</td>
					<fmt:parseDate value="${user.inputdate }" var="pinputdate"
						pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
					<fmt:formatDate value="${pinputdate }" var="date"
						pattern="yyyy-MM-dd" />
					<td>${date }</td>
					<td><a onclick="delete_sure(${user.id })"
						style="cursor: pointer;">删除</a>&nbsp;&nbsp;<a href="#">编辑</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!--内容部分结束-->
	<!-- 引入底部信息 -->
	<c:import url="footer.jsp"></c:import>
</body>
</html>