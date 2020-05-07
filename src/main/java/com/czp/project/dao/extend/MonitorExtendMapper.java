package com.czp.project.dao.extend;

import com.czp.project.common.bean.extend.MonitorExtend;

import java.util.List;

public interface MonitorExtendMapper {
	/**
	 * 及联查询外出信息
	 * @return
	 */
	public List<MonitorExtend> selectAll();
}
