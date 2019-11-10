package com.yyh.tdhy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyh.tdhy.mapper.SortMapper;
import com.yyh.tdhy.po.Sort;
import com.yyh.tdhy.service.SortService;

@Service
public class SortServiceImpl implements SortService {

	@Autowired
	private SortMapper sortMapper;

	@Override
	public List<Sort> getAll() throws Exception {
		// TODO Auto-generated method stub
		return sortMapper.selectByExample(null);
	}

	@Override
	public int add(Sort t) throws Exception {
		sortMapper.insertSelective(t);
		return 1;
	}

	@Override
	public int update(Sort t) throws Exception {
		sortMapper.updateByPrimaryKeySelective(t);
		return 1;
	}

	@Override
	public int delete(Integer id) throws Exception {
		sortMapper.deleteByPrimaryKey(id);
		return 1;
	}

	@Override
	public Sort getById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return sortMapper.selectByPrimaryKey(id);

	}

}
