package com.company.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Service;

import com.company.bean.Blog;
import com.company.bean.BlogKind;
import com.company.bean.User;
import com.company.dao.IBlogDao;
import com.company.dao.IBlogKindDao;
import com.company.dao.ICommentDao;
import com.company.dao.IUserDao;
import com.company.service.IUserService;
import com.company.util.DataConnector;
import com.company.vo.BlogVO;

@Service
public class UserServiceImpl implements IUserService {
	// private IUserDao userDao = new UserDaoImpl();
	// private ICommentDao commentDao = new CommentDaoImpl();
	// private IBlogDao blogDao = new BlogDaoImpl();
	@Resource
	private IUserDao iUserDao;
	@Resource
	private IBlogDao iBlogDao;
	@Resource
	private ICommentDao iCommentDao;
	

	@Test
	public void test() {
		System.out.println(delete("7"));
	}
	

	@Override
	public User find(String id, String pass) {
		User user = null;
		if (id != null && pass != null) {
			user = iUserDao.findByid(Integer.valueOf(id), pass);
		}
		return user;
	}

	@Override
	public User findByName(String name, String pass) {
		User user = null;
		if (name != null && pass != null) {
			user = iUserDao.findByname(name, pass);
		}
		return user;
	}

	@Override
	public boolean add(User user) {

		return iUserDao.add(user) > 0 ? true : false;
	}

	@Override
	public List<User> findUserList() {

		return iUserDao.findUserList();
	}

	@Override
	public boolean delete(String id) {
		boolean flag = false;
		if (id != null && !id.equals("")) {
			int userId = Integer.valueOf(id);
			// 根据userId得到所有博客
			List<Blog> blogs = iBlogDao.findListByuid(userId);
			for (Blog blog : blogs) {
				// 根据博客的id删除所有评论
				iCommentDao.deleteByBlogId(blog.getId());
				// 根据博客id删除博客
				iBlogDao.delete(blog.getId());
			}
			// 删除该人发表的所有评论
			iCommentDao.deleteByUserId(userId);
			int i = iUserDao.delete(userId);
			if (i > 0) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public User find(String id) {
		User user = null;
		if (id != null && !id.equals("")) {
			int userId = Integer.valueOf(id);
			user = iUserDao.find(userId);
		}
		return user;
	}

	@Override
	public boolean update(User user) {
		boolean flag = false;
		if (user != null && user.getId() != 0) {
			int i = iUserDao.update(user);
			if (i > 0) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public boolean findByUserName(String name) {
		if (iUserDao.findByUserName(name) == null) {
			return true;
		} else
			return false;

	}

}
