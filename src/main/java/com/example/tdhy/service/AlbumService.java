package com.example.tdhy.service;

import com.example.tdhy.po.Album;

public interface AlbumService extends BaseService<Album, String> {

	public Album getById(String id) throws Exception;
}
