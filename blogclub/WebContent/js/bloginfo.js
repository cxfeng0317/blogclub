/**
 * 博客详情js
 */
var current_user_id;
$(function() {
	current_user_id = $("#current_user_id").val();
	console.log(current_user_id);
	comment_select();
});

/**
 * 查询博客评论信息
 */
function comment_select() {
	var bid_param = $("#bid").val();
	console.log(bid_param);
	$.getJSON("comment.action", {
		type : 1,
		bid : bid_param
	}, function(data) {
		console.log(data);
		var html = "";
		if (data.list.length == 0) {
			html += "<div class='comment_author'>还没有人</div>";
			html += "<div class='comment_text'>快来抢沙发！</div>";
		} else {
			$.each(data.list, function(i, comment) {
				html += "<div class='comment_author'><span>" + (i + 1)
						+ "楼</span><span>" + comment.userName + "</span><span>"
						+ comment.datetimeStr + "</span>";
				if (current_user_id != null && current_user_id == comment.uid) {
					html += "<span><a style='cursor: pointer;' onclick='commnet_delete(" + comment.id
							+ "," + comment.bid + ")'>删除</a></span>";
				}
				html += "</div>";
				html += "<div class='comment_text'>" + comment.content
						+ "</div>";
			});
		}
		console.log(html);
		$("#comment").html(html);
	});
}

/**
 * 提交评论校验
 */
function check() {
	var comment = $("#comment_content").val();
	var uid = $("#current_user_id").val();
	if (comment == "") {
		alert("内容不能为空");
		return false;
	}
	if (uid == "") {
		alert("用户未登录");
		return false;
	}
	return true;
}
/**
 * 提交评论
 */
function comment_submit() {
	var commnet_param = $("#comment_content").val();
	var bid_param = $("#bid").val();
	var uid_param = $("#current_user_id").val();
	if (check()) {
		$.getJSON("comment.action", {
			type : 2,
			content : commnet_param,
			uid : uid_param,
			bid : bid_param
		}, function(data) {
			var flag = data.flag;
			console.log(flag)
			if (flag) {
				comment_select();
				$("#comment_content").val("");
			}
		});
	}

}
/**
 * 提交评论
 */
function commnet_delete(id_param, bid_param) {
	$.getJSON("comment.action", {
		type : 3,
		id : id_param,
		bid : bid_param
	}, function(data) {
		var flag = data.flag;
		if (flag) {
			comment_select();
		}
	});
}