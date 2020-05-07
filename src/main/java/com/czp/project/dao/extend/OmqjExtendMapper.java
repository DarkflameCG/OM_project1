package com.czp.project.dao.extend;

import java.util.List;

import com.czp.project.common.bean.extend.MonitorExtend;
import com.czp.project.common.bean.extend.QingjiaExtend;

public interface OmqjExtendMapper {
	/**
	 * 及联查询外出信息
	 * @return
	 */
	public List<QingjiaExtend> selectAll();
	public List<QingjiaExtend> selectByParameter(String text);
}
