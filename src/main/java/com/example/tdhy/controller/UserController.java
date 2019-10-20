package com.example.tdhy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tdhy.po.User;
import com.example.tdhy.service.UserService;
import com.example.tdhy.until.IDUtils;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/getAll")
	public String getAll(Model model) throws Exception {
		List<User> userMenus = userService.getAll();
		model.addAttribute("userMenus", userMenus);
		return "admin/user/userAll";
	}

	@RequestMapping("/toadd")
	public String toadd(Model model) throws Exception {
		return "admin/user/userAdd";
	}

	@RequestMapping("/add")
	public String add(Model model, User user) throws Exception {
		userService.add(user);

		return "redirect:getAll";
	}

	@RequestMapping("/toedit")
	public String toEdit1(Model model) throws Exception {
		return "admin/user/userEdit";
	}

	@RequestMapping("/edit")
	public String edit(Model model, User t) throws Exception {
		userService.update(t);
		return "redirct:getAll";
	}

	@RequestMapping("/register")
	public String register(User user) throws Exception {
		user.setUserStatus(0);
		String userCode = IDUtils.getUUID();
		user.setUserCode(userCode);
		userService.add(user);
		return "redirect:tologin";
	}

//	注册
	@RequestMapping("/toregister")
	public String toregister(Model model) throws Exception {

		return "/register";
	}

	// 登录

	/**
	 * 登录
	 * 
	 * @return login
	 */
	@RequestMapping(value = "/tologin")
	public String login() {
		return "login";
	}

	/**
	 * 登录
	 */
	@RequestMapping("/login")
	public String login(User user, Model model) {
		User u = userService.get(user);
		if (u != null) {
			return "welcome";
		}
		return "error";
	}

	/**
	 * 校验激活码
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/checkCode")
	public String checkCode(String code) {
		User user = userService.getUserByCode(code);
		// 如果用户不等于null，把用户状态修改status=1
		if (user != null) {
			user.setUserStatus(1);
			// 把code验证码清空，已经不需要了
			user.setUserCode("");
			userService.modify(user);

			return "activeSuccess";
		}

		return "login";
	}

}
