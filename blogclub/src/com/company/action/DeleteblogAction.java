package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.bean.User;
import com.company.service.IBlogService;
import com.company.service.IUserService;
import com.company.service.impl.BlogServiceImpl;
import com.company.service.impl.UserServiceImpl;

/**
 * @author CJF
 * @category 删除博客控制器
 */
@WebServlet("/deleteblog.action")
public class DeleteblogAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteblogAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IBlogService blogService = new BlogServiceImpl();
		String idStr = request.getParameter("id");
		if (idStr != null && !idStr.equals("")) {
			int id = Integer.valueOf(idStr);
			boolean flag = blogService.delete(id);
			if (flag) {
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("current_user");
				request.getRequestDispatcher("personblogschemalist.action?uid=" + user.getId()).forward(request,
						response);
			} else {
				request.setAttribute("mess", "删除失败");
				request.getRequestDispatcher("404.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("mess", "博客id有误");
			request.getRequestDispatcher("404.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
