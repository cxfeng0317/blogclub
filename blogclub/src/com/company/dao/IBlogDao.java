package com.company.dao;

import java.util.List;

import com.company.bean.Blog;

/**
 * @author Johnny
 * @category 博客数据访问层
 */
public interface IBlogDao {

	/**
	 * 添加博客
	 */
	public int add(Blog blog);

	/**
	 * 查询所有博客列表
	 */
	public List<Blog> findList();

	/**
	 * 查询出热门博客2条
	 * 
	 * @return
	 */
	public List<Blog> findHotList();

	/**
	 * 首页展示的博客信息 只显示8条
	 * 
	 * @return
	 */
	public List<Blog> findIndexList();

	/**
	 * 根据用户id查询出，该用户的所有博客
	 * 
	 * @param uid
	 *            用户id
	 * @return
	 */
	public List<Blog> findListByuid(int uid);

	/**
	 * 查询出博客列表
	 * 
	 * @param kid
	 *            博客类型id
	 * @return
	 */
	public List<Blog> findKindList(int kid);

	/**
	 * 根据博客id查询出博客对象
	 */
	public Blog find(int id);

	/**
	 * 根据博客id删除博客，返回受影响的行数
	 */
	public int delete(int id);

	/**
	 * 根据博客对象更新博客
	 * 
	 * @param blog
	 * @return 返回受影响的行数
	 */
	public int update(Blog blog);
}
