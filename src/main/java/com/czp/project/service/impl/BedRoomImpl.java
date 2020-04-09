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

}
