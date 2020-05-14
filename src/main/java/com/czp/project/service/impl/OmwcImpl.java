package com.czp.project.service.impl;

import java.util.List;

import com.czp.project.common.bean.OmQingjiaExample;
import com.czp.project.common.bean.OmWaichuExample;
import com.czp.project.common.bean.extend.ZhuanFangExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.project.common.bean.OmWaichu;
import com.czp.project.common.bean.extend.WaichuExtend;
import com.czp.project.dao.OmWaichuMapper;
import com.czp.project.dao.extend.OmwcExtendMapper;
import com.czp.project.service.interfaces.OmwcService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OmwcImpl implements OmwcService{
	@Autowired
	private OmwcExtendMapper omwcExtendMapper;
	@Autowired
	private OmWaichuMapper omwcMapper;
	
	@Override
	public List<WaichuExtend> selectAll() {
		return omwcExtendMapper.selectAll();
	}

	@Override
	public PageInfo<WaichuExtend> selectAllByPage(int currpage, int row) {
		PageHelper.startPage(currpage, row);
		return new PageInfo<WaichuExtend>(this.selectAll());
	}

	@Override
	public PageInfo<WaichuExtend> fuzzyQueryByPage(String name, int currpage, int row) throws Exception {
		PageHelper.startPage(currpage,row);
		List<WaichuExtend> tempList = omwcExtendMapper.selectByParameter(name);
		return new PageInfo<WaichuExtend>(tempList);
	}

	@Override
	public void addWc(OmWaichu wc) {
		omwcMapper.insert(wc);
	}

	@Override
	public void removeWcById(int id) {
		omwcMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void removeWcByids(String ids) {
		String[] value = ids.split(",");
		for (int i = 0; i < value.length; i++) {
			this.removeWcById(Integer.parseInt(value[i]));
		}
	}

	@Override
	public void updateWc(OmWaichu newmsg) {

		omwcMapper.updateByPrimaryKeySelective(newmsg);
	}

	@Override
	public OmWaichu selectWcById(String wcid) {
		return omwcMapper.selectByPrimaryKey(Integer.parseInt(wcid));
	}

	@Override
	public List<OmWaichu> selectByOldManId(String oldmanid) {
		OmWaichuExample example = new OmWaichuExample();
		example.createCriteria().andOldManIdEqualTo(Integer.parseInt(oldmanid));
		return omwcMapper.selectByExample(example);
	}

}
