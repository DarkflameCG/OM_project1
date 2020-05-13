package com.czp.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.project.common.bean.OmQingjia;
import com.czp.project.common.bean.OmWaichu;
import com.czp.project.common.bean.extend.QingjiaExtend;
import com.czp.project.common.bean.extend.WaichuExtend;
import com.czp.project.dao.OmQingjiaMapper;
import com.czp.project.dao.extend.OmqjExtendMapper;
import com.czp.project.service.interfaces.OmqjService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OmqjImpl implements OmqjService{
	
	@Autowired
	private OmqjExtendMapper omqjExtendMapper;
	@Autowired
	private OmQingjiaMapper omqjMapper;
	
	@Override
	public List<QingjiaExtend> selectAll() {
		return omqjExtendMapper.selectAll();
	}

	@Override
	public PageInfo<QingjiaExtend> selectAllByPage(int currpage, int row) {
		PageHelper.startPage(currpage, row);
		return new PageInfo<QingjiaExtend>(this.selectAll());
	}

	@Override
	public PageInfo<QingjiaExtend> fuzzyQueryByPage(String name, int currpage, int row) throws Exception {
		PageHelper.startPage(currpage,row);
		List<QingjiaExtend> tempList = omqjExtendMapper.selectByParameter(name);
		return new PageInfo<QingjiaExtend>(tempList);
	}

	@Override
	public void addQj(OmQingjia qj) {
		omqjMapper.insert(qj);
	}

	@Override
	public void removeQjById(int id) {
		omqjMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void removeQjByids(String ids) {
		String[] value = ids.split(",");
		for (int i = 0; i < value.length; i++) {
			this.removeQjById(Integer.parseInt(value[i]));
		}
	}

	@Override
	public void updateQj(OmQingjia newmsg) {
		omqjMapper.updateByPrimaryKeySelective(newmsg);

	}

	@Override
	public OmQingjia selectWcById(String qjid) {
		return omqjMapper.selectByPrimaryKey(Integer.parseInt(qjid));
	}


}
