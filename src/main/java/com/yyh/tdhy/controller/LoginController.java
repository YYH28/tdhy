package com.yyh.tdhy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yyh.tdhy.service.UserService;

@Controller
@RequestMapping("/tdhy")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/toLogin")
	public String toLogin() throws Exception {
		return "login";
	}

	@RequestMapping("/toRegister")
	public String toRegister() throws Exception {
		return "register";
	}

	@RequestMapping("/userCheck")
	public String userCheck(@RequestParam("userName") String userName, @RequestParam("userCode") String userCode)
			throws Exception {
		userService.setUserEnable(userName, userCode);
		return "redirect:toLogin";
	}
}
