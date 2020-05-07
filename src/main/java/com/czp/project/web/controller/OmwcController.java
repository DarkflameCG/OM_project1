package com.czp.project.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.OmWaichu;
import com.czp.project.common.bean.OmZhuanfang;
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
	
	@RequestMapping("/add")
	@ResponseBody
	public String addGoOutMsg(OmWaichu wc) {
//		//先根据编号信息查询老人信息
//		OldMan oldman = oldmanimpl.getOldmanByNumb(oldNumb);
//		//记录添加进去
//		zf.setOldmanId(oldman.getId());
//		zf.setTime(new Date());
		omwcImpl.addWc(wc);
		return "ok";
	}
	
	//删除逻辑
	@RequestMapping("/remove")
	@ResponseBody
	public String removeGoOutMsg(@RequestParam String id) {
		System.out.println(id);
		if(id.contains(",")) {
			//批量删除
			omwcImpl.removeWcByids(id);
		}else {			
			//根据id删除
			omwcImpl.removeWcById(Integer.parseInt(id));
		}
		return "ok";
	}
	
	//编辑
	@RequestMapping("/edit")
	@ResponseBody
	public String editGoOutMsg(OmWaichu newmsg) {
		
		omwcImpl.updateWc(newmsg);
		return "ok";
	}
	
}
