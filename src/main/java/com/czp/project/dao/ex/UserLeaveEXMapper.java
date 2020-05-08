package com.czp.project.dao.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.czp.project.common.bean.extend.UserLeaveEX;

public interface UserLeaveEXMapper {
	List<UserLeaveEX> findAllUserLeaverEX();
	List<UserLeaveEX> findAllUserLeaverEXByName(@Param("source") String source);
}
