package com.yyh.tdhy.controller.subPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class Product {
	@RequestMapping("/drArrival")
	public String drArrival() throws Exception {
		return "subPage/product/drArrival";
	}

	@RequestMapping("/heightWay")
	public String heightWay() throws Exception {
		return "subPage/product/heightWay";
	}

	@RequestMapping("/easyHome")
	public String easyHome() throws Exception {
		return "subPage/product/easyHome";
	}

	@RequestMapping("/vehicle")
	public String Honor() throws Exception {
		return "subPage/product/vehicle";
	}

	@RequestMapping("/Show")
	public String Show() throws Exception {
		return "subPage/product/Show";
	}

	@RequestMapping("/Social")
	public String Social() throws Exception {
		return "subPage/product/Social";
	}
}
