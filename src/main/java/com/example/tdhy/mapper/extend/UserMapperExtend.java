package com.example.tdhy.mapper.extend;

import com.example.tdhy.mapper.UserMapper;
import com.example.tdhy.po.User;

public interface UserMapperExtend extends UserMapper {

	// 注册
//	void insert(User user);

	User selectUserByCode(String userCode);

	void update(User user);

	User select(User user);
}
