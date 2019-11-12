package com.company.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.company.bean.Blog;
import com.company.bean.BlogKind;
import com.company.bean.User;
import com.company.dao.IBlogDao;
import com.company.dao.IBlogKindDao;
import com.company.dao.ICommentDao;
import com.company.dao.IUserDao;
import com.company.service.IBlogKindService;
import com.company.service.IBlogService;
import com.company.util.DataConnector;
import com.company.vo.BlogVO;

@Service
public class BlogServiceImpl implements IBlogService {
	// private IBlogDao blogdao = new BlogDaoImpl();
	// private ICommentDao commentDao = new CommentDaoImpl();

	// 使用mybatis
	@Resource
	private IBlogDao iBlogDao;
	@Resource
	private ICommentDao iCommentDao;
	@Resource
	private IBlogKindDao iBlogKindDao;
	@Resource
	private IUserDao iUserDao;

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");
		IBlogService iBlogService = context.getBean(IBlogService.class);
		List<BlogVO> list = iBlogService.findHotList();
		for (Blog blog : list) {
			System.out.println(blog.getKid());
		}
	}

	public List<BlogVO> getBlogVO(List<Blog> blogs) {
		List<BlogVO> list = new ArrayList<BlogVO>();
		for (Blog blog : blogs) {
			BlogVO blogVO = new BlogVO();
			blogVO.setId(blog.getId());
			blogVO.setKid(blog.getKid());
			blogVO.setUid(blog.getUid());
			blogVO.setTitle(blog.getTitle());
			blogVO.setSchema(blog.getSchema());
			blogVO.setContent(blog.getContent());
			blogVO.setClicks(blog.getClicks());
			blogVO.setDatetime(blog.getDatetime());
			User user = iUserDao.find(blog.getUid());
			blogVO.setUserName(user.getName());
			BlogKind blogKind = iBlogKindDao.find(blog.getKid());
			blogVO.setBlogKindName(blogKind.getName());
			list.add(blogVO);
		}
		return list;
	}

	@Override
	public List<BlogVO> findList() {
		List<BlogVO> list = new ArrayList<BlogVO>();
		List<Blog> blogs = iBlogDao.findList();
		list = getBlogVO(blogs);
		return list;
	}

	@Override
	public List<BlogVO> findHotList() {
		List<BlogVO> list = new ArrayList<BlogVO>();
		List<Blog> blogs = iBlogDao.findHotList();
		list = getBlogVO(blogs);
		return list;
	}

	@Override
	public List<BlogVO> findIndexList() {
		List<BlogVO> list = new ArrayList<BlogVO>();
		List<Blog> blogs = iBlogDao.findIndexList();
		list = getBlogVO(blogs);
		return list;
	}

	@Override
	public List<BlogVO> findList(int uid) {
		List<BlogVO> list = new ArrayList<BlogVO>();
		List<Blog> blogs = iBlogDao.findListByuid(uid);
		list = getBlogVO(blogs);
		return list;
	}

	@Override
	public List<BlogVO> findKindList(int kid) {
		List<BlogVO> list = new ArrayList<BlogVO>();
		List<Blog> blogs = iBlogDao.findKindList(kid);
		list = getBlogVO(blogs);
		return list;
	}

	@Override
	public Blog find(int id) {
		return iBlogDao.find(id);
	}

	@Override
	public boolean delete(int id) {
		// 首先删除该博客的所有评论，使用的是评论的数据访问层对象
		iCommentDao.deleteByBlogId(id);
		return iBlogDao.delete(id) > 0 ? true : false;
	}

	@Override
	public boolean update(int id, String title, String kind, String schema, String content) {
		Blog blog = iBlogDao.find(id);
		int kid = Integer.valueOf(kind);
		blog.setKid(kid);
		blog.setTitle(title);
		blog.setSchema(schema);
		blog.setContent(content);
		int i = iBlogDao.update(blog);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean saveBlog(int uid, String title, String kind, String schema, String content) {
		int kid = Integer.valueOf(kind);
		Blog blog = new Blog(kid, uid, title, schema, content, 0, new Timestamp(System.currentTimeMillis()));
		int i = iBlogDao.add(blog);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

}
