package com.czp.project.service.interfaces;


import com.czp.project.common.bean.OldManRuZhu;
import com.czp.project.common.bean.OmWaichu;
import com.czp.project.common.bean.extend.OldManRuZhuEX;
import com.czp.project.common.bean.extend.WaichuExtend;
import com.github.pagehelper.PageInfo;

public interface OldManRuZhuService {
	/**
	 * 分页及联查询
	 * @param currpage
	 * @param row
	 * @return
	 * @throws Exception
	 */
	PageInfo<OldManRuZhuEX> findAllOldManRuZhuEX(int currpage, int row) throws Exception;;


	/**
	 * 添加外出记录
	 * @param rz
	 */
	public void addRz(OldManRuZhu rz);

	/**
	 * 根据id删除一条转房记录
	 * @param id
	 */
	public void removeRzById(int id);
	/**
	 * 批量删除外出记录
	 * @param ids
	 */
	public void removeRzByids(String ids);
	/**
	 * 修改外出记录
	 * @param newmsg
	 */
	public void updateRz(OldManRuZhu newmsg);

}
