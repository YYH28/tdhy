package com.example.tdhy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.tdhy.po.ResultMsg;
import com.example.tdhy.po.User;
import com.example.tdhy.service.UserService;

@Controller
@RequestMapping("/user")
public class LoginController {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private UserService userService;

	@RequestMapping("/tologin")
	public String toLogin() throws Exception {
		return "login";
	}

	@RequestMapping("/login")
	@ResponseBody
	public int login(@RequestBody JSONObject getUser, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println(getUser.toJSONString());
		HttpSession session = request.getSession();
		User user = JSON.toJavaObject(getUser, User.class);
		if (userService.checkUser(user) == 1) {
			session.setAttribute("UserInfo", user);
			return 1;
		} else {
			return 0;
		}
	}

	@RequestMapping("/toregister")
	public String toRegister() throws Exception {
		return "register";
	}

	@RequestMapping("/register")
	@ResponseBody
	public ResultMsg register(@RequestBody JSONObject getUser) throws Exception {
		System.out.println(getUser.toJSONString());
		ResultMsg msg = new ResultMsg();
		User user = JSON.toJavaObject(getUser, User.class);
		msg.setCode(userService.register(user));
		return msg;
	}

	@RequestMapping("/codeCheck")
	public String register(@RequestParam("userName") String userName, @RequestParam("code") String code)
			throws Exception {
		System.out.println(userName);
		System.out.println(code);
		userService.setUserEnable(userName, code);
		return "redirect:tologin";
	}
}
