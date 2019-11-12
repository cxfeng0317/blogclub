package com.company.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.company.bean.Area;
import com.company.dao.IAreaDao;
import com.company.service.IAreaService;
import com.company.util.DataConnector;

@Service("iAreaService")
public class AreaServiceImpl implements IAreaService {
	// private IAreaDao areadao = new AreaDaoImpl();
	@Resource
	private IAreaDao iAreaDao;

	@Override
	public List<Area> findAreasByCid(String cityId) {

		return iAreaDao.findAreasByCid(cityId);
	}

	@Override
	public Area findObject(String areaId) {

		return iAreaDao.findObject(areaId);
	}

}
