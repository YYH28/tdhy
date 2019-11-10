package com.yyh.tdhy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yyh.tdhy.po.Sort;
import com.yyh.tdhy.service.SortService;

@Controller
@RequestMapping("/admin/sort")
public class SortController {

	@Autowired
	private SortService sortService;

	@RequestMapping("/sortGetAll")
	public String sortGetAll(Model model) throws Exception {
		List<Sort> sortMenu = sortService.getAll();
		model.addAttribute("sortMenu", sortMenu);
		return "admin/sort/sortAll";
	}

	@RequestMapping("/sortToAdd")
	public String sortToAdd() throws Exception {
		return "admin/sort/sortAdd";
	}

	@RequestMapping("/sortToEdit")
	public String sortToEdit(Model model, Integer id) throws Exception {
		Sort sort = sortService.getById(id);
		model.addAttribute("menu", sort);
		return "admin/sort/sortEdit";
	}

	@RequestMapping("/sortDelete")
	public String sortDelete(Model model, Integer id) throws Exception {
		sortService.delete(id);
		return "redirect:sortGetAll";
	}
}
