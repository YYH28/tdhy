package com.yyh.tdhy.service;

import com.yyh.tdhy.po.Album;

public interface AlbumService extends BaseService<Album, String> {

	public Album getById(String id) throws Exception;
}
