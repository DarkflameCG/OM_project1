package com.czp.project.common.bean.extend;

import com.czp.project.common.bean.BaseUser;
import com.czp.project.common.bean.FamilyMembers;
import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.Room;

public class OldManExtend extends OldMan{
	
	private Room room; //房间对象
	private FamilyMembers son; //家属对象
	private BaseUser hugong; // 护工对象
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public FamilyMembers getSon() {
		return son;
	}
	public void setSon(FamilyMembers son) {
		this.son = son;
	}
	public BaseUser getHugong() {
		return hugong;
	}
	public void setHugong(BaseUser hugong) {
		this.hugong = hugong;
	}
	
}
