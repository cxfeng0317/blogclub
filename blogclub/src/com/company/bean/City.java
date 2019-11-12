package com.company.bean;

/**
 * @author CJF
 * @category 市（自治区）类
 */
public class City {
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 市（自治区）主键
	 */
	private String cityID;
	/**
	 * 城市名称
	 */
	private String city;
	/**
	 * 省份编号
	 */
	private String provinceID;

	public City() {
		super();
	}

	public City(int id, String cityID, String city, String provinceID) {
		super();
		this.id = id;
		this.cityID = cityID;
		this.city = city;
		this.provinceID = provinceID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityID() {
		return cityID;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvinceID() {
		return provinceID;
	}

	public void setProvinceID(String provinceID) {
		this.provinceID = provinceID;
	}
}
