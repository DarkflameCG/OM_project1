package com.czp.project.service.interfaces;

import java.util.List;

import com.czp.project.common.bean.BasePower;
import com.czp.project.common.bean.BaseUser;

public interface BasePowerService {
	//获取所有权限
	List<BasePower> selectAll();
	
}
