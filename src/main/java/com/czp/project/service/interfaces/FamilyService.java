package com.czp.project.service.interfaces;

import com.czp.project.common.bean.FamilyMembers;

public interface FamilyService {
	FamilyMembers selectLogin(FamilyMembers familyMembers) throws Exception;
	void updateBytelphone(FamilyMembers familyMembers) throws Exception;
}
