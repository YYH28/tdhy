package com.yyh.tdhy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yyh.tdhy.po.BackMenu;
import com.yyh.tdhy.service.BackMenuService;

@RestController
@RequestMapping("/admin")
public class BackMenuApi {

	@Autowired
	private BackMenuService backMenuService;

	@RequestMapping("/menuAdd")
	public String menuAdd(Model model, BackMenu backMenu) throws Exception {
		backMenuService.add(backMenu);

		return "redirect:/admin/menuGetAll";
	}

	@RequestMapping("/menuEdit")
	@ResponseBody
	public int menuEdit(@RequestBody JSONObject backMenu) throws Exception {
		BackMenu getBackMenu = JSON.toJavaObject(backMenu, BackMenu.class);
		backMenuService.update(getBackMenu);
		return 1;
	}
}
