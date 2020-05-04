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
import com.czp.project.common.bean.OmZhuanfang;
import com.czp.project.common.bean.Room;
import com.czp.project.common.bean.extend.ZhuanFangExtend;
import com.czp.project.service.impl.BedRoomImpl;
import com.czp.project.service.impl.OldManMsgImpl;
import com.czp.project.service.impl.OmzfImpl;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/zf")
public class OmzfController {
	
	@Autowired
	private OmzfImpl omzfImpl;
	@Autowired
	private BedRoomImpl roomimpl;
	@Autowired
	private OldManMsgImpl oldmanimpl;
	
	//分页及联查询数据
	@RequestMapping("/get/{page}")
	private String queryAllTransferRoomMsg(HttpServletRequest request,
										   HttpSession session,
										   @PathVariable String page) {
		String source = request.getParameter("source");
		PageInfo<ZhuanFangExtend> oldzfPages = null;
		if(source == null || source.equals("")) {
			oldzfPages = omzfImpl.selectAllByPage(Integer.parseInt(page), 5);
			if(page.equals("1")) {
				//第一页的时候查出所有的空房间和有人的房间
				//已经占用的所有房间
				List<Room> rooms1 = roomimpl.getRoomForUsed();
				//空着的所有房间
				List<Room> rooms2 = roomimpl.getRoomForEmpty();
				session.setAttribute("usedRooms", rooms1);
				session.setAttribute("emptyRooms", rooms2);
			}
		}else {
			//模糊查询
			//oldzfPages = omzfImpl.fuzzyQueryByPage(source, Integer.parseInt(page), 10);
		}
		session.setAttribute("oldzfPages", oldzfPages);
		return "pages/oldmanZhuanfang";
	}
	
	//办理入住
	@RequestMapping("/transfer")
	@ResponseBody
	public String transferRoom(OmZhuanfang zf,@RequestParam String oldNumb) {
		//先根据编号信息查询老人信息
		OldMan oldman = oldmanimpl.getOldmanByNumb(oldNumb);
		//记录添加进去
		zf.setOldmanId(oldman.getId());
		zf.setTime(new Date());
		omzfImpl.addZf(zf);
		//更改房间的状态
		roomimpl.switchRoomStatus(zf.getOutRoomId());
		roomimpl.switchRoomStatus(zf.getInRoomId());
		
		return "ok";
	}
	
	//删除逻辑
	@RequestMapping("/remove")
	@ResponseBody
	public String removeTransferLog(@RequestParam String id) {
		System.out.println(id);
		if(id.contains(",")) {
			//批量删除
			omzfImpl.removeZfByids(id);
		}else {			
			//根据id删除
			omzfImpl.removeZfById(Integer.parseInt(id));
		}
		return "ok";
	}
	
	//编辑转房记录
	@RequestMapping("/edit")
	@ResponseBody
	public String editTransferLog(OmZhuanfang newmsg) {
		
		omzfImpl.updateZf(newmsg);
		return "ok";
	}
	
}
