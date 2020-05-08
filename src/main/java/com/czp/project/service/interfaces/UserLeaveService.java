package com.czp.project.service.interfaces;

import com.czp.project.common.bean.UserLeave;
import com.czp.project.common.bean.extend.UserLeaveEX;
import com.github.pagehelper.PageInfo;

public interface UserLeaveService {
	PageInfo<UserLeaveEX> findAllUserLeaveEX(int currpage, int row) throws Exception;
	/**
	 * 根据id删除考勤
	 * @param id
	 */
	public void removeAttendById(int id);
	/**
	 * 批量删除考勤
	 * @param ids
	 */
	public void removeAttendByIdByIds(String[] ids);
	/**
	 * 添加考勤
	 * @param index
	 */
	public void addAttend(UserLeave userLeave);
	/**
	 * 修改考勤
	 * @param index
	 */
	public void updateAttend(UserLeave userLeave);
	/**
	 * 通过或拒绝考勤
	 * @param index
	 */
	public void updateAttend2(int state,int id);
	public PageInfo<UserLeaveEX> findAllByName(int currpage, int row, String source);
}
