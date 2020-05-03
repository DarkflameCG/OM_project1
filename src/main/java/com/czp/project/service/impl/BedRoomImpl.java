package com.czp.project.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.project.common.bean.Room;
import com.czp.project.common.bean.RoomExample;
import com.czp.project.dao.RoomMapper;
import com.czp.project.service.interfaces.BedRoomService;

@Service
public class BedRoomImpl implements BedRoomService{

	@Autowired
	private RoomMapper roommapper;
	
	@Override
	public List<Room> getRoomByLevelId(int lid) {
		RoomExample example = new RoomExample();
		example.createCriteria().andRoomNumbLike(lid+"%");
		
		return roommapper.selectByExample(example);
	}

	@Override
	public List<Room> getRoomForUsed() {
		RoomExample example = new RoomExample();
		example.createCriteria().andRoomStateEqualTo(1);
		
		return roommapper.selectByExample(example);
	}

	@Override
	public List<Room> getRoomForEmpty() {
		RoomExample example = new RoomExample();
		example.createCriteria().andRoomStateEqualTo(2);
		
		return roommapper.selectByExample(example);
	}

	@Override
	public void switchRoomStatus(int room_id) {
		Room room = roommapper.selectByPrimaryKey(room_id);
		if(room.getRoomState() == 1) {
			room.setRoomState(2);
			roommapper.updateByPrimaryKeySelective(room);
			return;
		}
		if(room.getRoomState() == 2) {
			room.setRoomState(1);
			roommapper.updateByPrimaryKeySelective(room);
			return;
		}
		
	}

}
