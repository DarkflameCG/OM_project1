package com.czp.project.service.impl;

import java.util.List;

import com.czp.project.common.bean.OldManRuZhu;
import com.czp.project.common.bean.extend.OldManExtend;
import com.czp.project.dao.OldManRuZhuMapper;
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
	@Autowired
	private OldManRuZhuMapper omrzMapper;
	@Override
	public PageInfo<OldManRuZhuEX> findAllOldManRuZhuEX(int currpage, int row) throws Exception {
		PageHelper.startPage(currpage, row);
		List<OldManRuZhuEX> list = oldManRuZhuEXMapper.findAllOldManRuZhuEX();
		PageInfo<OldManRuZhuEX> pi = new PageInfo<OldManRuZhuEX>(list);
		return pi;
	}

	@Override
	public PageInfo<OldManRuZhuEX> fuzzyQueryByPage(String name, int currpage, int row) throws Exception {
		PageHelper.startPage(currpage,row);
		List<OldManRuZhuEX> tempList = oldManRuZhuEXMapper.selectByParameter(name);
		return new PageInfo<OldManRuZhuEX>(tempList);
	}

	@Override
	public void addRz(OldManRuZhu rz) {
		omrzMapper.insert(rz);
	}

	@Override
	public void removeRzById(int id) {
		omrzMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void removeRzByids(String ids) {
		String[] value = ids.split(",");
		for (int i = 0; i < value.length; i++) {
			this.removeRzById(Integer.parseInt(value[i]));
		}
	}

	@Override
	public void updateRz(OldManRuZhu newmsg) {
		omrzMapper.updateByPrimaryKeySelective(newmsg);
	}


}
