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
import com.czp.project.common.bean.extend.OldManExtend;
import com.czp.project.service.impl.OldManMsgImpl;
import com.czp.project.utils.NumberProduct;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/oldmsg")
public class OldManMsgController {
	
	@Autowired
	private OldManMsgImpl oldimpl;
	
	//分页查询全部
	@RequestMapping("/getmsg/{page}")
	public String getOldManMsg(HttpSession session,
							  HttpServletRequest request,
							  @PathVariable String page) throws Exception {
		PageInfo<OldManExtend> oldPages = null;
		oldPages = oldimpl.selectMsgByPage(Integer.parseInt(page), 5);
			//模糊查询
		session.setAttribute("oldPages", oldPages);
		return "pages/oldManInfo";
	}
	//分页模糊查询
	@RequestMapping("/getMsgBySource/{page}") 
	public String getOldManMsgByString(HttpSession session,
									   HttpServletRequest request,
									   @PathVariable String page) throws Exception {
		String source = request.getParameter("source");
		PageInfo<OldManExtend> oldPages = oldimpl.fuzzyQueryByPage(source, Integer.parseInt(page), 20);

		session.setAttribute("oldPages", oldPages);
		
		return "pages/oldManInfo";
	}
	
	@RequestMapping("/addOldmanMsg")
	@ResponseBody
	public String addOldManMsg(OldMan oldman) {
		System.out.println(oldman);
		oldman.setOldNumber(NumberProduct.getNumber());
		oldimpl.addOldManMsg(oldman);	
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
