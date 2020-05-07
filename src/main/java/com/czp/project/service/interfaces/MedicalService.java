package com.czp.project.service.interfaces;

import com.czp.project.common.bean.Medical;
import com.czp.project.common.bean.extend.MedicalExtend;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Description: 外出就医业务接口
 * @Author: GX Cui
 * @Date 10:18 下午 2020/5/6
 * @Param
 * @Return
 */
public interface MedicalService {


    /**
     * 及联查询全部，不带分页
     * @return
     */
    public List<MedicalExtend> selectAll();

    /**
     * 及联查询全部，带分页
     * @param currpage
     * @param row
     * @return
     */
    public PageInfo<MedicalExtend> selectAllByPage(int currpage , int row);

    /**
     * 添加外出就医记录
     * @param medical
     */
    public void addMedical(Medical medical);

    /**
     * 根据id删除一条外出就医记录
     * @param id
     */
    public void removeMedicalById(int id);
    /**
     * 批量删除外出就医记录
     * @param ids
     */
    public void removeMedicalByIds(String ids);
    /**
     * 修改外出就医记录
     * @param newmsg
     */
    public void updateMedical(Medical newmsg);
}
