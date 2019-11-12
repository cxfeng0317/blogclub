package com.company.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.bean.User;

/**
 * @author Johnny
 * @category 用户数据访问层
 */
public interface IUserDao {

	/**
	 * 根据用户的ID和用户密码查询用户对象
	 */
	public User findByid(@Param("id") int id, @Param("pass") String pass);

	/**
	 * 根据用户的名字和用户密码查询用户对象
	 */
	public User findByname(@Param("name") String name, @Param("pass") String pass);

	/**
	 * 添加一个用户对象
	 */
	public int add(User user);

	/**
	 * 查询出来所有的人员集合，除了管理员以外
	 */
	public List<User> findUserList();

	/**
	 * 删除用户对象
	 */
	public int delete(int id);

	/**
	 * 查询出用户对象，准备编辑
	 */
	public User find(int id);

	/**
	 * 更新用户信息
	 */
	public int update(User user);

	/**
	 * 根据用户名称查找
	 * 
	 * @param name
	 * @return 受影响的行数
	 */
	public User findByUserName(String name);
}
