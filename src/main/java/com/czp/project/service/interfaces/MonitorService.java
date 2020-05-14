package com.czp.project.service.interfaces;

import com.czp.project.common.bean.Monitor;
import com.czp.project.common.bean.OmWaichu;
import com.czp.project.common.bean.extend.MedicalExtend;
import com.czp.project.common.bean.extend.MonitorExtend;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Description: 体检记录业务接口
 * @Author: GX Cui
 * @Date 10:19 下午 2020/5/6
 * @Param
 * @Return
 */
public interface MonitorService {
    /**
     * 及联查询全部，不带分页
     * @return
     */
    public List<MonitorExtend> selectAll();

    /**
     * 及联查询全部，带分页
     * @param currpage
     * @param row
     * @return
     */
    public PageInfo<MonitorExtend> selectAllByPage(int currpage , int row);

    /**
     * 根据名字做模糊查询，带分页
     * @param currpage 当前页数
     * @param row     每页的条数
     * @param name
     * @return
     * @throws Exception
     */
    public PageInfo<MonitorExtend> fuzzyQueryByPage(String name, int currpage, int row) throws Exception;

    /**
     * 添加体检记录
     * @param monitor
     */
    public void addExam(Monitor monitor);

    /**
     * 根据id删除一条体检记录
     * @param id
     */
    public void removeExamById(int id);
    /**
     * 批量删除体检记录
     * @param ids
     */
    public void removeExamByIds(String ids);
    /**
     * 修改体检记录
     * @param newmsg
     */
    public void updateExam(Monitor newmsg);

    /**
     * 根据老人id查询所有的体检记录
     * @param id
     * @return
     */
    public List<Monitor> selectAllByOldManId(String id);



}
