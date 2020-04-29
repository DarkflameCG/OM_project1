package com.czp.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.project.common.bean.extend.OldManRuZhuEX;
import com.czp.project.dao.ex.OldManRuZhuEXMapper;
import com.czp.project.service.interfaces.OldManRuZhuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class OldManRuZhuServiceImpl implements OldManRuZhuService{
@Autowired
private OldManRuZhuEXMapper oldManRuZhuEXMapper;
	@Override
	public PageInfo<OldManRuZhuEX> findAllOldManRuZhuEX(int currpage, int row) throws Exception {
		PageHelper.startPage(currpage, row);
		List<OldManRuZhuEX> list = oldManRuZhuEXMapper.findAllOldManRuZhuEX();
		PageInfo<OldManRuZhuEX> pi = new PageInfo<OldManRuZhuEX>(list);
		return pi;
	}

}
