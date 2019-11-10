package com.yyh.tdhy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyh.tdhy.mapper.extend.ArticleMapperExtend;
import com.yyh.tdhy.po.Article;
import com.yyh.tdhy.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapperExtend articleMapperExtend;

	@Override
	public List<Article> getAll() throws Exception {
		// TODO Auto-generated method stub
		return articleMapperExtend.selectByExample(null);
	}

	@Override
	public int add(Article t) throws Exception {
		articleMapperExtend.insertSelective(t);
		return 1;
	}

	@Override
	public int update(Article t) throws Exception {
		articleMapperExtend.updateByPrimaryKeySelective(t);
		return 1;
	}

	@Override
	public int delete(Integer id) throws Exception {
		articleMapperExtend.deleteByPrimaryKey(id);
		return 1;
	}

	@Override
	public Article getById(Integer id) throws Exception {
		return articleMapperExtend.selectByPrimaryKey(id);
	}

}
