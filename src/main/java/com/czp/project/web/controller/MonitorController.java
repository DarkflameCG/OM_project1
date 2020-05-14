package com.czp.project.web.controller;

import com.czp.project.common.bean.Monitor;
import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.OmWaichu;
import com.czp.project.common.bean.extend.MedicalExtend;
import com.czp.project.common.bean.extend.MonitorExtend;
import com.czp.project.common.bean.extend.OldManExtend;
import com.czp.project.common.bean.extend.WaichuExtend;
import com.czp.project.service.impl.MonitorImpl;
import com.czp.project.service.impl.OldManMsgImpl;
import com.github.pagehelper.PageInfo;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private OldManMsgImpl oldmanimpl;


    @RequestMapping("/get/{page}")
    public String queryAllMonitorMsg(HttpServletRequest request,
                                   HttpSession session,
                                   @PathVariable String page) {
        PageInfo<MonitorExtend> monitorPages = monitorImpl.selectAllByPage(Integer.parseInt(page), 5);
        session.setAttribute("monitorPages", monitorPages);
        return "pages/exam";
    }

    //分页模糊查询
    @RequestMapping("/getBySource/{page}")
    public String getAllGoOutMsgByString(HttpSession session,
                                         HttpServletRequest request,
                                         @PathVariable String page) throws Exception {
        String source = request.getParameter("source");
        PageInfo<MonitorExtend> monitorPages = monitorImpl.fuzzyQueryByPage(source, Integer.parseInt(page), 20);
        session.setAttribute("monitorPages", monitorPages);

        return "pages/exam";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addGoOutMsg(Monitor monitor,
                              @RequestParam String oldNumb,
                              @RequestParam String time_1) {
		//先根据编号信息查询老人信息
		OldMan oldman = oldmanimpl.getOldmanByNumb(oldNumb);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            monitor.setExamTime(simpleDateFormat.parse(time_1));
        } catch (ParseException e) {
            return "日期格式转换失败";
        }
		//记录添加进去
        monitor.setOldManId(oldman.getId());
        monitor.setTime(new Date());
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
    //下载word版本的体检记录
    @RequestMapping("/download/{oldId}")
    public void downLoadWord(HttpServletResponse response,
                             @PathVariable String oldId){

        //根据老人id查出老人信息
        OldManExtend ome = oldmanimpl.selectDetailById(oldId);
        //根据老人id查出对应的体检记录
        List<Monitor> monitors = monitorImpl.selectAllByOldManId(oldId);

        //Blank Document
        XWPFDocument document= new XWPFDocument();
        OutputStream out = null;

        //添加标题
        XWPFParagraph titleParagraph = document.createParagraph();
        //设置段落居中
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun titleParagraphRun = titleParagraph.createRun();
        titleParagraphRun.setText("体检记录表");
        titleParagraphRun.setColor("000000");
        titleParagraphRun.setFontSize(20);


        //段落
        XWPFParagraph firstParagraph = document.createParagraph();
        XWPFRun run = firstParagraph.createRun();
        run.setText("请查收您的体检报告。");
        run.setColor("696969");
        run.setFontSize(16);

        //设置段落背景颜色
        CTShd cTShd = run.getCTR().addNewRPr().addNewShd();
        cTShd.setVal(STShd.CLEAR);
        cTShd.setFill("97FFFF");


        //换行
        XWPFParagraph paragraph1 = document.createParagraph();
        XWPFRun paragraphRun1 = paragraph1.createRun();
        paragraphRun1.setText("\r");


        //基本信息表格
        XWPFTable infoTable = document.createTable();
        //去表格边框
        infoTable.getCTTbl().getTblPr().unsetTblBorders();


        //列宽自动分割
        CTTblWidth infoTableWidth = infoTable.getCTTbl().addNewTblPr().addNewTblW();
        infoTableWidth.setType(STTblWidth.DXA);
        infoTableWidth.setW(BigInteger.valueOf(9072));


        //表格第一行
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        infoTableRowOne.getCell(0).setText("编号：");
        infoTableRowOne.addNewTableCell().setText(ome.getOldNumber());

        //表格第二行
        XWPFTableRow infoTableRowTwo = infoTable.createRow();
        infoTableRowTwo.getCell(0).setText("姓名：");
        infoTableRowTwo.getCell(1).setText(ome.getOldmanName());

        //表格第三行
        XWPFTableRow infoTableRowThree = infoTable.createRow();
        infoTableRowThree.getCell(0).setText("性别：");
        infoTableRowThree.getCell(1).setText(ome.getGender());

        //表格第四行
        XWPFTableRow infoTableRowFour = infoTable.createRow();
        infoTableRowFour.getCell(0).setText("健康状况");
        infoTableRowFour.getCell(1).setText(ome.getHealth());

        //表格第五行
        XWPFTableRow infoTableRowFive = infoTable.createRow();
        infoTableRowFive.getCell(0).setText("房间号");
        infoTableRowFive.getCell(1).setText(ome.getRoom().getRoomNumb());


        //两个表格之间加个换行
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun paragraphRun = paragraph.createRun();
        paragraphRun.setText("\r");



        //工作经历表格
        XWPFTable ComTable = document.createTable();


        //列宽自动分割
        CTTblWidth comTableWidth = ComTable.getCTTbl().addNewTblPr().addNewTblW();
        comTableWidth.setType(STTblWidth.DXA);
        comTableWidth.setW(BigInteger.valueOf(9072));

        //表格第一行
        XWPFTableRow comTableRowOne = ComTable.getRow(0);
        comTableRowOne.getCell(0).setText("项目");
        comTableRowOne.addNewTableCell().setText("体检时间");


        for (Monitor m: monitors) {
            XWPFTableRow comTableRowTwo = ComTable.createRow();
            comTableRowTwo.getCell(0).setText(m.getLevel());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            comTableRowTwo.getCell(1).setText(simpleDateFormat.format(m.getExamTime()));

        }

        CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(document, sectPr);

        //添加页眉
        CTP ctpHeader = CTP.Factory.newInstance();
        CTR ctrHeader = ctpHeader.addNewR();
        CTText ctHeader = ctrHeader.addNewT();
        String headerText = "Java POI create MS word file.";
        ctHeader.setStringValue(headerText);
        XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, document);
        //设置为右对齐
        headerParagraph.setAlignment(ParagraphAlignment.RIGHT);
        XWPFParagraph[] parsHeader = new XWPFParagraph[1];
        parsHeader[0] = headerParagraph;
        policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);


        //添加页脚
        CTP ctpFooter = CTP.Factory.newInstance();
        CTR ctrFooter = ctpFooter.addNewR();
        CTText ctFooter = ctrFooter.addNewT();
        String footerText = "http://blog.csdn.net/zhouseawater";
        ctFooter.setStringValue(footerText);
        XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooter, document);
        headerParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFParagraph[] parsFooter = new XWPFParagraph[1];
        parsFooter[0] = footerParagraph;
        policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);


        try {
            String wordName = "体检记录表";
            String fileName = ome.getOldmanName()+"-"+wordName + System.currentTimeMillis() + ".docx";
            fileName = new String(fileName.getBytes("UTF-8"),"iso8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentType("application/ms-word");
            response.setContentType("application/x-download");
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
            response.flushBuffer();
            out = response.getOutputStream();
            document.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
