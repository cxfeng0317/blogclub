package com.company.dao;

import java.util.List;

import com.company.bean.Comment;

/**
 * @author Johnny
 * @category 评论的数据访问层接口
 */
public interface ICommentDao {

	/**
	 * 保存 评论信息
	 * @param comment
	 * @return
	 */
	public int save(Comment comment);
	
	/**
	 * 删除评论
	 * @param id 评论的id
	 * @return
	 */
	public int delete(int id);
	
	/**
	 * 删除评论
	 * @param  博客的ID
	 * @return
	 */
	public int deleteByBlogId(int blogId);
	
	/**
	 * 删除评论
	 * @param  用户的ID
	 * @return
	 */
	public int deleteByUserId(int UserId);
	
	/**
	 * 查询评论列表
	 * @param blogId 博客的id
	 * @return
	 */
	public List<Comment> find(int blogId);
}
