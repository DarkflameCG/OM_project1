package com.czp.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.project.common.bean.BasePower;
import com.czp.project.common.bean.BasePowerExample;
import com.czp.project.common.bean.UserLeave;
import com.czp.project.common.bean.extend.UserLeaveEX;
import com.czp.project.dao.UserLeaveMapper;
import com.czp.project.dao.ex.UserLeaveEXMapper;
import com.czp.project.service.interfaces.UserLeaveService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class UserLeaveServiceImpl implements UserLeaveService{
@Autowired
private UserLeaveEXMapper userLeaveEXMapper;
@Autowired
private UserLeaveMapper userLeaveMapper;
	@Override
	public PageInfo<UserLeaveEX> findAllUserLeaveEX(int currpage, int row) throws Exception {
		PageHelper.startPage(currpage, row);
		List<UserLeaveEX> list = userLeaveEXMapper.findAllUserLeaverEX();
		PageInfo<UserLeaveEX> pi = new PageInfo<UserLeaveEX>(list);
		return pi;
	}
	@Override
	public void removeAttendById(int id) {
		userLeaveMapper.deleteByPrimaryKey(id);
		
	}
	@Override
	public void removeAttendByIdByIds(String[] ids) {
		for (String str : ids) {
			userLeaveMapper.deleteByPrimaryKey(Integer.parseInt(str));
		}
		
	}
	@Override
	public void addAttend(UserLeave userLeave) {
		userLeaveMapper.insert(userLeave);
		
	}
	@Override
	public void updateAttend(UserLeave userLeave) {
		userLeaveMapper.updateByPrimaryKey(userLeave);
		
	}
	@Override
	public PageInfo<UserLeaveEX> findAllByName(int currpage, int row, String source) {
		PageHelper.startPage(currpage, row);
		List<UserLeaveEX> list = userLeaveEXMapper.findAllUserLeaverEXByName(source);
		System.out.println(list);
		PageInfo<UserLeaveEX> pi = new PageInfo<UserLeaveEX>(list);
		return pi;
	}
	@Override
	public void updateAttend2(int state,int id) {
		userLeaveMapper.updateByPrimaryKey2(state,id);
		
	}

}
