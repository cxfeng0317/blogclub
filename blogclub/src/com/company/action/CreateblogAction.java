package com.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.bean.BlogKind;
import com.company.bean.User;
import com.company.service.IBlogKindService;
import com.company.service.IBlogService;
import com.company.service.impl.BlogKindServiceImpl;
import com.company.service.impl.BlogServiceImpl;

/**
 * @author CJF
 * @category 创建博客控制器
 * @category type 1:准备创建<br>
 *           2:创建<br>
 */
@WebServlet("/createblog.action")
public class CreateblogAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateblogAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("current_user");
		if (obj != null) {
			IBlogService blogService = new BlogServiceImpl();
			IBlogKindService blogKindService = new BlogKindServiceImpl();
			String type = request.getParameter("type");
			if (type.equals("1")) {
				List<BlogKind> blogKinds = blogKindService.findList();
				request.setAttribute("blogKinds", blogKinds);
				request.getRequestDispatcher("blogcreate.jsp").forward(request, response);
			} else if (type.equals("2")) {
				User user = (User) obj;
				String title = request.getParameter("title");
				String kind = request.getParameter("kind");
				String schema = request.getParameter("schema");
				String content = request.getParameter("content");
				boolean flag = blogService.saveBlog(user.getId(), title, kind, schema, content);
				if (flag) {
					request.getRequestDispatcher("personblogschemalist.action?uid=" + user.getId()).forward(request,
							response);
				} else {
					request.getRequestDispatcher("blogcreate.action?type=1").forward(request, response);
				}
			}
		} else {
			response.sendRedirect("login.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
