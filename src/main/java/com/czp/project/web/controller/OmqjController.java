package com.czp.project.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.czp.project.common.bean.OldMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.project.common.bean.OmQingjia;
import com.czp.project.common.bean.OmWaichu;
import com.czp.project.common.bean.extend.QingjiaExtend;
import com.czp.project.common.bean.extend.WaichuExtend;
import com.czp.project.service.impl.OmqjImpl;
import com.czp.project.service.impl.OmwcImpl;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/qj")
public class OmqjController {
	@Autowired
	private OmqjImpl omqjimpl;
	
	@RequestMapping("/get/{page}")
	public String queryAllGoOutMsg(HttpServletRequest request,
			   					   HttpSession session,
			   					   @PathVariable String page) {
		PageInfo<QingjiaExtend> oldqjPages = omqjimpl.selectAllByPage(Integer.parseInt(page), 5);
		session.setAttribute("oldqjPages", oldqjPages);
		return "pages/oldManQingjia";
	}
	//分页模糊查询
	@RequestMapping("/getBySource/{page}")
	public String getAllGoOutMsgByString(HttpSession session,
									   HttpServletRequest request,
									   @PathVariable String page) throws Exception {
		String source = request.getParameter("source");
//		PageInfo<OldMan> oldqjPages = oldimpl.fuzzyQueryByPage(source, Integer.parseInt(page), 20);
//		session.setAttribute("oldqjPages", oldqjPages);

		return "pages/oldManInfo";
	}


	@RequestMapping("/add")
	@ResponseBody
	public String addLeaveMsg(OmQingjia qj) {
//		//先根据编号信息查询老人信息
//		OldMan oldman = oldmanimpl.getOldmanByNumb(oldNumb);
//		//记录添加进去
//		zf.setOldmanId(oldman.getId());
//		zf.setTime(new Date());
		omqjimpl.addQj(qj);
		return "ok";
	}
	
	//删除逻辑
	@RequestMapping("/remove")
	@ResponseBody
	public String removeLeaveMsg(@RequestParam String id) {
		System.out.println(id);
		if(id.contains(",")) {
			//批量删除
			omqjimpl.removeQjByids(id);
		}else {			
			//根据id删除
			omqjimpl.removeQjById(Integer.parseInt(id));
		}
		return "ok";
	}
	
	//编辑
	@RequestMapping("/edit")
	@ResponseBody
	public String editLeaveMsg(OmQingjia newmsg) {
		
		omqjimpl.updateQj(newmsg);
		return "ok";
	}
}
