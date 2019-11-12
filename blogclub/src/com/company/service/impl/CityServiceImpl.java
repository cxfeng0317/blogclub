package com.company.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.company.bean.City;
import com.company.dao.ICityDao;
import com.company.service.ICityService;
import com.company.util.DataConnector;

@Service
public class CityServiceImpl implements ICityService {
	// private ICityDao citydao = new CityDaoImpl();
	@Resource
	private ICityDao iCityDao;

	@Override
	public List<City> findCitiesByPid(String provinceId) {

		return iCityDao.findCitiesByPid(provinceId);
	}

	@Override
	public City findObject(String cityId) {

		return iCityDao.findObject(cityId);
	}

}
