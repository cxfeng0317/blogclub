package com.company.service;

import java.util.List;

import com.company.bean.Blog;
import com.company.vo.BlogVO;

/**
 * @author Johnny
 * @category 博客业务逻辑层
 */
public interface IBlogService {

	/**
	 * 查询所有博客
	 * @return
	 */
	public List<BlogVO> findList();
	
	/**
	 * 查询出热门博客2条
	 * @return
	 */
	public List<BlogVO> findHotList();
	
	/**
	 * 首页展示的博客信息
	 * 只显示8条
	 * @return 
	 */
	public List<BlogVO> findIndexList();
	
	
	/**
	 * 根据用户id查询出，该用户的所有博客
	 * @param uid 用户id
	 * @return
	 */
	public List<BlogVO> findList(int uid);
	
	/**
	 * 查询出博客列表
	 * @param kid 博客类型id
	 * @return
	 */
	public List<BlogVO> findKindList(int kid);

	/**
	 * 查询博客对象
	 * @param id 博客的id
	 * @return
	 */
	public Blog find(int id);

	/**
	 * 根据博客id删除博客
	 * @param id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * 跟新博客
	 * @param blog 博客对象
	 * @return
	 */
	public boolean update(int id,String title,String kind,String schema,String content);
	
	/**
	 * 保存博客信息
	 */
	public boolean saveBlog(int uid,String title,String kind,String schema,String content);
}
