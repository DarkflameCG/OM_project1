package com.czp.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.OldManExample;
import com.czp.project.dao.OldManMapper;
import com.czp.project.service.interfaces.OldManMsgService;
import com.czp.project.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OldManMsgImpl implements OldManMsgService{

	@Autowired
	private OldManMapper oldamanmapper;
	
	@Override
	public List<OldMan> selectAll() {
		
		return oldamanmapper.selectByExample(new OldManExample());
	}
	

	@Override
	public PageInfo<OldMan> selectMsgByPage(int currpage, int row) throws Exception {
		PageHelper.startPage(currpage, row);
		List<OldMan> templist = this.selectAll();
		PageInfo<OldMan> pi = new PageInfo<OldMan>(templist);
		return pi;
	}

	

	@Override
	public List<OldMan> selectMsgByString(String name) {
		
		OldManExample example = new OldManExample();
		example.createCriteria().andOldmanNameLike("%"+name+"%");
		
		return oldamanmapper.selectByExample(example);
		
	}
	
	


	@Override
	public void addOldManMsg(OldMan newmsg) {
		oldamanmapper.insert(newmsg);
	}


	@Override
	public void removeOldManMsg(int id) {
		oldamanmapper.deleteByPrimaryKey(id);
	}


	@Override
	public void removeOldByids(String ids) {
		String[] value = ids.split(",");
		for (int i = 0; i < value.length; i++) {
			this.removeOldManMsg(Integer.parseInt(value[i]));
		}
	}


	@Override
	public void updateOldManMsg(OldMan newmsg) {
		System.out.println(oldamanmapper.updateByPrimaryKeySelective(newmsg));
	}

}
