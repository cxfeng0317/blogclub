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
<script src="js/regist.js"></script>
</head>
<body>
	<!-- 引入导航栏 -->
	<c:import url="header.jsp"></c:import>
	<!--中间内容部分开始-->
	<div class="container allwidth">
		<div class="widthtwo regist">
			<h1>注&nbsp;册&nbsp;用&nbsp;户</h1>
			<form id="form1" action="regist.action" method="post">
				<table class="t1">
					<tr>
						<td>
							username:
							<input id="name" onblur="nameBlur()" type="text" class="form-control" name="name"
								placeholder="please input your name" />
							<span id="name_exit" style="color: red;"></span>
						</td>
					</tr>
					<tr>
						<td>
							password:
							<input id="pass1" type="password" class="form-control" name="pass" />
						</td>
					</tr>
					<tr>
						<td>
							passsure:
							<input id="pass2" type="password" class="form-control" name="pass2" />
						</td>
					</tr>
					<tr>
						<td>
							age:
							<br />
							<input id="age" type="text" class="form-control" name="age"
								style="text-align: center; display: inline; width: 15%; margin-right: 8%;" />

							<input type="radio" checked="checked" name="sex" value="f" />
							female&nbsp;&nbsp;
							<input type="radio" name="sex" value="m" />
							male
						</td>
					</tr>
					<tr>
						<td>
							address:
							<br />
							<select class="form-control address" id="provincedId" name="provinceId"
								onchange="showCity(this.value)">
								<option value='0'>-prov-</option>
							</select>
							<select class="form-control address" id="cityId" name="cityId"
								onchange="showArea(this.value)">
								<option value='0'>-city-</option>
							</select>
							<select class="form-control address" id="areaId" name="areaId">
								<option value='0'>-area-</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							tel:
							<input id="tel" type="text" class="form-control" name="tel" />
						</td>
					</tr>
					<tr class="button1">
						<td align="center">
							<button type="button" onclick="check()" class="btn btn-success">submit</button>
							<button type="reset" class="btn btn-info">reset</button>
							<p style="color: red;">${mess }</p>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<!--内容部分结束-->
	<!-- 引入底部信息 -->
	<c:import url="footer.jsp"></c:import>
</body>
</html>