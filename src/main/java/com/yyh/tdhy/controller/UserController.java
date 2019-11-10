package com.yyh.tdhy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yyh.tdhy.po.User;
import com.yyh.tdhy.service.UserService;

@Controller
@RequestMapping("/admin/user")
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
	public String toEdit(Model model) throws Exception {
		return "admin/user/userEdit";
	}

	@RequestMapping("/edit")
	public String edit(Model model, User t) throws Exception {
		userService.update(t);
		return "redirect:getAll";
	}

	@RequestMapping("/delete")
	public String delete(Model model, Integer id) throws Exception {
		userService.delete(id);
		return "redirect:getAll";
	}
}
