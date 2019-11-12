package com.company.util;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

/**
 * @author CJF
 * @category 使用MyBatis连接数据库
 */
public class DataConnector {

	/**
	 * @return 获得SqlSession对象
	 */
	public static SqlSession getConnertor() {
		SqlSession sqlSession = null;
		try {
			String resource = "spring/spring.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
}
