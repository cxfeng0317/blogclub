package com.company.bean;

/**
 * @author CJF
 * @category 区（县）类
 */
public class Area {
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 区县主键
	 */
	private String areaID;
	/**
	 * 区县名称
	 */
	private String areas;
	/**
	 * 城市编号
	 */
	private String cityID;

	public Area() {
		super();
	}

	public Area(int id, String areaID, String areas, String cityID) {
		super();
		this.id = id;
		this.areaID = areaID;
		this.areas = areas;
		this.cityID = cityID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAreaID() {
		return areaID;
	}

	public void setAreaID(String areaID) {
		this.areaID = areaID;
	}

	public String getAreas() {
		return areas;
	}

	public void setAreas(String areas) {
		this.areas = areas;
	}

	public String getCityID() {
		return cityID;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}

}
