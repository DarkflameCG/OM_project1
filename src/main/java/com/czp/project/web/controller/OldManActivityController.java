package com.czp.project.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.czp.project.common.bean.*;
import com.czp.project.common.bean.extend.OldManExtend;
import com.czp.project.service.impl.BedRoomImpl;
import com.czp.project.service.impl.OldManMsgImpl;
import com.czp.project.service.interfaces.NursWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czp.project.common.bean.extend.OldManRuZhuEX;
import com.czp.project.service.interfaces.OldManRuZhuService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/activity")
public class OldManActivityController {
	@Autowired
	private OldManRuZhuService oldManRuZhuService;
	@Autowired
	private OldManMsgImpl oldmanimpl;
	@Autowired
	private BedRoomImpl roomimpl;
	@Autowired
	private NursWorkService nursImpl;

	@RequestMapping("/ruzhu/{page}")
	public String getBaseUser(HttpSession session,
							  @PathVariable String page) throws NumberFormatException, Exception {

	 	//分页入住信息
		PageInfo<OldManRuZhuEX> info = oldManRuZhuService.findAllOldManRuZhuEX(Integer.parseInt(page), 2);
		session.setAttribute("ruzhus", info);

		//需要查出所有空房间
		List<Room> rooms2 = roomimpl.getRoomForEmpty();
		session.setAttribute("emptyRooms", rooms2);
		//需要查出所有护工
		List<BaseUser> nurseList = nursImpl.selectAll();
		session.setAttribute("nurseList",nurseList);

		return "pages/oldManRuzhu";
	}

	//分页模糊查询
	@RequestMapping("/getByName/{page}")
	public String getCheckInMsgByString(HttpSession session,
									   HttpServletRequest request,
									   @PathVariable String page) throws Exception {
		String source = request.getParameter("source");
		PageInfo<OldManRuZhuEX> info = oldManRuZhuService.fuzzyQueryByPage(source, Integer.parseInt(page), 20);

		session.setAttribute("ruzhus", info);

		return "pages/oldManRuzhu";
	}

	@RequestMapping("/add")
	@ResponseBody
	public String addCheckInMsg(OldManRuZhu rz,
								@RequestParam String oldNumb,
								@RequestParam String inhugongName) {
		//先根据编号信息查询老人信息

		OldMan oldman = oldmanimpl.getOldmanByNumb(oldNumb);
		//记录添加进去
		oldman.setUserId(Integer.parseInt(inhugongName));
		rz.setOldmanId(oldman.getId());
		rz.setTime(new Date());
		oldManRuZhuService.addRz(rz);
		//改变房间状态
		roomimpl.switchRoomStatus(Integer.parseInt(rz.getInRoomId()));
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
