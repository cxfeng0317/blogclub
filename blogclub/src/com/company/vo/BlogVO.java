package com.company.vo;

import com.company.bean.Blog;

public class BlogVO extends Blog {
	/**
	 * 博客作者姓名
	 */
	private String userName;
	/**
	 * 博客类型名称
	 */
	private String blogKindName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBlogKindName() {
		return blogKindName;
	}

	public void setBlogKindName(String blogKindName) {
		this.blogKindName = blogKindName;
	}

}
