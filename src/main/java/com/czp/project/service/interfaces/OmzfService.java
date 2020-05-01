package com.czp.project.service.interfaces;

import java.util.List;

import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.OmZhuanfang;
import com.github.pagehelper.PageInfo;

/**
 * 老人转房业务逻辑
 * @author mastercgx
 *
 */
public interface OmzfService {
	
	/**
	 * 及联查询全部，不带分页
	 * @return
	 */
	public List<OmZhuanfang> selectAll();
	
	/**
	 * 及联查询全部，带分页
	 * @param currpage
	 * @param row
	 * @return
	 */
	public PageInfo<OmZhuanfang> selectAllByPage(int currpage , int row);

	/**
	 * 添加转房记录
	 * @param zf
	 */
	public void addZf(OmZhuanfang zf);

	/**
	 * 根据id删除一条转房记录
	 * @param id
	 */
	public void removeZfById(int id); 
	/**
	 * 批量删除转房记录
	 * @param ids
	 */
	public void removeZfByids(String ids);
	/**
	 * 修改转房记录
	 * @param newmsg
	 */
	public void updateZf(OmZhuanfang newmsg);
	
	
}
