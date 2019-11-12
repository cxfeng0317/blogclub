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
 * @category 删除用户控制器
 */
@WebServlet("/delete.action")
public class DeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("current_user");
		if (obj != null) {
			User user = (User) obj;
			if (user.getId() == 1) {
				IUserService userService = new UserServiceImpl();
				String id = request.getParameter("id");
				boolean flag = userService.delete(id);
				if (flag) {
					response.sendRedirect("userlist.action");
				} else {
					request.setAttribute("mess", "删除失败");
					request.getRequestDispatcher("404.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("mess", "用户id有误");
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
