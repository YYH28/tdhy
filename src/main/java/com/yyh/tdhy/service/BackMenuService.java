package com.yyh.tdhy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yyh.tdhy.po.BackMenu;
import com.yyh.tdhy.po.BackStageVM;

@Service
public interface BackMenuService extends BaseService<BackMenu, Integer> {
	public List<BackStageVM> getAllBackMenu() throws Exception;

	public List<BackMenu> getMenuByPid(Integer pid) throws Exception;
}
