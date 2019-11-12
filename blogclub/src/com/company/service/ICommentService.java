package com.company.service;

import java.util.List;

import com.company.vo.CommentVO;

/**
 * @author Johnny
 * @category 博客评论的业务逻辑层
 */
public interface ICommentService {

	/**
	 * 保存 评论信息
	 * @param comment
	 * @return
	 */
	public boolean save(int uid,int bid,String content,String ip);
	
	/**
	 * 删除评论
	 * @param id 评论的id
	 * @return
	 */
	public boolean delete(int id);
	
	/**
	 * 查询评论列表
	 * @param blogId 博客的id
	 * @return
	 */
	public List<CommentVO> find(int blogId);
}
