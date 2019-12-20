package com.yyh.tdhy.controller.subPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/help")
public class Help {
	@RequestMapping("/Question")
	public String Question() throws Exception {
		return "subPage/help/Question";
	}

	@RequestMapping("/Download")
	public String Download() throws Exception {
		return "subPage/help/Download";
	}

	@RequestMapping("/Advisory")
	public String Advisory() throws Exception {
		return "subPage/help/Advisory";
	}

	@RequestMapping("/Contraband")
	public String Contraband() throws Exception {
		return "subPage/help/Contraband";
	}

}
