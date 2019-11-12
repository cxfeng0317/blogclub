package com.company.vo;

import com.company.bean.Comment;

public class CommentVO extends Comment {
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 博客名称
	 */
	private String blogName;
	/**
	 * 发布时间（字符串格式）
	 */
	private String datetimeStr;

	public String getDatetimeStr() {
		return datetimeStr;
	}

	public void setDatetimeStr(String datetimeStr) {
		this.datetimeStr = datetimeStr;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}


}
