package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.bean.Blog;
import com.company.bean.User;
import com.company.service.IBlogService;
import com.company.service.impl.BlogServiceImpl;

/**
 * @author CJF
 * @category 博客编辑控制器<br>
 *           type 1:准备编辑；2:保存编辑信息
 */
@WebServlet("/editblog.action")
public class EditBlogAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditBlogAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IBlogService blogService = new BlogServiceImpl();
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("current_user");
		int id = Integer.valueOf(request.getParameter("id"));
		if (obj != null) {
			User user = (User) obj;
			if (type.equals("1")) {
				Blog blog = blogService.find(id);
				request.setAttribute("blog", blog);
				request.getRequestDispatcher("editblog.jsp").forward(request, response);
			} else if (type.equals("2")) {
				String title = request.getParameter("title");
				String kind = request.getParameter("kind");
				String schema = request.getParameter("schema");
				String content = request.getParameter("content");
				boolean flag = blogService.update(id, title, kind, schema, content);
				if (flag) {
					request.getRequestDispatcher("personblogschemalist.action?uid=" + user.getId()).forward(request,
							response);
				}
			}
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
