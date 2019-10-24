package com.example.tdhy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.tdhy.mapper.extend.UserMapperExtend;
import com.example.tdhy.po.User;
import com.example.tdhy.po.UserExample;
import com.example.tdhy.service.UserService;

@SuppressWarnings("serial")
@Service
public class UserServiceImpl implements UserService {

	/**
	 * 
	 */

	@Autowired
	private UserMapperExtend userMapper;
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public List<User> getAll() throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(null);
	}

	@Override
	public int add(User t) throws Exception {
		List<User> getUser = new ArrayList<User>();
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(t.getUserName());
		getUser = userMapper.selectByExample(example);
		if (getUser.size() > 0) {
			return 0;
		} else {
			t.setUserCode(UUID.randomUUID().toString().replace("-", "").toLowerCase());
			userMapper.insertSelective(t);
			return 1;
		}

	}

	@Override
	public int update(User t) throws Exception {
		// TODO Auto-generated method stub
		try {
			userMapper.updateByPrimaryKeySelective(t);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
			userMapper.deleteByPrimaryKey(id);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	// 根据用户账号查找
	@Override
	public User getByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		List<User> getUser = new ArrayList<User>();
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(username);
		getUser = userMapper.selectByExample(example);
		if (getUser.size() > 0) {
			return getUser.get(0);
		} else {
			return null;
		}
	}

	// 用户登录
	@Override
	public int checkUser(User user) throws Exception {
		// TODO Auto-generated method stub
		User getUser = getByUsername(user.getUserName());
		if (getUser.getUserPassword().equals(user.getUserPassword())) {
			return 1;
		} else {
			return 0;
		}
	}

	// 用户注册
	@Override
	public int register(User user) throws Exception {
		// TODO Auto-generated method stub
		try {

			add(user);

			sendSimpleMail(user);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	// 发送激活邮件
	@Override
	public void sendSimpleMail(User user) throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
		message.setFrom("1378476425@qq.com");
		message.setTo(user.getUserEmail());
		message.setSubject("\"邮箱注册验证");
		message.setText("<html><body><a href='http://localhost:8080/user/codeCheck?userName=" + user.getUserName()
				+ "&code=" + user.getUserCode() + "'>请点击此处激活账户</a></body></html>", true);

		mailSender.send(mimeMessage);

	}

	// 用户注册激活
	@Override
	public int setUserEnable(String username, String code) throws Exception {
		User user = getByUsername(username);
		if (user.getUserCode().equals(code)) {
			user.setUserStatus(1);
			return update(user);
		} else {
			return 0;
		}
	}

}
