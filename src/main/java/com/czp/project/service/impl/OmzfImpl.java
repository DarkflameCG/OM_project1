package com.czp.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.OmZhuanfang;
import com.czp.project.dao.OmZhuanfangMapper;
import com.czp.project.dao.extend.OmzfExtendMapper;
import com.czp.project.service.interfaces.OmzfService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OmzfImpl implements OmzfService{
	@Autowired
	private OmzfExtendMapper omzfExtendMapper;
	@Autowired
	private OmZhuanfangMapper omzfMapper;

	@Override
	public List<OmZhuanfang> selectAll() {
		return omzfExtendMapper.selectAll();
	}

	@Override
	public PageInfo<OmZhuanfang> selectAllByPage(int currpage, int row) {
		PageHelper.startPage(currpage,row);
		return new PageInfo<OmZhuanfang>(this.selectAll());
	}

	@Override
	public void addZf(OmZhuanfang zf) {
		omzfMapper.insert(zf);	
	}

	@Override
	public void removeZfById(int id) {
		omzfMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void removeZfByids(String ids) {
		String[] value = ids.split(",");
		for (int i = 0; i < value.length; i++) {
			this.removeZfById(Integer.parseInt(value[i]));
		}
		
	}

	@Override
	public void updateZf(OmZhuanfang newmsg) {
		omzfMapper.updateByPrimaryKeySelective(newmsg);
		
	}
	
	
}
