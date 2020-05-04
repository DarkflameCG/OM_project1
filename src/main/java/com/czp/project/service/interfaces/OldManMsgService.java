package com.czp.project.service.interfaces;

import java.util.List;

import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.extend.OldManExtend;
import com.github.pagehelper.PageInfo;

/**
 * 老人信息的CRUD接口
 * @author mastercgx
 *
 */
public interface OldManMsgService {
	
	/**
	 * 查询全部老人信息
	 * @return
	 */
	public List<OldManExtend> selectAll(); 
	/**
	 * 分页查询老人信息
	 * @param curPage 当前页数
	 * @param row     每页的条数
	 * @return
	 * @throws Exception
	 */
	public PageInfo<OldManExtend> selectMsgByPage(int currpage,int row) throws Exception; //分页查询
	/**
	 * 根据名字做模糊查询
	 * @param name
	 * @return
	 */
	public List<OldMan> selectMsgByString(String name); 
	
	/**
	 * 根据名字做模糊查询，带分页
	 * @param curPage 当前页数
	 * @param row     每页的条数
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public PageInfo<OldMan> fuzzyQueryByPage(String name,int currpage,int row) throws Exception;
	/**
	 * 添加老人信息
	 * @param newmsg
	 */
	public void addOldManMsg(OldMan newmsg); 
	/**
	 * 根据id删除一条老人信息
	 * @param id
	 */
	public void removeOldManMsg(int id); 
	/**
	 * 批量删除老人信息
	 * @param ids
	 */
	public void removeOldByids(String ids);
	/**
	 * 修改老人信息
	 * @param newmsg
	 */
	public void updateOldManMsg(OldMan newmsg);
	
	/**
	 * 根据老人编号（唯一）查询老人信息
	 * @param numb
	 * @return
	 */
	public OldMan getOldmanByNumb(String numb);
	
	
	
}
