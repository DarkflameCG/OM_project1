package com.czp.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.project.common.bean.BaseUser;
import com.czp.project.common.bean.BaseUserExample;
import com.czp.project.dao.BaseUserMapper;
import com.czp.project.service.interfaces.NursWorkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class NursWorkServiceImpl implements NursWorkService{
	@Autowired
	private BaseUserMapper baseUserMapper;
	@Override
	public PageInfo<BaseUser> selectByExample(int currpage, int row) throws Exception {
		PageHelper.startPage(currpage, row);
		BaseUserExample example = new BaseUserExample();
		example.createCriteria().andRoleIdEqualTo(2);
		List<BaseUser> list = baseUserMapper.selectByExample(example);
		PageInfo<BaseUser> pi = new PageInfo<BaseUser>(list);
		return pi;
	}

}
