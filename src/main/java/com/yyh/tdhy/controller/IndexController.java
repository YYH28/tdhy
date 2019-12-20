package com.yyh.tdhy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yyh.tdhy.po.Album;
import com.yyh.tdhy.po.InNews;
import com.yyh.tdhy.po.InProduct;
import com.yyh.tdhy.po.InPromotion;
import com.yyh.tdhy.po.NavigationVm;
import com.yyh.tdhy.service.AlbumService;
import com.yyh.tdhy.service.InNewsService;
import com.yyh.tdhy.service.InProductService;
import com.yyh.tdhy.service.InPromotionService;
import com.yyh.tdhy.service.NavigationService;

@Controller
@RequestMapping("/tdhy")
public class IndexController {

	@Autowired
	private InProductService inProductService;

	@Autowired
	private NavigationService navigationService;

	@Autowired
	private InPromotionService inPromotionService;
	@Autowired
	private InNewsService inNewsService;
	@Autowired
	private AlbumService albumService;

	@RequestMapping("/index")
	public String getAll(Model model) throws Exception {
		List<NavigationVm> navigationMenus = navigationService.getAllNavVm();
		model.addAttribute("navigationVms", navigationMenus);
		List<InProduct> inProductMenus = inProductService.getAll();
		model.addAttribute("inProductMenus", inProductMenus);
		List<InPromotion> inPromotionMenus = inPromotionService.getAll();
		model.addAttribute("inPromotionMenus", inPromotionMenus);
		List<InNews> inNewsMenus = inNewsService.getAll();
		model.addAttribute("inNewsMenus", inNewsMenus);
		List<Album> albumMenus = albumService.getAll();
		model.addAttribute("albumMenus", albumMenus);
		return "index";
	}

}
