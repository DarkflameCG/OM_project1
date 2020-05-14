package com.czp.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.project.common.bean.BaseUser;
import com.czp.project.common.bean.BaseUserExample;
import com.czp.project.common.bean.Cost;
import com.czp.project.common.bean.CostExample;
import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.OldManExample;
import com.czp.project.common.bean.extend.CostEX;
import com.czp.project.dao.CostMapper;
import com.czp.project.dao.OldManMapper;
import com.czp.project.dao.ex.CostEXMapper;
import com.czp.project.service.interfaces.CostService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CostServiceImpl implements CostService{
@Autowired
private CostEXMapper costEXMapper;
@Autowired
private CostMapper costMapper;
@Autowired
private OldManMapper oldamanmapper;
	@Override
	public void addCost(Cost cost) {
		costMapper.insert(cost);
		
	}

	@Override
	public void removeCostById(int id) {
		costMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void removeCostByIds(String[] ids) {
		for (String str : ids) {
			costMapper.deleteByPrimaryKey(Integer.parseInt(str));
		}
		
	}

	@Override
	public void editCost(Cost cost) {
		costMapper.updateByPrimaryKey(cost);
		
	}

	@Override
	public List<Cost> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<CostEX> findAllForPage(int currpage, int row) {
		PageHelper.startPage(currpage, row);
		List<CostEX> list = costEXMapper.findAllCostEX();
		PageInfo<CostEX> pi = new PageInfo<CostEX>(list);
		return pi;
	}

	@Override
	public PageInfo<CostEX> findAllByName(int currpage, int row, String source) {
		PageHelper.startPage(currpage, row);
		OldManExample example = new OldManExample();
		example.createCriteria().andOldmanNameEqualTo(source);
		List<OldMan> list2 = oldamanmapper.selectByExample(example);
		List<CostEX> list = costEXMapper.findAllCostByOldManId(list2.get(0).getId());
		PageInfo<CostEX> pi = new PageInfo<CostEX>(list);
		return pi;
	}

	@Override
	public List<Cost> selectByOldManId(String oldmanid) {
		CostExample example = new CostExample();
		example.createCriteria().andOldmanIdEqualTo(Integer.parseInt(oldmanid));
		return costMapper.selectByExample(example);
	}

}
