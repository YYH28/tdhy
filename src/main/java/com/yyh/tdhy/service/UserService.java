package com.yyh.tdhy.service;

import org.springframework.stereotype.Service;

import com.yyh.tdhy.po.User;

@Service
public interface UserService extends BaseService<User, Integer> {
	// 通过用户名查找
	public User getByUserName(String username) throws Exception;

	// 用户注册
	public int register(User user) throws Exception;

	// 用户注册发送邮件
	public void sendEmail(User user) throws Exception;

	// 用户激活
	public int setUserEnable(String userName, String userCode) throws Exception;

	// 用户登录检查
	public int checkLogin(User user) throws Exception;
}
