package com.czp.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.project.common.bean.Charges;
import com.czp.project.common.bean.ChargesExample;
import com.czp.project.dao.ChargesMapper;
import com.czp.project.service.interfaces.IndexService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class IndexImpl implements IndexService{

	@Autowired
	private ChargesMapper chargesMapper;
	
	@Override
	public void addIndex(Charges index) {
		// TODO Auto-generated method stub
		chargesMapper.insert(index);
		
	}

	@Override
	public void removeIndexById(int id) {
		chargesMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void removeIndexByIds(String[] ids) {
		for (String str : ids) {
			chargesMapper.deleteByPrimaryKey(Integer.parseInt(str));
		}
		
	}

	@Override
	public void eidtIndex(Charges index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Charges> findAll() {
		List<Charges> list = chargesMapper.selectByExample(new ChargesExample());
		return list;
	}

	@Override
	public PageInfo<Charges> findAllForPage(int currpage, int row) {
		PageHelper.startPage(currpage, row);
		List<Charges> list = chargesMapper.selectByExample(new ChargesExample());
		PageInfo<Charges> pi = new PageInfo<Charges>(list);
		return pi;
	}

	@Override
	public void findIndexBySting(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PageInfo<Charges> findAllByName(int currpage, int row,String source) {
		PageHelper.startPage(currpage, row);
		ChargesExample example=new ChargesExample();
		example.createCriteria().andIndexNameLike("%"+source+"%");
		List<Charges> list = chargesMapper.selectByExample(example);
		PageInfo<Charges> pi = new PageInfo<Charges>(list);
		return pi;
	}

	@Override
	public Charges findIndexById(int id) {
		return chargesMapper.selectByPrimaryKey(id);
	}

}
