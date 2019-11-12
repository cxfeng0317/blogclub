package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.bean.Blog;
import com.company.service.IBlogService;
import com.company.service.impl.BlogServiceImpl;

/**
 * @author CJF
 * @category 查询博客内容控制器
 */
@WebServlet("/bloginfo.action")
public class BloginfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BloginfoAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IBlogService blogService = new BlogServiceImpl();
		String idStr = request.getParameter("id");
		if (idStr != null && !idStr.equals("")) {
			int id = Integer.valueOf(idStr);
			Blog blog = blogService.find(id);
			if (blog != null) {
				request.setAttribute("blog", blog);
				request.getRequestDispatcher("bloginfo.jsp").forward(request, response);
			} else {
				request.setAttribute("mess", "博客不存在");
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
