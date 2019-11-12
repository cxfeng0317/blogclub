package com.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.IAreaService;
import com.company.service.ICityService;
import com.company.service.IProvinceService;
import com.company.service.impl.AreaServiceImpl;
import com.company.service.impl.CityServiceImpl;
import com.company.service.impl.ProvinceServiceImpl;

import net.sf.json.JSONObject;

/**
 * @author CJF
 * @category 省市区查询控制器
 * @category type 1：省；2：市；3：区
 */
@WebServlet("/pca.action")
public class ProvCityAreaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProvCityAreaAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IProvinceService provinceService = new ProvinceServiceImpl();
		ICityService cityService = new CityServiceImpl();
		IAreaService areaService = new AreaServiceImpl();
		String type = request.getParameter("type");
		List list = null;
		if (type.equals("1")) {
			list = provinceService.findAll();
		} else if (type.equals("2")) {
			String provinceId = request.getParameter("provinceId");
			list = cityService.findCitiesByPid(provinceId);
		} else if (type.equals("3")) {
			String cityId = request.getParameter("cityId");
			list = areaService.findAreasByCid(cityId);
		}
		JSONObject json = new JSONObject();
		json.put("list", list);
		response.getWriter().print(json);
		response.getWriter().flush();
		response.getWriter().close();
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
