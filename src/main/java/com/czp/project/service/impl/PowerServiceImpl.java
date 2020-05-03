package com.czp.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.project.common.bean.BasePower;
import com.czp.project.common.bean.BasePowerExample;
import com.czp.project.common.bean.Charges;
import com.czp.project.common.bean.ChargesExample;
import com.czp.project.dao.BasePowerMapper;
import com.czp.project.service.interfaces.PowerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class PowerServiceImpl implements PowerService{
@Autowired
private BasePowerMapper basePowerMapper;
	@Override
	public PageInfo<BasePower> findAllForPage(int currpage, int row) {
		PageHelper.startPage(currpage, row);
		List<BasePower> list = basePowerMapper.selectByExample(new BasePowerExample());
		PageInfo<BasePower> pi = new PageInfo<BasePower>(list);
		return pi;
	}
	@Override
	public void removePowerById(int id) {
		basePowerMapper.updateUserRole(null, id);
		basePowerMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void removePowerByIds(String[] ids) {
		for (String str : ids) {
			basePowerMapper.updateUserRole(null, Integer.parseInt(str));
			basePowerMapper.deleteByPrimaryKey(Integer.parseInt(str));
		}
	}
	@Override
	public void addPower(BasePower basePower) {
		basePowerMapper.insert(basePower);
		
	}
	@Override
	public PageInfo<BasePower> findAllByName(int currpage, int row, String source) {
		PageHelper.startPage(currpage, row);
		BasePowerExample example=new BasePowerExample();
		example.createCriteria().andPowerLike("%"+source+"%");
		List<BasePower> list = basePowerMapper.selectByExample(example);
		PageInfo<BasePower> pi = new PageInfo<BasePower>(list);
		return pi;
	}
	@Override
	public int updatePower(BasePower basePower) throws Exception {
		int key = basePowerMapper.updateByPrimaryKey(basePower);
		return key;
	}
	@Override
	public List<BasePower> findAllPower() {
		return basePowerMapper.selectByExample(new BasePowerExample());
	}

}
