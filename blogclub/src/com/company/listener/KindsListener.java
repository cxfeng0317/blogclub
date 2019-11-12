package com.company.listener;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.company.bean.BlogKind;
import com.company.dao.IBlogKindDao;
import com.company.service.IBlogKindService;
import com.company.service.impl.BlogKindServiceImpl;

/**
 * @author CJF
 * @category 对app监听
 */

public class KindsListener implements ServletContextListener {
	IBlogKindService iBlogKindService;

	public KindsListener() {
	}

	public void contextDestroyed(ServletContextEvent event) {
	}

	public void contextInitialized(ServletContextEvent event) {
		System.out.println("app监听启动");

		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");
		IBlogKindService iBlogKindService = context.getBean(IBlogKindService.class);

		ServletContext application = event.getServletContext();
		List<BlogKind> blogKinds = iBlogKindService.findList();
		application.setAttribute("blogKinds", blogKinds);
	}

}
