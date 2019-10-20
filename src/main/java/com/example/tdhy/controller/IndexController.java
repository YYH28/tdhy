package com.example.tdhy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tdhy.po.InProduct;
import com.example.tdhy.po.NavigationVm;
import com.example.tdhy.service.InProductService;
import com.example.tdhy.service.NavigativaService;

@Controller
@RequestMapping("/tdhy")
public class IndexController {

	@Autowired
	private InProductService inProductService;

	@Autowired
	private NavigativaService navigationService;

	@RequestMapping("/index")
	public String getAll(Model model) throws Exception {
		List<NavigationVm> navigationMenus = navigationService.getAllNavVm();
		model.addAttribute("navigationVms", navigationMenus);
		List<InProduct> inProductMenus = inProductService.getAll();
		model.addAttribute("inProductMenus", inProductMenus);

		return "index";
	}

}
