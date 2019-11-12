package com.company.bean;

import java.sql.Timestamp;

/**
 * @author CJF
 * @category 用户信息类
 */
public class User {
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 密码
	 */
	private String pass;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 电话
	 */
	private String tel;
	/**
	 * 省（直辖市）代码
	 */
	private String provinceId;
	/**
	 * 市（自治区）代码
	 */
	private String cityId;
	/**
	 * 区（县）代码
	 */
	private String areaId;
	/**
	 * 注册时间
	 */
	private Timestamp inputdate;
	/**
	 * 注册时机器IP
	 */
	private String ip;

	public User() {
		super();
	}

	public User(String name, String pass, String sex, int age, String tel, String provinceId, String cityId,
			String areaId, Timestamp inputdate, String ip) {
		super();
		this.name = name;
		this.pass = pass;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.areaId = areaId;
		this.inputdate = inputdate;
		this.ip = ip;
	}

	public User(int id, String name, String pass, String sex, int age, String tel, String provinceId, String cityId,
			String areaId, Timestamp inputdate, String ip) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.areaId = areaId;
		this.inputdate = inputdate;
		this.ip = ip;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public Timestamp getInputdate() {
		return inputdate;
	}

	public void setInputdate(Timestamp inputdate) {
		this.inputdate = inputdate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
