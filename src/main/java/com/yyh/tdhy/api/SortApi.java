package com.yyh.tdhy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yyh.tdhy.po.Sort;
import com.yyh.tdhy.service.SortService;

@RestController
@RequestMapping("/admin/sort")
public class SortApi {

	@Autowired
	private SortService sortService;

	@RequestMapping(value = "/sortAdd", method = RequestMethod.POST)
	public ModelAndView sortAdd(Sort sort) throws Exception {
		sortService.add(sort);
		ModelAndView model = new ModelAndView("/admin/sort/sortGetAll");
		return model;
	}

	@RequestMapping(value = "/sortEdit", method = RequestMethod.POST)
	public ModelAndView sortEdit(Sort sort) throws Exception {
		sortService.update(sort);
		ModelAndView model = new ModelAndView("/admin/sort/sortGetAll");
		return model;
	}
}
