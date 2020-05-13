package com.czp.project.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.czp.project.common.bean.OldMan;
import com.czp.project.service.impl.OldManMsgImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.project.common.bean.OmQingjia;
import com.czp.project.common.bean.OmWaichu;
import com.czp.project.common.bean.extend.QingjiaExtend;
import com.czp.project.common.bean.extend.WaichuExtend;
import com.czp.project.service.impl.OmqjImpl;
import com.czp.project.service.impl.OmwcImpl;
import com.github.pagehelper.PageInfo;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/qj")
public class OmqjController {
	@Autowired
	private OmqjImpl omqjimpl;
	@Autowired
	private OldManMsgImpl oldmanimpl;
	
	@RequestMapping("/get/{page}")
	public String queryAllGoOutMsg(HttpServletRequest request,
			   					   HttpSession session,
			   					   @PathVariable String page) {
		PageInfo<QingjiaExtend> oldqjPages = omqjimpl.selectAllByPage(Integer.parseInt(page), 5);
		session.setAttribute("oldqjPages", oldqjPages);
		return "pages/oldManQingjia";
	}
	//分页模糊查询
	@RequestMapping("/getBySource/{page}")
	public String getAllGoOutMsgByString(HttpSession session,
									   HttpServletRequest request,
									   @PathVariable String page) throws Exception {
		String source = request.getParameter("source");
		PageInfo<QingjiaExtend> oldqjPages = omqjimpl.fuzzyQueryByPage(source, Integer.parseInt(page), 20);
		session.setAttribute("oldqjPages", oldqjPages);

		return "pages/oldManQingjia";
	}


	@RequestMapping("/add")
	@ResponseBody
	public String addLeaveMsg(OmQingjia qj,
							  @RequestParam String oldNumb,
							  @RequestParam String time_1,
							  @RequestParam String time_2) {
		//先根据编号信息查询老人信息
		OldMan oldman = oldmanimpl.getOldmanByNumb(oldNumb);
		//记录添加进去
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			qj.setStartTime(simpleDateFormat.parse(time_1));
			qj.setEndTime(simpleDateFormat.parse(time_2));
		} catch (ParseException e) {
			return "日期格式转换失败";
		}
		qj.setOldmanId(oldman.getId());
		qj.setTime(new Date());
		qj.setState(1);
		omqjimpl.addQj(qj);
		return "ok";
	}
	
	//删除逻辑
	@RequestMapping("/remove")
	@ResponseBody
	public String removeLeaveMsg(@RequestParam String id) {
		System.out.println(id);
		if(id.contains(",")) {
			//批量删除
			omqjimpl.removeQjByids(id);
		}else {			
			//根据id删除
			omqjimpl.removeQjById(Integer.parseInt(id));
		}
		return "ok";
	}
	
	//编辑
	@RequestMapping("/edit")
	@ResponseBody
	public String editLeaveMsg(OmQingjia newmsg,
							   @RequestParam String time_1,
							   @RequestParam String time_2) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			newmsg.setStartTime(simpleDateFormat.parse(time_1));
			newmsg.setEndTime(simpleDateFormat.parse(time_2));
		} catch (ParseException e) {
			return "日期格式转换失败";
		}
		newmsg.setTime(new Date());
		omqjimpl.updateQj(newmsg);
		return "ok";
	}

	//通过和不通过
	@RequestMapping("/{isCheck}/{qjid}")
	public String checkHasReturn(@PathVariable String qjid,
								 @PathVariable String isCheck) {
		//根据qjid查出对应的外出记录
		OmQingjia qj = omqjimpl.selectWcById(qjid);
		if(isCheck.equals("yes")){
			qj.setState(2);
		}else if (isCheck.equals("no")){
			qj.setState(3);
		}
		omqjimpl.updateQj(qj);
		return "pages/oldManQingjia";

	}
}
