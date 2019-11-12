package com.company.bean;

import java.sql.Timestamp;

/**
 * @author CJF
 * @category 博客类
 */
public class Blog {
	/**
	 * 博客编号
	 */
	private int id;
	/**
	 * 类型表外键（类型标号）
	 */
	private int kid;
	/**
	 * 用户表外键（用户编号）
	 */
	private int uid;
	/**
	 * 名称
	 */
	private String title;
	/**
	 * 概要
	 */
	private String schema;
	/**
	 * 详情
	 */
	private String content;
	/**
	 * 点击量
	 */
	private int clicks;
	/**
	 * 博客发表时间
	 */
	private Timestamp datetime;

	public Blog() {
	}

	public Blog(int kid, int uid, String title, String schema, String content, int clicks, Timestamp datetime) {
		super();
		this.kid = kid;
		this.uid = uid;
		this.title = title;
		this.schema = schema;
		this.content = content;
		this.clicks = clicks;
		this.datetime = datetime;
	}

	public Blog(int id, int kid, int uid, String title, String schema, String content, int clicks, Timestamp datetime) {
		super();
		this.id = id;
		this.kid = kid;
		this.uid = uid;
		this.title = title;
		this.schema = schema;
		this.content = content;
		this.clicks = clicks;
		this.datetime = datetime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

}
