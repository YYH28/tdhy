package com.example.tdhy.service;

import java.util.List;

import com.example.tdhy.po.Navigation;
import com.example.tdhy.po.NavigationVm;

public interface NavigativaService extends BaseService<Navigation, Integer> {

	public Navigation getById(Integer id) throws Exception;

	public List<NavigationVm> getAllNavVm() throws Exception;

	public List<Navigation> getMenuByPid(Integer pid) throws Exception;
}
