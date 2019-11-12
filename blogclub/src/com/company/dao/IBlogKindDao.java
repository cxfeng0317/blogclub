package com.company.dao;

import java.util.List;

import com.company.bean.BlogKind;

/**
 * @author Johnny
 * @category 博客类型接口数据访问层
 */
public interface IBlogKindDao {

	/**
	 * 查询出所有的博客类型
	 * @return
	 */
	public List<BlogKind> findList();
	
	/**
	 * 查询博客类型对象
	 * @param id 博客类型对象的ID
	 * @return
	 */
	public BlogKind find(int id);
}
