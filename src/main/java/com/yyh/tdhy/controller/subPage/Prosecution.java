package com.yyh.tdhy.controller.subPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prosecution")
public class Prosecution {
	@RequestMapping("/Franchise")
	public String Franchise() throws Exception {
		return "subPage/prosecution/Franchise";
	}

	@RequestMapping("/Area")
	public String Area() throws Exception {
		return "subPage/prosecution/Area";
	}

	@RequestMapping("/Dynamic")
	public String Dynamic() throws Exception {
		return "subPage/prosecution/Dynamic";
	}

	@RequestMapping("/Regist")

	public String Honor() throws Exception {
		return "subPage/prosecution/Regist";
	}

}
