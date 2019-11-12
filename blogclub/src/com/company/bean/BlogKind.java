package com.company.bean;

/**
 * @author CJF
 * @category 博客类型类
 */
public class BlogKind {
	/**
	 * 博客类型编号
	 */
	private int id;
	/**
	 * 博客类型名称
	 */
	private String name;

	public BlogKind() {
		super();
	}

	public BlogKind(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
