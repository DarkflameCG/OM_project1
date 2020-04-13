package com.czp.project.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czp.project.common.bean.OldMan;
import com.czp.project.service.impl.OldManMsgImpl;

@Controller
@RequestMapping("/oldmsg")
public class OldManMsgController {
	
	@Autowired
	private OldManMsgImpl oldimpl;
	
	
	@RequestMapping("/getmsg")
	public String getOldManMsg(HttpSession session) {
		List<OldMan> oldlist = oldimpl.selectAll();
		session.setAttribute("oldlist", oldlist);
		
		return "pages/oldManInfo";
	}
	
	@RequestMapping("/getMsgBySource")
	public String getOldManMsgByString(HttpSession session,
									   HttpServletRequest request) {
		String source = request.getParameter("");
		List<OldMan> oldlist = oldimpl.selectMsgByString(source);
		session.setAttribute("oldlist", oldlist);
		
		return "pages/oldManInfo";
	}
}
