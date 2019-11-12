package com.company.action;

import java.io.IOException;
import java.util.List;

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
 * @category 查询用户列表控制器
 */
@WebServlet("/userlist.action")
public class UserlistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserlistAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 增加安全验证
		HttpSession session = request.getSession();
		// 从Session中取出当前用户信息
		Object obj = session.getAttribute("current_user");
		if (obj != null) {
			User user = (User) obj;
			if (user.getId() == 1) {
				IUserService userService = new UserServiceImpl();
				List<User> list = userService.findUserList();
				request.setAttribute("list", list);
				request.getRequestDispatcher("userlist.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("404.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("404.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
