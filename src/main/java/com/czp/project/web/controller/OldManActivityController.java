package com.czp.project.web.controller;

import javax.servlet.http.HttpSession;

import com.czp.project.common.bean.OldManRuZhu;
import com.czp.project.common.bean.OmQingjia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czp.project.common.bean.extend.OldManRuZhuEX;
import com.czp.project.service.interfaces.OldManRuZhuService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/activity")
public class OldManActivityController {
	@Autowired
	private OldManRuZhuService oldManRuZhuService;

	@RequestMapping("/ruzhu/{page}")
	public String getBaseUser(HttpSession session,
							  @PathVariable String page) throws NumberFormatException, Exception {

	 	//分页入住信息
		PageInfo<OldManRuZhuEX> info = oldManRuZhuService.findAllOldManRuZhuEX(Integer.parseInt(page), 2);
	  	session.setAttribute("ruzhus", info);
		return "pages/oldManRuzhu";
	}

	@RequestMapping("/add")
	@ResponseBody
	public String addCheckInMsg(OldManRuZhu rz) {
//		//先根据编号信息查询老人信息
//		OldMan oldman = oldmanimpl.getOldmanByNumb(oldNumb);
//		//记录添加进去
//		zf.setOldmanId(oldman.getId());
//		zf.setTime(new Date());
//		omqjimpl.addQj(qj);
		return "ok";
	}

	//删除逻辑
	@RequestMapping("/remove")
	@ResponseBody
	public String removeCheckInMsg(@RequestParam String id) {
		System.out.println(id);
		if(id.contains(",")) {
			//批量删除
			oldManRuZhuService.removeRzByids(id);
		}else {
			//根据id删除
			oldManRuZhuService.removeRzById((Integer.parseInt(id)));
		}
		return "ok";
	}

	//编辑
	@RequestMapping("/edit")
	@ResponseBody
	public String editCheckInMsg(OldManRuZhu newmsg) {

		oldManRuZhuService.updateRz(newmsg);
		return "ok";
	}
}
