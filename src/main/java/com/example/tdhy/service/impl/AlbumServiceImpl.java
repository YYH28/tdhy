package com.example.tdhy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tdhy.mapper.AlbumMapper;
import com.example.tdhy.po.Album;
import com.example.tdhy.service.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumMapper albumMapper;

	@Override
	public List<Album> getAll() throws Exception {
		// TODO Auto-generated method stub
		return albumMapper.selectByExample(null);
	}

	@Override
	public int add(Album t) throws Exception {
		// TODO Auto-generated method stub
		try {
			albumMapper.insertSelective(t);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	/*
	 * @Override public int update(Album t) throws Exception { // TODO
	 * Auto-generated method stub try { albumMapper.updateByPrimaryKeySelective(t);
	 * return 1; } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); return 0; } }
	 */

	@Override
	public int delete(String id) throws Exception {
		// TODO Auto-generated method stub
		try {
			albumMapper.deleteByPrimaryKey(id);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public Album getById(String id) throws Exception {
		// TODO Auto-generated method stub
		return albumMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Album t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
