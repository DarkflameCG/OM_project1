package com.czp.project.dao.extend;

import java.util.List;

import com.czp.project.common.bean.extend.WaichuExtend;

public interface OmwcExtendMapper {
	/**
	 * 及联查询外出信息
	 * @return
	 */
	public List<WaichuExtend> selectAll();
}
