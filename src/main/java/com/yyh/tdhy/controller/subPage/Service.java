package com.yyh.tdhy.controller.subPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service")
public class Service {
	@RequestMapping("/cooperation")
	public String cooperation() throws Exception {
		return "subPage/service/cooperation";
	}

	@RequestMapping("/Terrace")
	public String Terrace() throws Exception {
		return "subPage/service/Terrace";
	}

	@RequestMapping("/ContactUs")
	public String ContactUs() throws Exception {
		return "subPage/service/ContactUs";
	}

}
