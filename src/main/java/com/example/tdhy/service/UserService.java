package com.example.tdhy.service;

import java.io.Serializable;
import java.util.List;

import com.example.tdhy.po.User;

public interface UserService extends Serializable {
	public User getById(Integer id) throws Exception;

	/**
	 * 用户注册
	 * 
	 * @param user
	 */
	void add(User user);

	/**
	 * 根据激活码查找用户
	 * 
	 * @param activeCode
	 * @return
	 */
	User getUserByCode(String userCode);

	/**
	 * 修改
	 * 
	 * @param user
	 */
	void modify(User user);

	/**
	 * 登录
	 * 
	 * @param user
	 * @return
	 */
	User get(User user);

	public List<User> getAll() throws Exception;

	public int delete(Integer id) throws Exception;

	public int update(User t) throws Exception;
}
