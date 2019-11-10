package com.yyh.tdhy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyh.tdhy.mapper.NavigationMapper;
import com.yyh.tdhy.po.Navigation;
import com.yyh.tdhy.po.NavigationExample;
import com.yyh.tdhy.po.NavigationVm;
import com.yyh.tdhy.service.NavigationService;

@Service
public class NavigationServiceImpl implements NavigationService {

	@Autowired
	private NavigationMapper navigationMapper;

	@Override
	public List<Navigation> getAll() throws Exception {
		return navigationMapper.selectByExample(null);
	}

	@Override
	public int add(Navigation t) throws Exception {
		try {
			navigationMapper.insertSelective(t);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Navigation t) throws Exception {
		try {
			navigationMapper.updateByPrimaryKeySelective(t);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(Integer id) throws Exception {
		try {
			navigationMapper.deleteByPrimaryKey(id);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Navigation getById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return navigationMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<NavigationVm> getAllNavVm() throws Exception {
		List<Navigation> firstNavs = getMenuByPid(0);
		List<NavigationVm> vms = new ArrayList<NavigationVm>();
		for (Navigation nav : firstNavs) {
			NavigationVm vm = new NavigationVm();
			List<Navigation> childNavs = getMenuByPid(nav.getId());
			BeanUtils.copyProperties(nav, vm);
			vm.setNavigationChildren(childNavs);
			vms.add(vm);
		}
		return vms;
	}

	@Override
	public List<Navigation> getMenuByPid(Integer pid) throws Exception {
		NavigationExample navigationExample = new NavigationExample();
		NavigationExample.Criteria criteria = navigationExample.createCriteria();
		criteria.andPidEqualTo(pid);
		return navigationMapper.selectByExample(navigationExample);
	}

}
