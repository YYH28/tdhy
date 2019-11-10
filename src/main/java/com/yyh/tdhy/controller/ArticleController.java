package com.yyh.tdhy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yyh.tdhy.po.Article;
import com.yyh.tdhy.po.Sort;
import com.yyh.tdhy.service.ArticleService;
import com.yyh.tdhy.service.SortService;

@Controller
@RequestMapping("/admin/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private SortService sortService;

	@RequestMapping("/articleGetAll")
	public String getAll(Model model) throws Exception {
		List<Article> article = articleService.getAll();
		model.addAttribute("articleMenu", article);
		return "admin/article/articleAll";
	}

	@RequestMapping("/articleToAdd")
	public String toadd(Model model) throws Exception {
		List<Sort> sort = sortService.getAll();
		model.addAttribute("sort", sort);
		return "admin/article/articleAdd";
	}

	@RequestMapping("/articleAdd")
	public String add(Model model, Article t) throws Exception {
		articleService.add(t);

		return "redirect:articleGetAll";
	}

	@RequestMapping("/articleToEdit")
	public String toEdit(Model model, Integer id) throws Exception {
		Article article = articleService.getById(id);
		model.addAttribute("menu", article);
		List<Sort> sort = sortService.getAll();
		model.addAttribute("sort", sort);
		return "admin/article/articleEdit";
	}

	@RequestMapping("/articleEdit")
	public String edit(Model model, Article t) throws Exception {
		articleService.update(t);

		return "redirect:articleGetAll";
	}

	@RequestMapping("/delete")
	public String delete(Model model, Integer id) throws Exception {
		articleService.delete(id);
		return "redirect:articleGetAll";
	}

}
