package com.yyh.tdhy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.yyh.tdhy.mapper.UserMapper;
import com.yyh.tdhy.po.User;
import com.yyh.tdhy.po.UserExample;
import com.yyh.tdhy.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public List<User> getAll() throws Exception {
		return userMapper.selectByExample(null);

	}

	@Override
	public int add(User t) throws Exception {
		// System.out.println(t.getUserName());
		List<User> addUser = new ArrayList<User>();
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(t.getUserName());
		addUser = userMapper.selectByExample(example);

		if (addUser.size() > 0) {
			return 0;
		} else {
			t.setUserCode(UUID.randomUUID().toString().replace("-", "").toLowerCase());
			// System.out.println(t.getUserCode());
			userMapper.insertSelective(t);
			return 1;
		}

	}

	@Override
	public int update(User t) throws Exception {

		userMapper.updateByPrimaryKeySelective(t);
		return 1;

	}

	@Override
	public int delete(Integer id) throws Exception {

		userMapper.deleteByPrimaryKey(id);
		return 1;

	}

	@Override
	public User getById(Integer id) throws Exception {
		// TODO Auto-generated method stub

		return userMapper.selectByPrimaryKey(id);

	}

	@Override
	public User getByUserName(String username) throws Exception {

		List<User> getUserName = new ArrayList<User>();
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(username);
		getUserName = userMapper.selectByExample(example);
		if (getUserName.size() > 0) {
			return getUserName.get(0);
		} else {
			return null;
		}

	}

	@Override
	public int register(User user) throws Exception {

		add(user);
		sendEmail(user);
		return 1;

	}

	@Override
	public void sendEmail(User user) throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
		message.setFrom("1378476425@qq.com");
		message.setTo(user.getUserEmail());
		message.setSubject("\"邮箱注册验证");
		message.setText("<html><body><a href='http://localhost:8080/tdhy/userCheck?userName=" + user.getUserName()
				+ "&userCode=" + user.getUserCode() + "'>请点击此处激活账户</a></body></html>", true);

		mailSender.send(mimeMessage);

	}

	@Override
	public int setUserEnable(String userName, String userCode) throws Exception {

		User user = getByUserName(userName);
		if (user.getUserCode().equals(userCode)) {
			user.setUserStatus(1);
			return update(user);
		} else {
			return 0;
		}

	}

	@Override
	public int checkLogin(User user) throws Exception {
		User getUser = getByUserName(user.getUserName());
		if (user.getUserPassword().equals(getUser.getUserPassword())) {
			return 1;
		} else {
			return 0;
		}
	}
}
