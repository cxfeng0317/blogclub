package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.bean.User;
import com.company.service.IUserService;
import com.company.service.impl.UserServiceImpl;

/**
 * @author CJF
 * @category 登录控制器
 */

public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IUserService userService = new UserServiceImpl();
		String captcha = request.getParameter("captcha");
		String sessionCaptcha = request.getSession().getAttribute("simpleCaptcha").toString();
		if (captcha.equals(sessionCaptcha)) {
			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			User user = userService.findByName(name, pass);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("current_user", user);
				session.setMaxInactiveInterval(60 * 30);
				request.getRequestDispatcher("personblogschemalist.action?uid=" + user.getId()).forward(request,
						response);
			} else {
				request.setAttribute("mess", "密码输入有误！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("mess", "验证码输入有误！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
