package com.yyh.tdhy.api;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yyh.tdhy.po.ResultMsg;
import com.yyh.tdhy.po.User;
import com.yyh.tdhy.service.UserService;
import com.yyh.tdhy.until.redis.RedisUtil;

@RestController
@RequestMapping("/tdhy")
public class LoginApi {

	private static int ExpireTime = 3600; // redis中存储的过期时间60s
	@Autowired
	UserService userService;

	@Resource
	private RedisUtil redisUtil;

	@RequestMapping("/login")
	public int login(@RequestBody JSONObject getUser, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = JSON.toJavaObject(getUser, User.class);
		if (userService.checkLogin(user) == 1) {
			System.out.println(user.getUserName());
			redisUtil.set("UserInfo", user, ExpireTime);
			redisUtil.set("userName", user.getUserName(), ExpireTime);
//			session.setAttribute("UserInfo", user);
			session.setAttribute("userName", user.getUserName());
//			session.setMaxInactiveInterval(3600);// 3600秒，注意服务器端的3600秒，而不是客户端的
			System.out.println(redisUtil.get("UserInfo"));
			System.out.println(redisUtil.get("userName"));
			return 1;
		} else {
			return 0;
		}
	}

	@RequestMapping("/register")
	public ResultMsg register(@RequestBody JSONObject getUser) throws Exception {
		User user = JSON.toJavaObject(getUser, User.class);
		ResultMsg msg = new ResultMsg();
		msg.setCode(userService.register(user));
		return msg;
	}

}
