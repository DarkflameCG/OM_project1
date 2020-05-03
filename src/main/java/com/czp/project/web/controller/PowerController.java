package com.czp.project.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.project.common.bean.BasePower;
import com.czp.project.service.interfaces.PowerService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/powers")
public class PowerController {
	@Autowired
	private PowerService powerService;
	@RequestMapping("/power/{page}")
	public String getIndex(HttpSession session,
							  @PathVariable String page) throws NumberFormatException, Exception {
	   
	 //分页权限信息
	 PageInfo<BasePower> info = powerService.findAllForPage(Integer.parseInt(page), 6);
	  session.setAttribute("powerss", info); 
	 
		return "pages/roles";
	}
	//批量或单个删除
	   @RequestMapping("/deletePower")
	   @ResponseBody
  public String deletePower(@RequestParam String id) {
		  
		   try {
			   String[] d=null;
			   if(id.contains(",")) {
				  
					//批量删除
				   d=id.split(",");//把数组里的值逗号隔开
				   powerService.removePowerByIds(d);
				}else {		
					powerService.removePowerById(Integer.parseInt(id));
				}
				   return "ok";
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ok";
		}
  }
	   //添加角色
	   @RequestMapping("/addPower")
	   @ResponseBody
       public String addPower(HttpServletRequest req,HttpSession session,BasePower basePower) {
		   try {
			powerService.addPower(basePower);
			 return "ok";
		} catch (Exception e) {
			return "error";
		}
		  
	   }
	 //更新角色
	   @RequestMapping("/updatePower")
	   @ResponseBody
       public String updatePower(HttpServletRequest req,HttpSession session,BasePower basePower) {
		   try {
			   powerService.updatePower(basePower);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
     	  return "ok";
       } 
	   //搜索
	   @RequestMapping("/search/{page}")
		public String search(HttpSession session,String source,@PathVariable String page) throws NumberFormatException, Exception {
		   //分页搜索信息
		   PageInfo<BasePower> info =powerService.findAllByName(Integer.parseInt(page), 6, source);
		   session.setAttribute("powerss", info); 
		   return "pages/roles";
		}
}
