package com.company.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.ICommentService;
import com.company.service.impl.CommentServiceImpl;
import com.company.vo.CommentVO;

import net.sf.json.JSONObject;

/**
 * @author CJF
 * @category 博客评论控制器<br>
 *           type 1:查询当前博客全部品论；2:保存评论；3:删除评论
 */
@WebServlet("/comment.action")
public class CommentActon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentActon() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		ICommentService commentService = new CommentServiceImpl();
		String type = request.getParameter("type");
		int bid = Integer.valueOf(request.getParameter("bid"));
		if (type.equals("1")) {
			List<CommentVO> list = commentService.find(bid);
			json.put("list", list);
		} else if (type.equals("2")) {
			int uid = Integer.valueOf(request.getParameter("uid"));
			String content = request.getParameter("content");
			String ip = request.getRemoteAddr();
			boolean flag = commentService.save(uid, bid, content, ip);
			json.put("flag", flag);
		} else if (type.equals("3")) {
			int id = Integer.valueOf(request.getParameter("id"));
			boolean flag = commentService.delete(id);
			json.put("flag", flag);
		}
		out.print(json);
		out.flush();
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
