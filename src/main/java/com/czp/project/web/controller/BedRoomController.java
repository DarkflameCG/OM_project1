package com.czp.project.web.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czp.project.common.bean.Room;
import com.czp.project.service.impl.BedRoomImpl;

@Controller
@RequestMapping("/room")
public class BedRoomController {
	
	@Autowired
	private BedRoomImpl bedRoomImpl;
	
	@RequestMapping("/get/{levelid}")
	public String getRoomByLevelId(@PathVariable String levelid,
									HttpSession session) {
		System.out.println(levelid);
		List<Room> list = bedRoomImpl.getRoomByLevelId(Integer.parseInt(levelid));
		List<List<Room>> bedList = new ArrayList<List<Room>>();
		for(int i=0;i<list.size()-1;i++) {
			if(list.get(i).getRoomNumb().substring(1, 3).equals(list.get(i+1).getRoomNumb().substring(1, 3))) {
				List<Room> listsub = new ArrayList<Room>();
				listsub.add(list.get(i));
				listsub.add(list.get(i+1));
				bedList.add(listsub);
			}
		}
		
		
		session.setAttribute("bedlist", bedList);
		return "pages/bed";
	}
}
