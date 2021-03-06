package com.czp.project.service.impl;

import java.util.List;

import com.czp.project.common.bean.extend.OldManRuZhuEX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.OmZhuanfang;
import com.czp.project.common.bean.extend.ZhuanFangExtend;
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
	public List<ZhuanFangExtend> selectAll() {
		return omzfExtendMapper.selectAll();
	}

	@Override
	public PageInfo<ZhuanFangExtend> selectAllByPage(int currpage, int row) {
		PageHelper.startPage(currpage,row);
		return new PageInfo<ZhuanFangExtend>(this.selectAll());
	}

	@Override
	public PageInfo<ZhuanFangExtend> fuzzyQueryByPage(String name, int currpage, int row) throws Exception {
		PageHelper.startPage(currpage,row);
		List<ZhuanFangExtend> tempList = omzfExtendMapper.selectByParameter(name);
		return new PageInfo<ZhuanFangExtend>(tempList);
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
