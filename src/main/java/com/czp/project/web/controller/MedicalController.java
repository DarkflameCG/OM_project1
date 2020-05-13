package com.czp.project.web.controller;

import com.czp.project.common.bean.Medical;
import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.OmWaichu;
import com.czp.project.common.bean.extend.MedicalExtend;
import com.czp.project.common.bean.extend.QingjiaExtend;
import com.czp.project.common.bean.extend.WaichuExtend;
import com.czp.project.service.impl.MedicalImpl;
import com.czp.project.service.impl.OldManMsgImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Description: 外出就医接口
 * @Author: GX Cui
 * @Date 10:10 下午 2020/5/6
 * @Param
 * @Return
 */
@Controller
@RequestMapping("/seek")
public class MedicalController {
    @Autowired
    private MedicalImpl medicalImpl;
    @Autowired
    private OldManMsgImpl oldmanimpl;

    @RequestMapping("/get/{page}")
    public String queryAllMedicalMsg(HttpServletRequest request,
                                   HttpSession session,
                                   @PathVariable String page) {
        PageInfo<MedicalExtend> medicalPages = medicalImpl.selectAllByPage(Integer.parseInt(page), 5);
        session.setAttribute("medicalPages", medicalPages);
        return "pages/seek";
    }

    //分页模糊查询
    @RequestMapping("/getBySource/{page}")
    public String getAllGoOutMsgByString(HttpSession session,
                                         HttpServletRequest request,
                                         @PathVariable String page) throws Exception {
        String source = request.getParameter("source");
        PageInfo<MedicalExtend> medicalPages = medicalImpl.fuzzyQueryByPage(source, Integer.parseInt(page), 20);
        session.setAttribute("medicalPages", medicalPages);

        return "pages/seek";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addMedicalMsg(Medical medical,
                                @RequestParam String oldNumb) {
		//先根据编号信息查询老人信息
		OldMan oldman = oldmanimpl.getOldmanByNumb(oldNumb);
		//记录添加进去
        medical.setOldManId(oldman.getId());
        medical.setTime(new Date());
        medicalImpl.addMedical(medical);
        return "ok";
    }

    //删除逻辑
    @RequestMapping("/remove")
    @ResponseBody
    public String removeMedicalMsg(@RequestParam String id) {
        System.out.println(id);
        if(id.contains(",")) {
            //批量删除
            medicalImpl.removeMedicalByIds(id);
        }else {
            //根据id删除
            medicalImpl.removeMedicalById(Integer.parseInt(id));
        }
        return "ok";
    }

    //编辑
    @RequestMapping("/edit")
    @ResponseBody
    public String editMedicalMsg(Medical newmsg) {

        medicalImpl.updateMedical(newmsg);
        return "ok";
    }
}
