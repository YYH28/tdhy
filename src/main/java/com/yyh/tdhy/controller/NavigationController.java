package com.yyh.tdhy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yyh.tdhy.po.Navigation;
import com.yyh.tdhy.service.NavigationService;

@Controller
@RequestMapping("/admin/navigation")
public class NavigationController {

	@Autowired
	private NavigationService navigationService;

	@RequestMapping("/getAll")
	public String getAll(Model model) throws Exception {
		List<Navigation> navigationMenus = navigationService.getAll();
		model.addAttribute("navigationMenus", navigationMenus);
		return "admin/nav/indexNav";
	}

	@RequestMapping("/toAdd")
	public String toAdd(Integer id) throws Exception {
		return "admin/nav/indexNavAdd";
	}

	@RequestMapping("/add")
	public String add(Model model, Navigation t) throws Exception {
		navigationService.add(t);
		return "redirect:/admin/navigation/getAll";
	}

	@RequestMapping("/toEdit")
	public String toEdit(Model model, Integer id) throws Exception {
		Navigation navigationMenus = navigationService.getById(id);
		model.addAttribute("menu", navigationMenus);
		return "admin/nav/indexNavEdit";
	}

	@RequestMapping("/edit")
	public String edit(Model model, Navigation t) throws Exception {
		navigationService.update(t);
		return "redirect:/admin/navigation/getAll";
	}

	@RequestMapping("/delete")
	public String delete(Model model, Integer id) throws Exception {
		navigationService.delete(id);
		return "redirect:/admin/navigation/getAll";
	}
}
