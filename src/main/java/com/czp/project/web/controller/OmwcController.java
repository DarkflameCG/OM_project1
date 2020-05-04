package com.czp.project.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czp.project.common.bean.Room;
import com.czp.project.common.bean.extend.WaichuExtend;
import com.czp.project.common.bean.extend.ZhuanFangExtend;
import com.czp.project.service.impl.OmwcImpl;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/wc")
public class OmwcController {
	
	@Autowired
	private OmwcImpl omwcImpl;
	
	@RequestMapping("/get/{page}")
	public String queryAllGoOutMsg(HttpServletRequest request,
			   					   HttpSession session,
			   					   @PathVariable String page) {
		String source = request.getParameter("source");
		PageInfo<WaichuExtend> oldwcPages = null;
		if(source == null || source.equals("")) {
			oldwcPages = omwcImpl.selectAllByPage(Integer.parseInt(page), 5);
			
		}else {
			//模糊查询
			//oldzfPages = omzfImpl.fuzzyQueryByPage(source, Integer.parseInt(page), 10);
		}
		session.setAttribute("oldwcPages", oldwcPages);
		return "pages/oldmanWaichu";
		
	}
}
