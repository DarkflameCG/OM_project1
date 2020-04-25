package com.czp.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.project.common.bean.BaseUser;
import com.czp.project.common.bean.BaseUserExample;
import com.czp.project.common.bean.OldMan;
import com.czp.project.dao.BaseUserMapper;
import com.czp.project.service.interfaces.BaseUserService;
import com.czp.project.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class BaseUserServiceImpl implements BaseUserService {
@Autowired
private BaseUserMapper baseUserMapper;
	@Override
	public void addUser(BaseUser baseUser) {
		baseUserMapper.insert(baseUser);
		
	}
	@Override
	public PageUtil<BaseUser> findAll(int curPage, int row) throws Exception {
		List<BaseUser> all = baseUserMapper.findAll((curPage-1)*row, row);
		System.out.println(all);
		PageUtil<BaseUser> pu = new PageUtil<>();
		pu.setCurPage(curPage);
		pu.setData(all);
		pu.setROW(row);
		pu.setRows(getAllRows());
		return pu;
	}
	@Override
	public int getAllRows() throws Exception {
		return baseUserMapper.getAllRows();
	}
	@Override
	public synchronized int deleteUser(int id) throws Exception {
		System.out.println("id:"+id);
		baseUserMapper.updateByoldman(null, id);
		int key = baseUserMapper.deleteByPrimaryKey(id);
		System.out.println("删除:"+key);
		return key;
	}
	@Override
	public Integer deleteMany(String[] ids) throws Exception {
		return baseUserMapper.deleteMany(ids);
	}
	@Override
	public List<BaseUser> selectByName(String name) throws Exception {
		return baseUserMapper.selectByName(name);
	}
	@Override
	public BaseUser selectLogin(BaseUser baseUser) throws Exception {
		return baseUserMapper.selectLogin(baseUser);
	}
	@Override
	public int updateUser(BaseUser baseUser) throws Exception {
		int key = baseUserMapper.updateByPrimaryKey(baseUser);
		return key;
	}
	@Override
	public PageInfo<BaseUser> selectByExample(int currpage, int row) throws Exception {
	
		PageHelper.startPage(currpage, row);
		List<BaseUser> list = baseUserMapper.selectByExample(new BaseUserExample());
		System.out.println("查询："+list);
		PageInfo<BaseUser> pi = new PageInfo<BaseUser>(list);
		return pi;
	}

}
