package com.yyh.tdhy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yyh.tdhy.po.Navigation;
import com.yyh.tdhy.po.NavigationVm;
import com.yyh.tdhy.service.NavigationService;

@Controller
@RequestMapping("/subPage")
public class SubPageController {
	@Autowired
	private NavigationService navigationService;

	@RequestMapping("/test")
	public String test(Model model) throws Exception {
		List<NavigationVm> navigationMenus = navigationService.getAllNavVm();
		model.addAttribute("navigationVms", navigationMenus);
		return "about";
	}

	@RequestMapping("/about")
	public String about(Integer id, Model model) throws Exception {
		List<NavigationVm> navigationMenus = navigationService.getAllNavVm();
		model.addAttribute("navigationVms", navigationMenus);
		Navigation firstNav = navigationService.getById(id);
		model.addAttribute("firstNav", firstNav);
		System.out.println(firstNav.getNavname());
		List<NavigationVm> secondNav = navigationService.getThirdNavVm(id);
		model.addAttribute("secondNav", secondNav);
		return "about";
	}

	@RequestMapping("/help")
	public String help(Integer id, Model model) throws Exception {
		List<NavigationVm> navigationMenus = navigationService.getAllNavVm();
		model.addAttribute("navigationVms", navigationMenus);
		Navigation firstNav = navigationService.getById(id);
		model.addAttribute("firstNav", firstNav);
		System.out.println(firstNav.getNavname());
		List<NavigationVm> secondNav = navigationService.getThirdNavVm(id);
		model.addAttribute("secondNav", secondNav);
		return "help";
	}

	@RequestMapping("/prosecution")
	public String prosecution(Integer id, Model model) throws Exception {
		List<NavigationVm> navigationMenus = navigationService.getAllNavVm();
		model.addAttribute("navigationVms", navigationMenus);
		Navigation firstNav = navigationService.getById(id);
		model.addAttribute("firstNav", firstNav);
		System.out.println(firstNav.getNavname());
		List<NavigationVm> secondNav = navigationService.getThirdNavVm(id);
		model.addAttribute("secondNav", secondNav);
		return "prosecution";
	}

	@RequestMapping("/service")
	public String service(Integer id, Model model) throws Exception {
		List<NavigationVm> navigationMenus = navigationService.getAllNavVm();
		model.addAttribute("navigationVms", navigationMenus);
		Navigation firstNav = navigationService.getById(id);
		model.addAttribute("firstNav", firstNav);
		System.out.println(firstNav.getNavname());
		List<NavigationVm> secondNav = navigationService.getThirdNavVm(id);
		model.addAttribute("secondNav", secondNav);
		return "service";
	}

	@RequestMapping("/product")
	public String product(Integer id, Model model) throws Exception {
		List<NavigationVm> navigationMenus = navigationService.getAllNavVm();
		model.addAttribute("navigationVms", navigationMenus);
		Navigation firstNav = navigationService.getById(id);
		model.addAttribute("firstNav", firstNav);
		System.out.println(firstNav.getNavname());
		List<NavigationVm> secondNav = navigationService.getThirdNavVm(id);
		model.addAttribute("secondNav", secondNav);
		return "product";
	}
}
