package com.company.bean;

import java.sql.Timestamp;

/**
 * @author CJF
 * @category 评论类
 */
public class Comment {
	/**
	 * 评论编号
	 */
	private int id;
	/**
	 * 评论人编号
	 */
	private int uid;
	/**
	 * 博客编号
	 */
	private int bid;
	/**
	 * 评论时机器ip
	 */
	private String ip;
	/**
	 * 日期
	 */
	private Timestamp datetime;
	/**
	 * 评论内容
	 */
	private String content;

	public Comment() {
		super();
	}

	public Comment(int uid, int bid, String ip, Timestamp datetime, String content) {
		super();
		this.uid = uid;
		this.bid = bid;
		this.ip = ip;
		this.datetime = datetime;
		this.content = content;
	}

	public Comment(int id, int uid, int bid, String ip, Timestamp datetime, String content) {
		super();
		this.id = id;
		this.uid = uid;
		this.bid = bid;
		this.ip = ip;
		this.datetime = datetime;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
