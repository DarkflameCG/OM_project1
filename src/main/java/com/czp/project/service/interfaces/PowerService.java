package com.czp.project.service.interfaces;

import java.util.List;

import com.czp.project.common.bean.BasePower;
import com.czp.project.common.bean.BaseUser;
import com.czp.project.common.bean.Charges;
import com.github.pagehelper.PageInfo;

public interface PowerService {
	/**
	 * 查询全部角色（带分页）
	 * @param currpage
	 * @param row
	 * @return
	 */
	public PageInfo<BasePower> findAllForPage(int currpage , int row);
	/**
	 * 查询全部角色（不带分页）
	 * @param currpage
	 * @param row
	 * @return
	 */
	public List<BasePower> findAllPower();
	/**
	 * 根据id删除角色
	 * @param id
	 */
	public void removePowerById(int id);
	/**
	 * 批量删除角色
	 * @param ids
	 */
	public void removePowerByIds(String[] ids);
	/**
	 * 添加角色
	 * @param index
	 */
	public void addPower(BasePower basePower);
	/**
	 * 更新角色
	 * @param index
	 */
	public int updatePower(BasePower basePower) throws Exception;
	/**
	 * 搜索查询
	 * @param name
	 */
	public PageInfo<BasePower> findAllByName(int currpage, int row,String source);
}
