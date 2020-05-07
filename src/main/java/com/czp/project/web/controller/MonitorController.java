package com.czp.project.web.controller;

import com.czp.project.common.bean.Monitor;
import com.czp.project.common.bean.OmWaichu;
import com.czp.project.common.bean.extend.MonitorExtend;
import com.czp.project.common.bean.extend.WaichuExtend;
import com.czp.project.service.impl.MonitorImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description: 体检记录接口
 * @Author: GX Cui
 * @Date 10:10 下午 2020/5/6
 * @Param
 * @Return
 */
@Controller
@RequestMapping("/exam")
public class MonitorController {

    @Autowired
    private MonitorImpl monitorImpl;

    @RequestMapping("/get/{page}")
    public String queryAllMonitorMsg(HttpServletRequest request,
                                   HttpSession session,
                                   @PathVariable String page) {
        String source = request.getParameter("source");
        PageInfo<MonitorExtend> monitorPages = null;
        if(source == null || source.equals("")) {
            monitorPages = monitorImpl.selectAllByPage(Integer.parseInt(page), 5);

        }else {
            //模糊查询
            //oldzfPages = omzfImpl.fuzzyQueryByPage(source, Integer.parseInt(page), 10);
        }
        session.setAttribute("monitorPages", monitorPages);
        return "pages/exam";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addGoOutMsg(Monitor monitor) {
//		//先根据编号信息查询老人信息
//		OldMan oldman = oldmanimpl.getOldmanByNumb(oldNumb);
//		//记录添加进去
//		zf.setOldmanId(oldman.getId());
//		zf.setTime(new Date());
        monitorImpl.addExam(monitor);
        return "ok";
    }

    //删除逻辑
    @RequestMapping("/remove")
    @ResponseBody
    public String removeGoOutMsg(@RequestParam String id) {
        System.out.println(id);
        if(id.contains(",")) {
            //批量删除
            monitorImpl.removeExamByIds(id);
        }else {
            //根据id删除
            monitorImpl.removeExamById(Integer.parseInt(id));
        }
        return "ok";
    }

    //编辑
    @RequestMapping("/edit")
    @ResponseBody
    public String editGoOutMsg(Monitor monitor) {

        monitorImpl.updateExam(monitor);
        return "ok";
    }
}
