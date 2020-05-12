package com.czp.project.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.czp.project.service.impl.OldManMsgImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.OmWaichu;
import com.czp.project.common.bean.OmZhuanfang;
import com.czp.project.common.bean.Room;
import com.czp.project.common.bean.extend.WaichuExtend;
import com.czp.project.common.bean.extend.ZhuanFangExtend;
import com.czp.project.service.impl.OmwcImpl;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/wc")
public class OmwcController {
	
	@Autowired
	private OmwcImpl omwcImpl;
	@Autowired
	private OldManMsgImpl oldmanimpl;
	
	@RequestMapping("/get/{page}")
	public String queryAllGoOutMsg(HttpServletRequest request,
			   					   HttpSession session,
			   					   @PathVariable String page) {
		PageInfo<WaichuExtend> oldwcPages = omwcImpl.selectAllByPage(Integer.parseInt(page), 5);
			

		session.setAttribute("oldwcPages", oldwcPages);
		return "pages/oldmanWaichu";
	}

	//分页模糊查询
	@RequestMapping("/getByName/{page}")
	public String getTransferLogByString(HttpSession session,
										 HttpServletRequest request,
										 @PathVariable String page) throws Exception {
		String source = request.getParameter("source");
		PageInfo<WaichuExtend> info = omwcImpl.fuzzyQueryByPage(source, Integer.parseInt(page), 20);

		session.setAttribute("oldwcPages", info);

		return "pages/oldmanWaichu";
	}

	
	@RequestMapping("/add")
	@ResponseBody
	public String addGoOutMsg(OmWaichu wc,
							  @RequestParam String oldNumb,
							  @RequestParam String time1,
							  @RequestParam String time2) {
		//先根据编号信息查询老人信息
		OldMan oldman = oldmanimpl.getOldmanByNumb(oldNumb);
		//记录添加进去
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			wc.setStatTime(simpleDateFormat.parse(time1));
			wc.setEndTime(simpleDateFormat.parse(time2));
		} catch (ParseException e) {
			return "日期格式转换失败";
		}
		wc.setOldManId(oldman.getId());
		wc.setStatus("未归");
		omwcImpl.addWc(wc);
		return "ok";
	}
	
	//删除逻辑
	@RequestMapping("/remove")
	@ResponseBody
	public String removeGoOutMsg(@RequestParam String id) {
		System.out.println(id);
		if(id.contains(",")) {
			//批量删除
			omwcImpl.removeWcByids(id);
		}else {			
			//根据id删除
			omwcImpl.removeWcById(Integer.parseInt(id));
		}
		return "ok";
	}
	
	//编辑
	@RequestMapping("/edit")
	@ResponseBody
	public String editGoOutMsg(OmWaichu newmsg,
							   @RequestParam String time1,
							   @RequestParam String time2) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			newmsg.setStatTime(simpleDateFormat.parse(time1));
			newmsg.setEndTime(simpleDateFormat.parse(time2));
		} catch (ParseException e) {
			return "日期格式转换失败";
		}

		omwcImpl.updateWc(newmsg);
		return "ok";
	}

	//确认已归
	@RequestMapping("/check/{wcid}")
	public String checkHasReturn(@PathVariable String wcid) {
		//根据wcid查出对应的外出记录
		OmWaichu wc = omwcImpl.selectWcById(wcid);
		wc.setStatus("已归");
		omwcImpl.updateWc(wc);
		return "pages/oldmanWaichu";
	}
	
}
