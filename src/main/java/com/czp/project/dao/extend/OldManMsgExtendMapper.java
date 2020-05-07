package com.czp.project.dao.extend;
/**
 * 老人信息扩展接口
 * @author mastercgx
 *
 */

import java.util.List;

import com.czp.project.common.bean.extend.OldManExtend;

public interface OldManMsgExtendMapper {
	/**
	 * 及联查询全部
	 * @return
	 */
	public List<OldManExtend> selectAll();
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public OldManExtend selectById(String id);

	public List<OldManExtend> selectByParameter(String text);
	
}
