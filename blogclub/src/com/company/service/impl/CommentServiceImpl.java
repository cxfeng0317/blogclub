package com.company.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Service;

import com.company.bean.Blog;
import com.company.bean.Comment;
import com.company.bean.User;
import com.company.dao.IBlogDao;
import com.company.dao.ICommentDao;
import com.company.dao.IUserDao;
import com.company.service.ICommentService;
import com.company.util.DataConnector;
import com.company.vo.BlogVO;
import com.company.vo.CommentVO;

@Service
public class CommentServiceImpl implements ICommentService {
	// private ICommentDao commentdao = new CommentDaoImpl();
	@Resource
	private ICommentDao iCommentDao;
	@Resource
	private IUserDao iUserDao;
	@Resource
	private IBlogDao iBlogDao;

	@Test
	public void test() {

		System.out.println(delete(6));
	}

	public List<CommentVO> getCommentVO(List<Comment> comments) {

		List<CommentVO> list = new ArrayList<CommentVO>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Comment comment : comments) {
			CommentVO commentVO = new CommentVO();
			Timestamp datetime = comment.getDatetime();
			String datetimeStr = sdf.format(datetime);
			User user = iUserDao.find(comment.getUid());
			Blog blog = iBlogDao.find(comment.getBid());
			commentVO.setId(comment.getId());
			commentVO.setUid(comment.getUid());
			commentVO.setBid(comment.getBid());
			commentVO.setIp(comment.getIp());
			commentVO.setDatetime(datetime);
			commentVO.setContent(comment.getContent());
			commentVO.setDatetimeStr(datetimeStr);
			commentVO.setUserName(user.getName());
			commentVO.setBlogName((blog.getTitle()));
			list.add(commentVO);
		}
		return list;
	}

	@Override
	public boolean save(int uid, int bid, String content, String ip) {
		Comment comment = new Comment(uid, bid, ip, new Timestamp(System.currentTimeMillis()), content);
		return iCommentDao.save(comment) > 0 ? true : false;
	}

	@Override
	public boolean delete(int id) {

		return iCommentDao.delete(id) > 0 ? true : false;
	}

	@Override
	public List<CommentVO> find(int blogId) {
		List<CommentVO> list = new ArrayList<CommentVO>();
		List<Comment> comments = iCommentDao.find(blogId);
		list = getCommentVO(comments);
		return list;
	}

}
