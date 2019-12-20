package com.yyh.tdhy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyh.tdhy.mapper.InPromotionMapper;
import com.yyh.tdhy.po.InPromotion;
import com.yyh.tdhy.service.InPromotionService;

@Service
public class InPromotionServiceImpl implements InPromotionService {

	@Autowired
	private InPromotionMapper inPromotionMapper;

	@Override
	public List<InPromotion> getAll() throws Exception {
		return inPromotionMapper.selectByExample(null);
	}

	@Override
	public int add(InPromotion t) throws Exception {
		// TODO Auto-generated method stub
		inPromotionMapper.insertSelective(t);
		return 1;
	}

	@Override
	public int update(InPromotion t) throws Exception {
		// TODO Auto-generated method stub
		inPromotionMapper.updateByPrimaryKeySelective(t);
		return 1;
	}

	@Override
	public int delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		inPromotionMapper.deleteByPrimaryKey(id);
		return 1;
	}

	@Override
	public InPromotion getById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return inPromotionMapper.selectByPrimaryKey(id);
	}

}
