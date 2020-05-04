package com.czp.project.common.bean.extend;

import com.czp.project.common.bean.BaseUser;
import com.czp.project.common.bean.FamilyMembers;
import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OldManExtend extends OldMan{
	
	private Room room; //房间对象
	private FamilyMembers son; //家属对象
	private BaseUser hugong; // 护工对象
}