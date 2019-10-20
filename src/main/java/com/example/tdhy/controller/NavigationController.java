package com.example.tdhy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tdhy.po.Navigation;
import com.example.tdhy.service.NavigativaService;

@Controller
@RequestMapping("/navigation")
public class NavigationController {

	@Autowired
	private NavigativaService navigationService;

	@RequestMapping("/getAll")
	public String getAll(Model model) throws Exception {
		List<Navigation> navigationMenus = navigationService.getAll();
		model.addAttribute("navigationMenus", navigationMenus);
		return "admin/nav/indexNav";
	}

	@RequestMapping("/toAdd")
	/*
	 * public ModelAndView toAdd(ModelAndView mav,Integer id) throws Exception{
	 * mav.setViewName("admin/indexAdd"); return mav; }
	 */
	public String toAdd(Integer id) throws Exception {
		return "admin/nav/indexNavAdd";
	}

//	public ModelAndView add(Navigation navigationMenus) throws Exception{
//		ModelAndView mav;
//		navigationService.add(navigationMenus);
//		return new ModelAndView("redirect:/navigation/getAll");
//		
//	}

	@RequestMapping("/add")
	public String add(Model model, Navigation t) throws Exception {
		navigationService.add(t);
		return "redirect:/navigation/getAll";
	}

	@RequestMapping("/toEdit")
	public String toEdit(Model model, Integer id) throws Exception {
		Navigation navigationMenus = navigationService.getById(id);
		model.addAttribute("menu", navigationMenus);
		return "admin/nav/indexEdit";
	}

	@RequestMapping("/edit")
	public String edit(Model model, Navigation t) throws Exception {
		navigationService.update(t);
		return "redirect:/navigation/getAll";
	}

	@RequestMapping("/delete")
	public String delete(Model model, Integer id) throws Exception {
		navigationService.delete(id);
		return "redirect:/navigation/getAll";
	}
}
