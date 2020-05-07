package com.czp.project.dao.extend;

import com.czp.project.common.bean.extend.MedicalExtend;

import java.util.List;

public interface MedicalExtendMapper {
	/**
	 * 及联查询外出信息
	 * @return
	 */
	public List<MedicalExtend> selectAll();
}
