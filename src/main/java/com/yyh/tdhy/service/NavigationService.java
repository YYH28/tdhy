package com.yyh.tdhy.service;

import java.util.List;

import com.yyh.tdhy.po.Navigation;
import com.yyh.tdhy.po.NavigationVm;

public interface NavigationService extends BaseService<Navigation, Integer> {

	public Navigation getById(Integer id) throws Exception;

	public List<NavigationVm> getAllNavVm() throws Exception;

	public List<Navigation> getMenuByPid(Integer pid) throws Exception;

	public List<NavigationVm> getThirdNavVm(Integer id) throws Exception;
}
