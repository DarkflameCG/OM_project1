package com.czp.project.dao.extend;

import java.util.List;

import com.czp.project.common.bean.OmZhuanfang;
import com.czp.project.common.bean.extend.ZhuanFangExtend;

public interface OmzfExtendMapper {
	
	/**
	 * 及联查询转房信息
	 * @return
	 */
	public List<ZhuanFangExtend> selectAll();
}
