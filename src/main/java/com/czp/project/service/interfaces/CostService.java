package com.czp.project.service.interfaces;

import java.util.List;

import com.czp.project.common.bean.Cost;
import com.github.pagehelper.PageInfo;

/**
 * 缴费记录的接口
 * @author mastercgx
 *
 */
public interface CostService {
	/**
	 * 添加缴费记录
	 * @param cost
	 */
	public void addCost(Cost cost);
	/**
	 * 通过id删除缴费记录
	 * @param id
	 */
	public void removeCostById(int id);
	/**
	 * 批量删除缴费记录
	 * @param ids
	 */
	public void removeCostByIds(String ids);
	/**
	 * 修改缴费记录
	 * @param cost
	 */
	public void editCost(Cost cost);
	/**
	 * 查询全部，不带分页
	 * @return
	 */
	public List<Cost> findAll();
	/**
	 * 查询全部，带分页
	 * @param currpage
	 * @param row
	 * @return
	 */
	public PageInfo<Cost> findAllForPage(int currpage , int row);
}
