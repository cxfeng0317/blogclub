package com.company.service;

import java.util.List;

import com.company.bean.BlogKind;

/**
 * @author Johnny
 * @category 博客类型接口
 */
public interface IBlogKindService {

	/**
	 * 查询出博客分类列表
	 */
	public List<BlogKind> findList();
	
	/**
	 * 查询博客类型对象
	 * @param id 博客类型对象的ID
	 * @return
	 */
	public BlogKind find(int id);
}
