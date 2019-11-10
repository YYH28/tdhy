package com.yyh.tdhy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yyh.tdhy.po.InProduct;
import com.yyh.tdhy.service.InProductService;

@Controller
@RequestMapping("/admin/inproduct")
public class InProductController {

	@Autowired
	private InProductService inProductService;

	@RequestMapping("/getAll")
	public String getAll(Model model) throws Exception {
		List<InProduct> inProductMenus = inProductService.getAll();
		model.addAttribute("inProductMenus", inProductMenus);
		return "/admin/inproduct/indexAdmin";
	}

	@RequestMapping("/toAdd")
	public ModelAndView toAdd(ModelAndView mav, Integer id) throws Exception {
		mav.setViewName("admin/inproduct/indexAdd");
		return mav;
	}

	@RequestMapping("/add")
	public ModelAndView add(InProduct inProductMenus) throws Exception {
		ModelAndView mav;
		inProductService.add(inProductMenus);
		return new ModelAndView("redirect:/admin/inproduct/getAll");
	}

	@RequestMapping("/toEdit")
	public ModelAndView toEdit(ModelAndView mav, Integer id) throws Exception {
		mav.setViewName("/admin/inproduct/indexEdit");
		InProduct inProductMenus = inProductService.getById(id);
		mav.addObject("menu", inProductMenus);
		return mav;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(InProduct inProductMenus) throws Exception {
		ModelAndView mav;
		inProductService.update(inProductMenus);
		return new ModelAndView("redirect:/admin/inproduct/getAll");
	}

	@RequestMapping("/delete")
	public ModelAndView delete(ModelAndView mav, Integer id) throws Exception {
		inProductService.delete(id);
		return new ModelAndView("redirect:/inproduct/getAll");
	}
}
