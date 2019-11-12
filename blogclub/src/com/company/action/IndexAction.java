package com.company.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.bean.BlogKind;
import com.company.service.IBlogKindService;
import com.company.service.IBlogService;
import com.company.service.impl.BlogKindServiceImpl;
import com.company.service.impl.BlogServiceImpl;
import com.company.vo.BlogVO;

/**
 * @author CJF
 * @category 首页控制器
 */
@WebServlet("/index.html")
public class IndexAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource
	IBlogService iblogService;

	public IndexAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("进入主页");

		List<BlogVO> hotList = iblogService.findHotList();
		List<BlogVO> indexList = iblogService.findIndexList();
		// IBlogKindService blogKindService = new BlogKindServiceImpl();
		// List<BlogKind> blogKinds = blogKindService.findList();
		request.setAttribute("hotList", hotList);
		request.setAttribute("indexList", indexList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
