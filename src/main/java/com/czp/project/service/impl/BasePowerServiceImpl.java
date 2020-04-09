package com.czp.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.project.common.bean.BasePower;
import com.czp.project.common.bean.BaseUser;
import com.czp.project.dao.BasePowerMapper;
import com.czp.project.service.interfaces.BasePowerService;
@Service
public class BasePowerServiceImpl implements BasePowerService{
	@Autowired
	private BasePowerMapper basePowerMapper;
	@Override
	public List<BasePower> selectAll() {
		
		return basePowerMapper.selectAll();
	}
	

}
