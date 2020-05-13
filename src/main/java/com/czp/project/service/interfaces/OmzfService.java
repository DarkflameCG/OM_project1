package com.czp.project.service.interfaces;

import java.util.List;

import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.OmZhuanfang;
import com.czp.project.common.bean.OmZhuanfangExample;
import com.czp.project.common.bean.extend.OldManRuZhuEX;
import com.czp.project.common.bean.extend.ZhuanFangExtend;
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
	public List<ZhuanFangExtend> selectAll();
	
	/**
	 * 及联查询全部，带分页
	 * @param currpage
	 * @param row
	 * @return
	 */
	public PageInfo<ZhuanFangExtend> selectAllByPage(int currpage , int row);

	/**
	 * 根据名字做模糊查询，带分页
	 * @param currpage 当前页数
	 * @param row     每页的条数
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public PageInfo<ZhuanFangExtend> fuzzyQueryByPage(String name, int currpage, int row) throws Exception;

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
