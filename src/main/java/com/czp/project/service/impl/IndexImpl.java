package com.czp.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.project.common.bean.Index;
import com.czp.project.dao.IndexMapper;
import com.czp.project.service.interfaces.IndexService;
import com.github.pagehelper.PageInfo;

@Service
public class IndexImpl implements IndexService{

	@Autowired
	private IndexMapper indexmapper;
	
	@Override
	public void addIndex(Index index) {
		// TODO Auto-generated method stub
		indexmapper.insert(index);
		
	}

	@Override
	public void removeIndexById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeIndexByIds(String ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eidtIndex(Index index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Index> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<Index> findAllForPage(int currpage, int row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findIndexBySting(String name) {
		// TODO Auto-generated method stub
		
	}

}
