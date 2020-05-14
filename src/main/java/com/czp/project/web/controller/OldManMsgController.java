package com.czp.project.web.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.czp.project.common.bean.*;
import com.czp.project.service.impl.*;
import com.czp.project.service.interfaces.FamilyService;
import com.czp.project.utils.ExcelWriter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
	@Autowired
	private FamilyService familyService;
	
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
	public String addOldManMsg(OldMan oldman,
							   @RequestParam String familyTel) {
		oldman.setOldNumber(NumberProduct.getNumber());

		FamilyMembers fm = new FamilyMembers();
		fm.setTelphone(familyTel);
		fm.setFamilyPassword(oldman.getOldNumber().substring(2));
		familyService.addFamily(fm);

		FamilyMembers temp = familyService.selectByTel(familyTel);
		oldman.setFamilyMembersId(temp.getId());
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


	//一键导出老人信息
	@RequestMapping("/exportExcel")
	public void downloadOldMsgForExcel(HttpServletRequest request,
										 HttpServletResponse response) throws Exception{
		Workbook workbook = null;
		OutputStream out = null;
		try {
			// todo 根据业务需求获取需要写入Excel的数据列表 dataList
			List<OldManExtend> dataList = oldimpl.selectAll();
			// 生成Excel工作簿对象并写入数据
			workbook = ExcelWriter.exportData(dataList);

			// 写入Excel文件到前端
			String excelName = "老人信息总表";
			String fileName = excelName + System.currentTimeMillis() + ".xlsx";
			fileName = new String(fileName.getBytes("UTF-8"),"iso8859-1");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			response.setContentType("application/vnd.ms-excel");
			response.setContentType("application/x-download");
			response.setCharacterEncoding("UTF-8");
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
			response.flushBuffer();

			out = response.getOutputStream();
			workbook.write(out);
			out.flush();

		} catch (Exception e) {
			System.err.println("关闭workbook或outputStream出错！");
		} finally {
			try {
				if (null != workbook) {
					workbook.close();
				}
				if (null != out) {
					out.close();
				}
			} catch (IOException e) {
				System.err.println("关闭workbook或outputStream出错！");
			}
		}
	}




}
