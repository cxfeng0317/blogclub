package com.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.IBlogService;
import com.company.service.impl.BlogServiceImpl;
import com.company.vo.BlogVO;

/**
 * @author CJF
 * @category 查看博客列表控制器
 * @category type 1:查询全部blog<br>
 *           2:通过kid查询blog<br>
 *           3:通过uid查询blog<br>
 */
@WebServlet("/bloglist.action")
public class BloglistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BloglistAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IBlogService blogService = new BlogServiceImpl();
		String type = request.getParameter("type");
		if (type.equals("1")) {
			List<BlogVO> list = blogService.findList();
			request.setAttribute("list", list);
			request.getRequestDispatcher("bloglist.jsp").forward(request, response);
		} else if (type.equals("2")) {
			String kidStr = request.getParameter("kid");
			int kid = Integer.valueOf(kidStr);
			List<BlogVO> list = blogService.findKindList(kid);
			request.setAttribute("list", list);
			request.getRequestDispatcher("bloglist.jsp").forward(request, response);
		} else if (type.equals("3")) {
			String uidStr = request.getParameter("uid");
			int uid = Integer.valueOf(uidStr);
			List<BlogVO> list = blogService.findList(uid);
			request.setAttribute("list", list);
			request.getRequestDispatcher("bloglist.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
