package com.company.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.company.bean.BlogKind;
import com.company.dao.IBlogKindDao;
import com.company.service.IBlogKindService;
import com.company.util.DataConnector;

@Service("iBlogKindService")
public class BlogKindServiceImpl implements IBlogKindService {
	// private IBlogKindDao blogkinddao = new BlogKindDaoImpl();
	@Resource()
	// @Autowired
	// @Qualifier("iBlogKindDao")
	private IBlogKindDao iBlogKindDao;

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");
		IBlogKindService iBlogKindService = context.getBean(IBlogKindService.class);
		List<BlogKind> list = iBlogKindService.findList();
		System.out.println(list.size());
	}

	@Override
	public List<BlogKind> findList() {

		return iBlogKindDao.findList();
	}

	@Override
	public BlogKind find(int id) {

		return iBlogKindDao.find(id);
	}

}
