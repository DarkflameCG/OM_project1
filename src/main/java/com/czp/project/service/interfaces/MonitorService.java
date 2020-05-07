package com.czp.project.service.interfaces;

import com.czp.project.common.bean.Monitor;
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
}
