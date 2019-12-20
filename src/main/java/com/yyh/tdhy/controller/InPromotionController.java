package com.yyh.tdhy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yyh.tdhy.po.InPromotion;
import com.yyh.tdhy.service.InPromotionService;

@Controller
@RequestMapping("/admin/inpromotion")
public class InPromotionController {

	@Autowired
	private InPromotionService inPromotionService;

	@RequestMapping("/getAll")
	public String getAll(Model model) throws Exception {
		List<InPromotion> inPromotionMenu = inPromotionService.getAll();
		model.addAttribute("inPromotionMenu", inPromotionMenu);
		return "admin/inpromotion/inpromotionAdmin";
	}

	@RequestMapping("/toAdd")
	public String toAll() throws Exception {
		return "admin/inpromotion/inpromotionAdd";
	}

	@RequestMapping("/add")
	public String add(InPromotion t) throws Exception {
		inPromotionService.add(t);
		return "redirect:getAll";
	}

	@RequestMapping("/toEdit")
	public String toEdit(Model model, Integer id) throws Exception {
		InPromotion menu = inPromotionService.getById(id);
		model.addAttribute("menu", menu);
		return "admin/inpromotion/inpromotionEdit";
	}

	@RequestMapping("/edit")
	public String edit(InPromotion t) throws Exception {
		inPromotionService.update(t);
		return "redirect:getAll";
	}

	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception {
		inPromotionService.delete(id);
		return "redirect:getAll";
	}
}
