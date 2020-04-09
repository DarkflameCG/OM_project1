package com.czp.project.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czp.project.common.bean.BasePower;
import com.czp.project.service.interfaces.BasePowerService;

@Controller
public class CeshiController {
	@Autowired
	private BasePowerService basePowerService;
	   @RequestMapping("/index")
       public String index() {
     	  return "index";
       }
	   @RequestMapping("/login")
       public String login(HttpSession session) {
		   List<BasePower> list = basePowerService.selectAll();
		   session.setAttribute("powers", list);
     	  return "login";
       }
}
