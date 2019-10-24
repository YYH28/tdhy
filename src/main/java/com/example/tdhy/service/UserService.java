package com.example.tdhy.service;

import com.example.tdhy.po.User;

public interface UserService extends BaseService<User, Integer> {
	// 根据用户名查询用户信息
	public User getByUsername(String username) throws Exception;

	// 用户登录
	public int checkUser(User user) throws Exception;

	// 用户注册激活
	public int setUserEnable(String username, String code) throws Exception;

	// 用户注册
	public int register(User user) throws Exception;

	// 发送激活邮件
	public void sendSimpleMail(User user) throws Exception;

}
