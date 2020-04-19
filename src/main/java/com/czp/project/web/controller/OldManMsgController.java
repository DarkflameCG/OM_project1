package com.czp.project.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.project.common.bean.OldMan;
import com.czp.project.service.impl.OldManMsgImpl;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/oldmsg")
public class OldManMsgController {
	
	@Autowired
	private OldManMsgImpl oldimpl;
	
	
	@RequestMapping("/getmsg/{page}")
	public String getOldManMsg(HttpSession session,
							  @PathVariable String page) throws NumberFormatException, Exception {
//		List<OldMan> oldlist = oldimpl.selectAll(); //查询全部
		
		PageInfo<OldMan> oldPages = oldimpl.selectMsgByPage(Integer.parseInt(page), 5);
		session.setAttribute("oldPages", oldPages);
		System.out.println(oldPages);
		
		return "pages/oldManInfo";
	}
	
	@RequestMapping("/getMsgBySource")
	public String getOldManMsgByString(HttpSession session,
									   HttpServletRequest request) {
		String source = request.getParameter("source");
		List<OldMan> oldlist = oldimpl.selectMsgByString(source);
		session.setAttribute("oldlist", oldlist);
		
		return "pages/oldManInfo";
	}
	
	@RequestMapping("/addOldmanMsg")
	@ResponseBody
	public String addOldManMsg(OldMan oldman) {
		oldimpl.addOldManMsg(oldman);
		return "ok";
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String editOldManMsg(OldMan oldman) {
		
		System.out.println(oldman);
		oldimpl.updateOldManMsg(oldman);
		return "ok";
	}
	
	@RequestMapping("/remove")
	@ResponseBody
	public String removeOldManMsg(@RequestParam String id) {
		System.out.println(id);
		oldimpl.removeOldManMsg(Integer.parseInt(id));
		return "ok";
	}
	
	
}
