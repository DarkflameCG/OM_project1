package com.czp.project.web.controller;

import java.io.File;
import java.util.List;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.czp.project.common.bean.BasePower;
import com.czp.project.common.bean.BaseUser;
import com.czp.project.common.bean.OldMan;
import com.czp.project.service.interfaces.BasePowerService;
import com.czp.project.service.interfaces.BaseUserService;
import com.czp.project.utils.PageUtil;
import com.github.pagehelper.PageInfo;

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
	/*
	 * //删除用户
	 * 
	 * @RequestMapping("/deleteUser") public String deleteUser(Integer
	 * id,HttpSession session) {
	 * 
	 * try { baseUserService.deleteUser(id); session.removeAttribute("select"); }
	 * catch (Exception e) { // TODO Auto-generated catch block e.printStackTrace();
	 * }
	 * 
	 * 
	 * return "redirect:/index"; }
	 */
	  
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
	   @ResponseBody
	   @PostMapping("/login")
	    public String login(@RequestBody BaseUser baseUser,HttpSession session) {
			try {
				BaseUser login = baseUserService.selectLogin(baseUser);
				if (login==null) {
					return "login";
				}
				session.setAttribute("login", login);
				return "index";
			} catch (Exception e) {
				return "login";
			}
	    }
	   @RequestMapping("/me")
		public String userSetting(){
			   return "pages/user_setting";
		}
	   @RequestMapping("/updateUser")
       public String addUser(HttpServletRequest req,HttpSession session,BaseUser baseUser,@RequestParam("image") MultipartFile file) {
		  
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
					baseUserService.updateUser(baseUser);
					session.setAttribute("login", baseUser);
				} catch (Exception e) {
					e.printStackTrace();
					session.setAttribute("msg", "添加失败");
				}
				
			}
     	  return "pages/user_setting";
       }
	   @RequestMapping("/user/{page}")
		public String getOldManMsg(HttpSession session,
								  @PathVariable String page) throws NumberFormatException, Exception {
		 //分页员工信息
		   System.out.println("确实能够:"+page);
			PageUtil<BaseUser> pu = baseUserService.findAll(Integer.parseInt(page), 2);
			List<BaseUser> services = pu.getData();
			session.setAttribute("pu", pu);
			session.setAttribute("users", services);
		/*
		 * PageInfo<BaseUser> info =
		 * baseUserService.selectByExample(Integer.parseInt(page), 2);
		 * session.setAttribute("users", info); System.out.println("二次:"+info);
		 */
			return "pages/users_manager";
		}
	   //批量或单个删除
	   @RequestMapping("/deleteUser")
       public String deleteAllUser(@RequestParam String id) {
		  
		   try {
			   String[] d=null;
			   int result =0;
			   if(id.contains(",")) {
					//批量删除
				   d=id.split(",");//把数组里的值逗号隔开
				    result = baseUserService.deleteMany(d); 
				}else {		
					 result = baseUserService.deleteUser(Integer.parseInt(id));
				}
			 
			 
				   return "pages/users_manager";
			
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "redirect:u";
		}
		  //
					
       }
	  
}
