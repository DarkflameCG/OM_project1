package com.czp.project.web.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.czp.project.common.bean.OldMan;
import com.czp.project.service.impl.OldManMsgImpl;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/oldmsg")
public class OldManMsgController {
	
	@Autowired
	private OldManMsgImpl oldimpl;
	
	//分页查询全部
	@RequestMapping("/getmsg/{page}")
	public String getOldManMsg(HttpSession session,
							  @PathVariable String page) throws NumberFormatException, Exception {
//		List<OldMan> oldlist = oldimpl.selectAll(); //查询全部
		PageInfo<OldMan> oldPages = oldimpl.selectMsgByPage(Integer.parseInt(page), 5);
		session.setAttribute("oldPages", oldPages);
		return "pages/oldManInfo";
	}
	//分页模糊查询
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
	public String addOldManMsg(HttpServletRequest req,
							   HttpSession session,
							   OldMan oldman,
							   @RequestParam("photo") MultipartFile file) {
		System.out.println("aaaa");
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
				oldman.setOldmanImg("file/"+filename);
				oldimpl.addOldManMsg(oldman);
				session.setAttribute("msg", "添加成功");
			} catch (Exception e) {
				e.printStackTrace();
				session.setAttribute("msg", "添加失败");
			}
		}
		
		return "ok";
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String editOldManMsg(OldMan oldman) {
		
		oldimpl.updateOldManMsg(oldman);
		return "ok";
	}
	
	@RequestMapping("/remove")
	@ResponseBody
	public String removeOldManMsg(@RequestParam String id) {
		System.out.println(id);
		if(id.contains(",")) {
			//批量删除
			oldimpl.removeOldByids(id);
		}else {			
			//根据id删除
			oldimpl.removeOldManMsg(Integer.parseInt(id));
		}
		return "ok";
	}
	
	
}
