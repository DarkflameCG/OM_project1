package com.czp.project.service.interfaces;

import java.util.List;

import com.czp.project.common.bean.BaseUser;
import com.czp.project.utils.PageUtil;

public interface BaseUserService {
	//增加员工信息
		void addUser(BaseUser baseUser);
	/*
	 * 条件检索
	 */
	public PageUtil<BaseUser> findAll(int curPage,
			int row) throws Exception;
	public int getAllRows() throws  Exception;
	//删除员工
	public void deleteUser(int id) throws Exception;
	//批量删除
	 public Integer deleteMany(String[] ids) throws Exception;
	//查询
	 List<BaseUser> selectByName(String name) throws Exception;
	//验证用户名密码权限是否一致
	  	BaseUser selectLogin(BaseUser baseUser) throws Exception;
}
