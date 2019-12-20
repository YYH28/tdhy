package com.yyh.tdhy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yyh.tdhy.po.InNews;
import com.yyh.tdhy.service.InNewsService;

@Controller
@RequestMapping("/admin/innews")
public class InNewsController {

	@Autowired
	private InNewsService inNewsService;

	@RequestMapping("/getAll")
	public String getAll(Model model) throws Exception {
		List<InNews> inNewsMenu = inNewsService.getAll();
		model.addAttribute("inNewsMenu", inNewsMenu);
		return "admin/innews/innewsAdmin";
	}

	@RequestMapping("/toAdd")
	public String toAdd() throws Exception {
		return "admin/innews/innewsAdd";
	}

	@RequestMapping("/add")
	public String add(InNews t) throws Exception {
		inNewsService.add(t);
		return "redirect:getAll";
	}

	@RequestMapping("/toEdit")
	public String toEdit(Model model, Integer id) throws Exception {
		InNews menu = inNewsService.getById(id);
		model.addAttribute("menu", menu);
		return "admin/innews/innewsEdit";
	}

	@RequestMapping("/edit")
	public String edit(InNews t) throws Exception {
		inNewsService.update(t);
		return "redirect:getAll";
	}

	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception {
		inNewsService.delete(id);
		return "redirect:getAll";
	}
}
