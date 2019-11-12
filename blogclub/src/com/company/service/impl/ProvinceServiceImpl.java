package com.company.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.company.bean.Province;
import com.company.dao.IProvinceDao;
import com.company.service.IProvinceService;
import com.company.util.DataConnector;

@Service
public class ProvinceServiceImpl implements IProvinceService {
	// private IProvinceDao provincedao = new ProvinceDaoImpl();
	@Resource
	private IProvinceDao iProvinceDao;

	@Override
	public List<Province> findAll() {

		return iProvinceDao.findAll();
	}

	@Override
	public Province findObject(String provinceId) {
		return iProvinceDao.findObject(provinceId);
	}

}
