package com.example.tdhy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tdhy.po.ResultMsg;
import com.example.tdhy.service.AlbumService;

@RestController
@RequestMapping("/api/album")
public class AlbumApi {
	@Autowired
	private AlbumService albumService;

	@RequestMapping("/delete")
	public ResultMsg delete(String id) throws Exception {
		ResultMsg msg = null;
		if (id != null && id.length() > 0) {
			msg = new ResultMsg();
			albumService.delete(id);
			msg.setCode(10001);
			msg.setMsg("图片删除成功");
		} else {
			msg = new ResultMsg();
			msg.setCode(10002);
			msg.setMsg("图片删除失败");
		}
		return msg;

	}

}
