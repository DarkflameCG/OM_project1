package com.czp.project.service.interfaces;

import java.util.List;

import com.czp.project.common.bean.Charges;
import com.github.pagehelper.PageInfo;

/**
 * 收费设置接口
 * @author mastercgx
 *
 */
public interface IndexService {
	/**
	 * 添加收费项目
	 * @param index
	 */
	public void addIndex(Charges index);
	/**
	 * 根据id删除收费项目
	 * @param id
	 */
	public void removeIndexById(int id);
	/**
	 * 批量删除收费项目
	 * @param ids
	 */
	public void removeIndexByIds(String[] ids);
	/**
	 * 编辑（修改）收费项目
	 * @param index
	 */
	public void eidtIndex(Charges index);
	/**
	 * 查询全部收费项目（不带分页）
	 */
	public List<Charges> findAll();
	/**
	 * 查询全部收费项目（带分页）
	 * @param currpage
	 * @param row
	 * @return
	 */
	public PageInfo<Charges> findAllForPage(int currpage , int row);
	/**
	 * 模糊查询
	 * @param name
	 */
	public void findIndexBySting(String name);
}
