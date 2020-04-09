package com.czp.project.service.interfaces;
/**
 * 床位管理的相关接口
 * @author mastercgx
 *
 */

import java.util.List;

import com.czp.project.common.bean.Room;

public interface BedRoomService {
	/**
	 * 根据楼层的id获取每一层楼的房间信息
	 * 主要是房间号和床位状态
	 * @param lid
	 * @return
	 */
	public List<Room> getRoomByLevelId(int lid);
	
}
