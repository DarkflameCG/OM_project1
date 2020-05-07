package com.czp.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.OldManExample;
import com.czp.project.common.bean.extend.OldManExtend;
import com.czp.project.dao.OldManMapper;
import com.czp.project.dao.extend.OldManMsgExtendMapper;
import com.czp.project.service.interfaces.OldManMsgService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OldManMsgImpl implements OldManMsgService{

	@Autowired
	private OldManMapper oldamanmapper;
	@Autowired
	private OldManMsgExtendMapper oldmanExtendMapper;
	
	@Override
	public List<OldManExtend> selectAll(){
		return oldmanExtendMapper.selectAll();
		//return oldamanmapper.selectByExample(new OldManExample());
	}

	@Override
	public PageInfo<OldManExtend> selectMsgByPage(int currpage, int row) throws Exception {
		PageHelper.startPage(currpage, row);
		List<OldManExtend> templist = this.selectAll();
		PageInfo<OldManExtend> pi = new PageInfo<OldManExtend>(templist);
		return pi;
	}

	

	@Override
	public List<OldMan> selectMsgByString(String name) {
		
		OldManExample example = new OldManExample();
		example.createCriteria().andOldmanNameLike("%"+name+"%");
		return oldamanmapper.selectByExample(example);
		
	}
	
	@Override
	public PageInfo<OldManExtend> fuzzyQueryByPage(String name, int currpage, int row) throws Exception {
		PageHelper.startPage(currpage,row);
		List<OldManExtend> templist = oldmanExtendMapper.selectByParameter(name);
		PageInfo<OldManExtend> pi = new PageInfo<OldManExtend>(templist);
		return pi;
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
		oldamanmapper.updateByPrimaryKeySelective(newmsg);
	}


	@Override
	public OldMan getOldmanByNumb(String numb) {
		OldManExample example = new OldManExample();
		example.createCriteria().andOldNumberEqualTo(numb);
		return oldamanmapper.selectByExample(example).get(0);
	}


	

}
