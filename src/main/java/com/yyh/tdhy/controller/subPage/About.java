package com.yyh.tdhy.controller.subPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class About {
	@RequestMapping("/introduction")
	public String introduction() throws Exception {
		return "subPage/about/introduction";
	}

	@RequestMapping("/CompanyBigEvent")
	public String CompanyBigEvent() throws Exception {
		return "subPage/about/CompanyBigEvent";
	}

	@RequestMapping("/ContactUs")
	public String ContactUs() throws Exception {
		return "subPage/about/ContactUs";
	}

	@RequestMapping("/Honor")
	public String Honor() throws Exception {
		return "subPage/about/Honor";
	}

	@RequestMapping("/Show")
	public String Show() throws Exception {
		return "subPage/about/Show";
	}

	@RequestMapping("/Social")
	public String Social() throws Exception {
		return "subPage/about/Social";
	}
}
