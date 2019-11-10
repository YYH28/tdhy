package com.yyh.tdhy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyh.tdhy.mapper.BackMenuMapper;
import com.yyh.tdhy.po.BackMenu;
import com.yyh.tdhy.po.BackMenuExample;
import com.yyh.tdhy.po.BackStageVM;
import com.yyh.tdhy.service.BackMenuService;

@Service
public class BackMenuServiceImpl implements BackMenuService {

	@Autowired
	private BackMenuMapper backMenuMapper;

	@Override
	public List<BackMenu> getAll() throws Exception {
		return backMenuMapper.selectByExample(null);

	}

	@Override
	public int add(BackMenu t) throws Exception {
		backMenuMapper.insertSelective(t);
		return 1;
	}

	@Override
	public int update(BackMenu t) throws Exception {
		backMenuMapper.updateByPrimaryKeySelective(t);
		return 1;
	}

	@Override
	public int delete(Integer id) throws Exception {
		backMenuMapper.deleteByPrimaryKey(id);
		return 1;
	}

	@Override
	public BackMenu getById(Integer id) throws Exception {

		return backMenuMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<BackStageVM> getAllBackMenu() throws Exception {
		List<BackMenu> firstBackMenu = getMenuByPid(0);
		List<BackStageVM> backMenuChildren = new ArrayList<BackStageVM>();
		for (BackMenu bm : firstBackMenu) {
			BackStageVM backStageVM = new BackStageVM();
			List<BackMenu> children = getMenuByPid(bm.getId());
			BeanUtils.copyProperties(bm, backStageVM);
			backStageVM.setBackMenuChildren(children);
			backMenuChildren.add(backStageVM);
		}
		return backMenuChildren;
	}

	@Override
	public List<BackMenu> getMenuByPid(Integer pid) throws Exception {
		BackMenuExample example = new BackMenuExample();
		BackMenuExample.Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pid);
		return backMenuMapper.selectByExample(example);
	}

}
