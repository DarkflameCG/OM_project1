package com.czp.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.project.common.bean.FamilyMembers;
import com.czp.project.common.bean.FamilyMembersExample;
import com.czp.project.dao.FamilyMembersMapper;
import com.czp.project.service.interfaces.FamilyService;
@Service
public class FamilyServiceImpl implements FamilyService{
     @Autowired
     private FamilyMembersMapper familyMembersMapper;
	@Override
	public FamilyMembers selectLogin(FamilyMembers familyMembers) throws Exception {
		FamilyMembersExample example=new FamilyMembersExample();
		example.createCriteria().andTelphoneEqualTo(familyMembers.getTelphone())
		     .andFamilyPasswordEqualTo(familyMembers.getFamilyPassword());
		List<FamilyMembers> list = familyMembersMapper.selectByExample(example);
		if (list!=null) {
			return list.get(0);
		}
		return null;
	}
	@Override
	public void updateBytelphone(FamilyMembers familyMembers) throws Exception {
		familyMembersMapper.updateBytelphone(familyMembers);
		
	}

}
