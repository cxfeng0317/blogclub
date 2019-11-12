//注册js脚本
/**
 * 输入验证
 */
function check() {
	var name = document.getElementById("name").value;
	var pass1 = document.getElementById("pass1").value;
	var pass2 = document.getElementById("pass2").value;
	var age = document.getElementById("age").value;
	var name_exit = $("#name_exit").html();
	// var tel = document.getElementById("tel").value;
	if (name.trim() == "") {
		alert("姓名不能为空！");
		return false;
	}
	if (pass1.trim() == "") {
		alert("密码不能为空！");
		return false;
	}
	if (pass1 != pass2) {
		alert("两次密码输入不一致！");
		return false;
	}
	if (age.trim() == "") {
		alert("年龄不能为空！");
		return false;
	}
	// if (tel == null || tel.trim() == "") {
	// alert("电话不能为空！");
	// }
	if (name_exit != "") {
		alert("姓名已被占用！");
		return false;
	} else {
		document.getElementById("form1").submit();
	}

}
/**
 * 姓名检查是否重复
 */
function nameBlur() {
	var n = $("#name").val();
	console.log(n);
	$.ajax({
		type : "post",
		url : "check.action",
		data : {
			name : n
		},
		success : function(result) {
			console.log(result);
			if (result == "true") {
				$("#name_exit").html("");
			} else {
				$("#name_exit").html("名字已存在");
			}
		},
		dataType : "text"
	});
}

/**
 * 页面加载显示所有省份
 */
$(function() {
	$.post("pca.action", {
		type : 1
	}, function(result) {
		console.log(result);
		var html = "<option value='0'>-prov-</option>";
		$.each(result.list, function(i, data) {
			html += "<option value='" + data.provinceID + "'>" + data.province
					+ "</option>";
		});
		$("#provincedId").html(html);
	}, "json");
});
/**
 * 根据省份id查询市
 * 
 * @param pid
 */
function showCity(pid) {
	$.post("pca.action", {
		type : 2,
		provinceId : pid
	}, function(result) {
		var html = "<option value='0'>-city-</option>";
		$.each(result.list, function(i, data) {
			html += "<option value='" + data.cityID + "'>" + data.city
					+ "</option>";
		});
		$("#cityId").html(html);
	}, "json");
	showArea(0);
}

/**
 * 根据市份id查询区
 * 
 * @param cid
 */
function showArea(cid) {
	$.post("pca.action", {
		type : 3,
		cityId : cid
	}, function(result) {
		var html = "<option value='0'>-area-</option>";
		$.each(result.list, function(i, data) {
			html += "<option value='" + data.areaID + "'>" + data.areas
					+ "</option>";
		});
		$("#areaId").html(html);
	}, "json");
}
