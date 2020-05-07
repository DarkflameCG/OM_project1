package com.czp.project.service.impl;

import com.czp.project.common.bean.Medical;
import com.czp.project.common.bean.extend.MedicalExtend;
import com.czp.project.dao.MedicalMapper;
import com.czp.project.dao.extend.MedicalExtendMapper;
import com.czp.project.service.interfaces.MedicalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalImpl implements MedicalService {
    @Autowired
    private MedicalMapper medicalMapper;
    @Autowired
    private MedicalExtendMapper medicalExtendMapper;

    @Override
    public List<MedicalExtend> selectAll() {
        return medicalExtendMapper.selectAll();
    }

    @Override
    public PageInfo<MedicalExtend> selectAllByPage(int currpage, int row) {
        PageHelper.startPage(currpage,row);
        return new PageInfo<MedicalExtend>(this.selectAll());
    }

    @Override
    public void addMedical(Medical medical) {
        medicalMapper.insert(medical);
    }

    @Override
    public void removeMedicalById(int id) {
        medicalMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void removeMedicalByIds(String ids) {
        String[] value = ids.split(",");
        for (int i = 0; i < value.length; i++) {
            this.removeMedicalById(Integer.parseInt(value[i]));
        }
    }

    @Override
    public void updateMedical(Medical newmsg) {
        medicalMapper.updateByPrimaryKeySelective(newmsg);
    }
}
