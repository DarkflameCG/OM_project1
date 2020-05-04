package com.czp.project.service.interfaces;

import java.util.List;

import com.czp.project.common.bean.OmWaichu;
import com.czp.project.common.bean.OmZhuanfang;
import com.czp.project.common.bean.extend.WaichuExtend;
import com.czp.project.common.bean.extend.ZhuanFangExtend;
import com.github.pagehelper.PageInfo;

/**
 * 外出业务逻辑接口
 * @author mastercgx
 *
 */
public interface OmwcService {
	/**
	 * 及联查询全部，不带分页
	 * @return
	 */
	public List<WaichuExtend> selectAll();
	
	/**
	 * 及联查询全部，带分页
	 * @param currpage
	 * @param row
	 * @return
	 */
	public PageInfo<WaichuExtend> selectAllByPage(int currpage , int row);

	/**
	 * 添加外出记录
	 * @param wc
	 */
	public void addWc(OmWaichu wc);

	/**
	 * 根据id删除一条转房记录
	 * @param id
	 */
	public void removeWcById(int id); 
	/**
	 * 批量删除外出记录
	 * @param ids
	 */
	public void removeWcByids(String ids);
	/**
	 * 修改外出记录
	 * @param newmsg
	 */
	public void updateWc(OmWaichu newmsg);
	
	
}
