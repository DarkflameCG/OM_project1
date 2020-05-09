package com.czp.project.web.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.czp.project.common.bean.*;
import com.czp.project.service.impl.*;
import com.czp.project.service.interfaces.BaseUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.czp.project.common.bean.extend.OldManExtend;
import com.czp.project.utils.NumberProduct;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/oldmsg")
public class OldManMsgController {
	
	@Autowired
	private OldManMsgImpl oldimpl;
	@Autowired
	private BedRoomImpl roomimpl;
	@Autowired
	private NursWorkServiceImpl nursImpl;
	@Autowired
	private OldManRuZhuServiceImpl rzimpl;
	@Autowired
	private OmzfImpl omzfImpl;
	
	//分页查询全部
	@RequestMapping("/getmsg/{page}")
	public String getOldManMsg(HttpSession session,
							  HttpServletRequest request,
							  @PathVariable String page) throws Exception {
		PageInfo<OldManExtend> oldPages = null;
		oldPages = oldimpl.selectMsgByPage(Integer.parseInt(page), 5);
		session.setAttribute("oldPages", oldPages);

		//需要查出所有空房间
		List<Room> rooms2 = roomimpl.getRoomForEmpty();
		session.setAttribute("emptyRooms", rooms2);
		//需要查出所有护工
		List<BaseUser> nurseList = nursImpl.selectAll();
		session.setAttribute("nurseList",nurseList);


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

	//护工权限下老人入住
	@RequestMapping("/checkin")
	@ResponseBody
	public String addCheckInMsg(OldManRuZhu rz,@RequestParam String inhugongName) {
		//记录添加进去
		rz.setTime(new Date());
		//根据id查出房间信息
		Room room = roomimpl.getRoomDetailById(rz.getInRoomId());
		//改变房间状态
		roomimpl.switchRoomStatus(Integer.parseInt(rz.getInRoomId()));


		//老人表里更新护工姓名和房间信息
		OldMan om = oldimpl.selectOldDetailById(rz.getOldmanId());
		om.setRoomId(Integer.parseInt(rz.getInRoomId()));
		rz.setInRoomId(room.getRoomNumb());
		rzimpl.addRz(rz);
		om.setUserId(Integer.parseInt(inhugongName));
		oldimpl.updateOldManMsg(om);

		return "ok";
	}

	//护工权限下老人转房
	//办理转房
	@RequestMapping("/transfer")
	@ResponseBody
	public String transferRoom(OmZhuanfang zf) {
		//记录添加进去
		zf.setTime(new Date());
		omzfImpl.addZf(zf);
		//更改房间的状态
		roomimpl.switchRoomStatus(zf.getOutRoomId());
		roomimpl.switchRoomStatus(zf.getInRoomId());
		//老人表房间id更新
		OldMan om = oldimpl.selectOldDetailById(zf.getOldmanId());
		om.setRoomId(zf.getInRoomId());
		oldimpl.updateOldManMsg(om);

		return "ok";
	}


}
