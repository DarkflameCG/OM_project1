package com.czp.project.service.interfaces;

import com.czp.project.common.bean.BaseUser;
import com.github.pagehelper.PageInfo;

public interface NursWorkService {
	PageInfo<BaseUser> selectByExample(int currpage, int row) throws Exception;
	public PageInfo<BaseUser> findAllByName(int currpage, int row,String source) throws Exception;
}
