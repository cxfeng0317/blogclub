package com.company.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.bean.User;
import com.company.service.IUserService;
import com.company.service.impl.UserServiceImpl;

/**
 * @author CJF
 * @category 注册控制器
 */
@WebServlet("/regist.action")
public class RegistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IUserService userService = new UserServiceImpl();
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String pass2 = request.getParameter("pass2");
		String ageStr = request.getParameter("age");
		String sex = request.getParameter("sex");
		String provinceId = request.getParameter("provinceId");
		String cityId = request.getParameter("cityId");
		String areaId = request.getParameter("areaId");
		String tel = request.getParameter("tel");
		String ip = request.getRemoteAddr();
		Timestamp inputdate = new Timestamp(System.currentTimeMillis());
		int age = Integer.valueOf(ageStr.trim());
		if (name != null && !name.trim().equals("") && pass != null && !pass.trim().equals("") && pass.equals(pass2)) {
			User user = new User(name, pass2, sex, age, tel, provinceId, cityId, areaId, inputdate, ip);
			boolean flag = userService.add(user);
			if (flag) {
				request.setAttribute("mess", "注册成功！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				request.setAttribute("mess", "注册失败！");
				request.getRequestDispatcher("regist.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("mess", "注册失败！");
			request.getRequestDispatcher("regist.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
