package com.czp.project.service.impl;

import com.czp.project.common.bean.Monitor;
import com.czp.project.common.bean.MonitorExample;
import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.OmWaichuExample;
import com.czp.project.common.bean.extend.MedicalExtend;
import com.czp.project.common.bean.extend.MonitorExtend;
import com.czp.project.dao.MonitorMapper;
import com.czp.project.dao.extend.MonitorExtendMapper;
import com.czp.project.service.interfaces.MonitorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MonitorImpl implements MonitorService {

    @Autowired
    private MonitorMapper monitorMapper;
    @Autowired
    private MonitorExtendMapper monitorExtendMapper;

    @Override
    public List<MonitorExtend> selectAll() {
        return monitorExtendMapper.selectAll();
    }

    @Override
    public PageInfo<MonitorExtend> selectAllByPage(int currpage, int row) {
        PageHelper.startPage(currpage,row);
        return new PageInfo<MonitorExtend>(this.selectAll());
    }

    @Override
    public PageInfo<MonitorExtend> fuzzyQueryByPage(String name, int currpage, int row) throws Exception {
        PageHelper.startPage(currpage,row);
        List<MonitorExtend> tempList = monitorExtendMapper.selectByParameter(name);
        return new PageInfo<MonitorExtend>(tempList);
    }

    @Override
    public void addExam(Monitor monitor) {
        monitorMapper.insert(monitor);
    }

    @Override
    public void removeExamById(int id) {
        monitorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void removeExamByIds(String ids) {
        String[] value = ids.split(",");
        for (int i = 0; i < value.length; i++) {
            this.removeExamById(Integer.parseInt(value[i]));
        }
    }

    @Override
    public void updateExam(Monitor newmsg) {
        monitorMapper.updateByPrimaryKeySelective(newmsg);
    }

    @Override
    public List<Monitor> selectAllByOldManId(String id) {

        MonitorExample example = new MonitorExample();
        example.createCriteria().andOldManIdEqualTo(Integer.parseInt(id));
        return monitorMapper.selectByExample(example);
    }


}
