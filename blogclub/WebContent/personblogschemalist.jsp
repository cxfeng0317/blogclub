
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
	function delete_blog(param) {
		var flag=confirm("确定删除此篇博客？");
		if(flag){                                                                                                                                                            
			window.location = "deleteblog.action?id="+param;                                                                                                                     
		}
	}
</script>
</head>
<body>
	<!-- 引入导航栏 -->
	<c:import url="header.jsp"></c:import>
	<!-- 内容模块1 -->
	<div class="d2 allwidth">
		<!--用户信息-->
		<div id="userinfo" class="templatemo-container userinfo">
			<ul>
				<li><span class="glyphicon glyphicon-user">：${user.name }</span></li>
				<li><span class="glyphicon glyphicon-tree-conifer">：</span> <c:if
						test="${user.sex=='f'}">♀</c:if>&nbsp; <c:if
						test="${user.sex!='f'}">♂</c:if></li>
				<li><span class="glyphicon glyphicon-circle-arrow-right">：</span>${user.age }</li>
				<li><span class="glyphicon glyphicon-earphone">：${user.tel }</span></li>
				<c:if test="${current_user.id !=null}">
					<li><a href="bloglist.action?type=3&uid=${current_user.id }">click
							me into my blog</a></li>
					<li><a href="createblog.action?type=1">create blog</a></li>
				</c:if>
			</ul>
		</div>
		<!--用户博客概要列表-->
		<div class="schemalist">
			<table class="table table-hover bloglist">
				<tr class="personbloginfo_tr">
					<th style="width: 10%;">作者</th>
					<th>标题</th>
					<th>时间</th>
				</tr>
				<!--要循环的博客概要-->
				<c:forEach items="${list }" var="blog">
					<tr class="personbloginfo_tr">
						<td class="line"><a
							href="bloglist.action?type=3&uid=${blog.uid }">${blog.userName }</a></td>
						<td class="line"><span class="schema_title">${blog.title }</span>
						</td>
						<td class="line"><span class="schema_time">时间： <fmt:parseDate
									value="${blog.datetime }" var="blogdatetime"
									pattern="yyyy-MM-dd HH:mm:ss" /> <fmt:formatDate
									value="${blogdatetime }" var="date" pattern="yyyy-MM-dd" />
								${date }
						</span> <c:if test="${current_user.id == user.id }">
								<span class="blogedit"> <a
									onclick="delete_blog(${blog.id })" style="cursor: pointer;">删除</a>&nbsp;|&nbsp;
									<a href="editblog.action?type=1&id=${blog.id }">编辑</a>
								</span>
							</c:if></td>
					</tr>
					<tr class="personbloginfo_tr">
						<td class="layout" colspan="3"><a
							href="bloginfo.action?id=${blog.id }"> ${blog.schema } </a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<!--内容部分结束-->
	<!-- 引入底部信息 -->
	<c:import url="footer.jsp"></c:import>
</body>
</html>