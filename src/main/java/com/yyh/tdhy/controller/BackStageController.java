package com.yyh.tdhy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yyh.tdhy.po.BackStageVM;
import com.yyh.tdhy.service.BackMenuService;

@Controller
@RequestMapping("/admin")
public class BackStageController {

	@Autowired
	private BackMenuService backMenuService;

	@RequestMapping("/index")
	public String backStage(Model model) throws Exception {
		List<BackStageVM> backStage = backMenuService.getAllBackMenu();
		model.addAttribute("backStage", backStage);
		return "backStage/BackStage";
	}
}
