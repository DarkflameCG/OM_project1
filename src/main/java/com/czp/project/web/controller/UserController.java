package com.czp.project.web.controller;

import java.io.File;
import java.util.List;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.czp.project.common.bean.BasePower;
import com.czp.project.common.bean.BaseUser;
import com.czp.project.service.interfaces.BasePowerService;
import com.czp.project.service.interfaces.BaseUserService;
import com.czp.project.utils.PageUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private BasePowerService basePowerService;
	@Autowired
	private BaseUserService baseUserService;
	//获取角色和员工信息
	@RequestMapping("/selectPower")
    public String selectPower(@RequestParam(value="currpage") int currpage,Model model,HttpSession session) {
		try {
			//获取角色
			session.setAttribute("currpage", currpage);
			//List<BasePower> list = basePowerService.selectAll();
			//model.addAttribute("powers", list);
			//标识点击了员工信息
			session.setAttribute("index", 1);
			session.removeAttribute("select");
			//分页员工信息
			PageUtil<BaseUser> pu = baseUserService.findAll(currpage, 3);
			List<BaseUser> services = pu.getData();
			session.setAttribute("pu", pu);
			session.setAttribute("users", services);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	  return "pages/waiters";
    }
		@RequestMapping("/pages")
	    public String pages(@RequestParam(value="currpage") int currpage,Model model,HttpSession session) {
			System.out.println(currpage);
			session.setAttribute("currpage", currpage);
			session.removeAttribute("select");
			 return "redirect:/index";
	    }
	   @RequestMapping("/addUser")
       public String addUser(HttpServletRequest req,HttpSession session,BaseUser baseUser,@RequestParam("avator") MultipartFile file,Integer roleId) {
		   BasePower role=new BasePower();
		   role.setId(roleId);
		   baseUser.setRole(role);
		   if(file!=null){
				String filename = file.getOriginalFilename();
				System.out.println("获取到的文件:"+file.getOriginalFilename());
				//找到一个路径存放文件
				//String realPath = "I:\\briup1606\\workspace04\\runssm\\WebContent\\file";
				String realPath = 
						req.getServletContext().getRealPath("/file");
				System.out.println(realPath);
				//创建一个文件，并将上传文件资料传入
				File dest = new File(realPath, filename);
				try {
					file.transferTo(dest);
					baseUser.setUserImg("file/"+filename);
					baseUserService.addUser(baseUser);
					session.removeAttribute("select");
				} catch (Exception e) {
					e.printStackTrace();
					session.setAttribute("msg", "添加失败");
					//return "/WEB-INF/member/createSpace.jsp";
				}
				//标识点击了员工信息
				session.setAttribute("index", 1);
			}
     	  return "redirect:/index";
       }
	   //删除用户
	   @RequestMapping("/deleteUser")
       public String deleteUser(Integer id,HttpSession session) {
		   
					try {
						baseUserService.deleteUser(id);
						session.removeAttribute("select");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			
     	  return "redirect:/index";
       }
	   //批量删除
	   @RequestMapping("/deleteAllUser")
	   @ResponseBody
       public String deleteAllUser(String ids,Model model,HttpSession session) {
		   try {
			   System.out.println("ids:"+ids);
			String[] d=ids.split(",");//把数组里的值逗号隔开
			   baseUserService.deleteMany(d);
			   session.removeAttribute("select");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		   return "ok";//返回给ajax
					
       }
	   //根据名字查询
	   @RequestMapping("/selectName")
       public String selectName(String name,HttpSession session) {
		   
					try {
						session.setAttribute("index", 1);
						//标识是查询
						session.setAttribute("select", 1);
						List<BaseUser> list = baseUserService.selectByName(name);
						session.setAttribute("users", list);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			
     	  return "redirect:/index";
       }
	   //回到首页并且显示查询结果
	   @RequestMapping("/selectindex")
	    public String selectindex() {
			
	  	  return "pages/waiters";
	    }
	   //登录验证
	   @RequestMapping("/login")
	    public String login(String username,String password,int roleId,HttpSession session,Model model) {
		   BaseUser baseUser=new BaseUser();
		   baseUser.setUserName(username);
		   baseUser.setPassword(password);
		   BasePower p=new BasePower();
		   p.setId(roleId);
		   baseUser.setRole(p);
			try {
				BaseUser login = baseUserService.selectLogin(baseUser);
				if (login==null) {
					// TODO Auto-generated catch block
					model.addAttribute("msg", "登陆失败");
					return "login";
				}
				session.setAttribute("login", login);
				return "index";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				model.addAttribute("msg", "登陆失败");
				return "login";
			}
	    }
}
