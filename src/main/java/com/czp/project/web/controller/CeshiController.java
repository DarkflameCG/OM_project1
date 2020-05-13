package com.czp.project.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CeshiController {
	   @RequestMapping("/index")
       public String index() {
     	  return "index";
       }
	   @RequestMapping("/login")
       public String login() {
     	  return "login1";
       }
          @RequestMapping("/login_user")
       public String login_user() {
     	  return "login_user";
       }
}
