package com.czp.project.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.project.common.bean.BasePower;
import com.czp.project.common.bean.BaseUser;
import com.czp.project.common.bean.UserLeave;
import com.czp.project.common.bean.extend.UserLeaveEX;
import com.czp.project.service.interfaces.BaseUserService;
import com.czp.project.service.interfaces.NursWorkService;
import com.czp.project.service.interfaces.UserLeaveService;
import com.czp.project.utils.DateAndStringUtil;
import com.github.pagehelper.PageInfo;

//护工管理
@Controller
@RequestMapping("/nursworker")
public class NursingworkersController {
	@Autowired
	private NursWorkService nursWorkServiceImpl;
	@Autowired
	private BaseUserService baseUserService;
	@Autowired
	private UserLeaveService userLeaveServiceImpl;
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
		 //添加护工
		   @RequestMapping("/addHuGong")
		   @ResponseBody
	       public String addHuGong(HttpServletRequest req,HttpSession session,BaseUser baseUser) {
			   BasePower role=new BasePower();
			   role.setId(2);
			   baseUser.setRole(role);
			   baseUser.setWorkTime(DateAndStringUtil.getFisrtDayOfMonth(new Date()));
			   baseUserService.addUser(baseUser);
			   return "ok";
		   }
		 //更新护工
		   @RequestMapping("/updateHuGong")
		   @ResponseBody
	       public String updateUser1(HttpServletRequest req,HttpSession session,BaseUser baseUser) {
			   try {
				   System.out.println(baseUser);
				baseUserService.updateUser2(baseUser);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
	     	  return "ok";
	       } 
		 //搜索护工
		   @RequestMapping("/search/{page}")
			public String search(HttpSession session,String source,@PathVariable String page) throws NumberFormatException, Exception {
			   //分页搜索信息
			   PageInfo<BaseUser> info =nursWorkServiceImpl.findAllByName(Integer.parseInt(page), 6, source);
			   session.setAttribute("users", info); 
			   return "pages/waiters";
			}
		 //获取员工考勤
			@RequestMapping("/attendance/{page}")
		    public String selectAttendance(HttpSession session,
					  @PathVariable String page) {
				//分页员工信息
				  try {
					PageInfo<UserLeaveEX> info =
							userLeaveServiceImpl.findAllUserLeaveEX(Integer.parseInt(page), 6);
					  session.setAttribute("userLeaves", info);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		  	  return "pages/attendance";
		    }
			//批量或单个删除
			   @RequestMapping("/removeAttendance")
			   @ResponseBody
		  public String removeAttendance(@RequestParam String id) {
				  
				   try {
					   String[] d=null;
					   if(id.contains(",")) {
						  
							//批量删除
						   d=id.split(",");//把数组里的值逗号隔开
						   userLeaveServiceImpl.removeAttendByIdByIds(d);
						}else {		
							userLeaveServiceImpl.removeAttendById(Integer.parseInt(id));
						}
						   return "ok";
					  
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "ok";
				}
				  
				  
		  }
			   //添加考勤
			   @RequestMapping("/addAttend")
			   @ResponseBody
		       public String addAttend(HttpServletRequest req,HttpSession session,UserLeave userLeave,String time1,String time2) {
				   try {
					   userLeave.setStartTime(DateAndStringUtil.strToDate(time1));
					   userLeave.setEndTime(DateAndStringUtil.strToDate(time2));
					   userLeave.setUserManager("管理员");
					   userLeave.setTime(new Date());
					   userLeaveServiceImpl.addAttend(userLeave);
					 return "ok";
				} catch (Exception e) {
					return "error";
				}
				  
			   }
			   //更新考勤
			   @RequestMapping("/updateAttend")
			   @ResponseBody
		       public String updateAttend(HttpServletRequest req,HttpSession session,UserLeave userLeave,String time1,String time2) {
				   try {
					   userLeave.setStartTime(DateAndStringUtil.strToDate(time1));
					   userLeave.setEndTime(DateAndStringUtil.strToDate(time2));
					   userLeave.setUserManager("管理员");
					   userLeave.setTime(new Date());
					   userLeaveServiceImpl.updateAttend(userLeave);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
		     	  return "ok";
		       } 
			 //搜索
			   @RequestMapping("/searchAttend/{page}")
				public String searchAttend(HttpSession session,String source,@PathVariable String page) throws NumberFormatException, Exception {
				   //分页搜索信息
				   PageInfo<UserLeaveEX> info =userLeaveServiceImpl.findAllByName(Integer.parseInt(page), 6, source);
				   session.setAttribute("userLeaves", info); 
				   return "pages/attendance";
				}
}
