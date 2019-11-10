package com.yyh.tdhy.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID extends Serializable> {
	// 查询所有
	public List<T> getAll() throws Exception;

	// 添加
	public int add(T t) throws Exception;

	// 修改
	public int update(T t) throws Exception;

	// 删除
	public int delete(ID id) throws Exception;

	// 根据ID查找
	public T getById(ID id) throws Exception;

}
