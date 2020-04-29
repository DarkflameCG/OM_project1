package com.czp.project.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czp.project.common.bean.extend.OldManRuZhuEX;
import com.czp.project.service.interfaces.OldManRuZhuService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/activity")
public class OldManActivityController {
@Autowired
private OldManRuZhuService oldManRuZhuService;

@RequestMapping("/ruzhu/{page}")
public String getBaseUser(HttpSession session,
						  @PathVariable String page) throws NumberFormatException, Exception {
   
 //分页入住信息
	PageInfo<OldManRuZhuEX> info = oldManRuZhuService.findAllOldManRuZhuEX(Integer.parseInt(page), 2);
  session.setAttribute("ruzhus", info); 
	return "pages/oldManRuzhu";
}
}
