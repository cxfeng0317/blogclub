package com.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.bean.User;
import com.company.service.IBlogService;
import com.company.service.IUserService;
import com.company.service.impl.BlogServiceImpl;
import com.company.service.impl.UserServiceImpl;
import com.company.vo.BlogVO;

/**
 * @author CJF
 * @category 个人博客控制器
 */
@WebServlet("/personblogschemalist.action")
public class PersonblogschemalistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PersonblogschemalistAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IUserService userService = new UserServiceImpl();
		IBlogService blogService = new BlogServiceImpl();
		String uidStr = request.getParameter("uid");
		if (uidStr != null && !uidStr.equals("")) {
			User user = userService.find(uidStr);
			List<BlogVO> list = blogService.findList(Integer.valueOf(uidStr));
			if (user != null) {
				request.setAttribute("user", user);
				request.setAttribute("list", list);
				request.getRequestDispatcher("personblogschemalist.jsp").forward(request, response);
			} else {
				request.setAttribute("mess", "用户不存在");
				request.getRequestDispatcher("404.jsp").forward(request, response);
			}
		} else {

			request.setAttribute("mess", "用户id有误");
			request.getRequestDispatcher("404.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
