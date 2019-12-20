package com.yyh.tdhy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyh.tdhy.mapper.InNewsMapper;
import com.yyh.tdhy.po.InNews;
import com.yyh.tdhy.service.InNewsService;

@Service
public class InNewsServiceImpl implements InNewsService {

	@Autowired
	private InNewsMapper inNewsMapper;

	@Override
	public List<InNews> getAll() throws Exception {
		// TODO Auto-generated method stub
		return inNewsMapper.selectByExample(null);
	}

	@Override
	public int add(InNews t) throws Exception {
		// TODO Auto-generated method stub
		inNewsMapper.insertSelective(t);
		return 1;
	}

	@Override
	public int update(InNews t) throws Exception {
		// TODO Auto-generated method stub
		inNewsMapper.updateByPrimaryKeySelective(t);
		return 1;
	}

	@Override
	public int delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		inNewsMapper.deleteByPrimaryKey(id);
		return 1;
	}

	@Override
	public InNews getById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return inNewsMapper.selectByPrimaryKey(id);
	}

}
