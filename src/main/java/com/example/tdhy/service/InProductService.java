package com.example.tdhy.service;

import org.springframework.stereotype.Service;

import com.example.tdhy.po.InProduct;

@Service
public interface InProductService extends BaseService<InProduct, Integer> {

	public InProduct getById(Integer id) throws Exception;
}
