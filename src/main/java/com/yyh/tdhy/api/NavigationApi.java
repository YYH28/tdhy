package com.yyh.tdhy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yyh.tdhy.po.Navigation;
import com.yyh.tdhy.po.ResultMsg;
import com.yyh.tdhy.service.NavigationService;

@RestController
@RequestMapping("/api/navigation")
public class NavigationApi {

	@Autowired
	private NavigationService navigationService;

	@RequestMapping("/getAll")
	public ResultMsg getAll() throws Exception {
		ResultMsg msg = new ResultMsg();
		msg.setObj(navigationService.getAll());
		return msg;
	}

	@RequestMapping("/add")
	public ResultMsg add(Navigation t) throws Exception {
		ResultMsg msg = new ResultMsg();
		msg.setObj(navigationService.add(t));

		return msg;
	}

	@RequestMapping("/edit")
	public ResultMsg edit(Navigation t) throws Exception {

		ResultMsg msg = new ResultMsg();
		msg.setObj(navigationService.update(t));

		return msg;
	}

	@RequestMapping("/delete")
	public ResultMsg delete(Model model, Integer id) throws Exception {

		ResultMsg msg = new ResultMsg();
		msg.setObj(navigationService.delete(id));

		return msg;
	}

}
