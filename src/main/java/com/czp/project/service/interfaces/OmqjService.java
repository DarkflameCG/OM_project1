package com.czp.project.service.interfaces;

import java.util.List;

import com.czp.project.common.bean.OmQingjia;
import com.czp.project.common.bean.extend.QingjiaExtend;
import com.czp.project.common.bean.extend.WaichuExtend;
import com.github.pagehelper.PageInfo;

/**
 * 老人请假业务接口
 * @author mastercgx
 *
 */
public interface OmqjService {
	/**
	 * 及联查询全部，不带分页
	 * @return
	 */
	public List<QingjiaExtend> selectAll();
	
	/**
	 * 及联查询全部，带分页
	 * @param currpage
	 * @param row
	 * @return
	 */
	public PageInfo<QingjiaExtend> selectAllByPage(int currpage , int row);
	/**
	 * 根据名字做模糊查询，带分页
	 * @param currpage 当前页数
	 * @param row     每页的条数
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public PageInfo<QingjiaExtend> fuzzyQueryByPage(String name, int currpage, int row) throws Exception;

	/**
	 * 添加请假记录
	 * @param qj
	 */
	public void addQj(OmQingjia qj);

	/**
	 * 根据id删除一条外出记录
	 * @param id
	 */
	public void removeQjById(int id); 
	/**
	 * 批量删除外出记录
	 * @param ids
	 */
	public void removeQjByids(String ids);
	/**
	 * 修改外出记录
	 * @param newmsg
	 */
	public void updateQj(OmQingjia newmsg);
	
}
