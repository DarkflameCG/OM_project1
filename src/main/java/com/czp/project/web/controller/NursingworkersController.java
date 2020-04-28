package com.czp.project.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czp.project.common.bean.BaseUser;
import com.czp.project.service.interfaces.NursWorkService;
import com.github.pagehelper.PageInfo;

//护工管理
@Controller
@RequestMapping("/nursworker")
public class NursingworkersController {
	@Autowired
	private NursWorkService nursWorkServiceImpl;
	//获取角色和员工信息
		@RequestMapping("/selectnursworker/{page}")
	    public String selectPower(HttpSession session,
				  @PathVariable String page) {
			//分页员工信息
			  try {
				PageInfo<BaseUser> info =
						  nursWorkServiceImpl.selectByExample(Integer.parseInt(page), 6);
				  session.setAttribute("users", info);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	  	  return "pages/waiters";
	    }
		
}
