package com.yyh.tdhy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yyh.tdhy.po.BackMenu;
import com.yyh.tdhy.service.BackMenuService;

@Controller
@RequestMapping("/admin")
public class BackMenuController {

	@Autowired
	private BackMenuService backMenuService;

	@RequestMapping("/menuGetAll")
	public String menuGetAll(Model model) throws Exception {
		List<BackMenu> backMenu = backMenuService.getAll();
		model.addAttribute("backMenu", backMenu);
		return "backStage/backMenu/BackMenuAll";
	}

	@RequestMapping("/menuToAdd")
	public String menuToAdd() throws Exception {
		return "backStage/backMenu/BackMenuAdd";
	}

	@RequestMapping("/menuToEdit")
	public String menuToEdit(Model model, Integer id) throws Exception {
		BackMenu backMenu = backMenuService.getById(id);
		model.addAttribute("menu", backMenu);
		return "backStage/backMenu/BackMenuEdit";
	}

	@RequestMapping("/menuDelete")
	public String menuDelete(Model model, Integer id) throws Exception {
		backMenuService.delete(id);
		return "redirect:menuGetAll";

	}

}
