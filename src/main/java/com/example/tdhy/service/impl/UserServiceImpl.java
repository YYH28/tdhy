package com.example.tdhy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tdhy.mapper.extend.UserMapperExtend;
import com.example.tdhy.po.User;
import com.example.tdhy.service.MailService;
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
	private MailService mailService;

	@Override
	public List<User> getAll() throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(null);
	}

	@Override
	public void add(User t) {
		userMapper.insert(t);
		String code = t.getUserCode();
		String subject = "邮箱注册验证";
		String content = "<a href=\'http://localhost:8080/user/checkCode?code=" + code
				+ "\' style='display=block font-size=25px'>点击注册激活" + code + "</a>";
		mailService.sendMimeMail(t.getUserEmail(), subject, content);

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

	@Override
	public User getById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User getUserByCode(String userCode) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByCode(userCode);
	}

	@Override
	public void modify(User user) {
		// TODO Auto-generated method stub
		userMapper.update(user);
	}

	@Override
	public User get(User user) {
		// TODO Auto-generated method stub
		return userMapper.select(user);
	}

}
