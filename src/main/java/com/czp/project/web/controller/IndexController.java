package com.czp.project.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.project.common.bean.BaseUser;
import com.czp.project.common.bean.Charges;
import com.czp.project.service.impl.IndexImpl;
import com.czp.project.service.interfaces.IndexService;
import com.github.pagehelper.PageInfo;
/**
 * 收费设置
 * @author mastercgx
 *
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	@Autowired
	private IndexService indexImpl;
	 @RequestMapping("/finance/{page}")
		public String getIndex(HttpSession session,
								  @PathVariable String page) throws NumberFormatException, Exception {
		   
		 //分页收费信息
		 PageInfo<Charges> info = indexImpl.findAllForPage(Integer.parseInt(page), 6);
		  session.setAttribute("indexs", info); 
		 
			return "pages/moneySetting";
		}
	//批量或单个删除
	   @RequestMapping("/deleteIndex")
	   @ResponseBody
     public String deleteIndex(@RequestParam String id) {
		  
		   try {
			   String[] d=null;
			   if(id.contains(",")) {
				  
					//批量删除
				   d=id.split(",");//把数组里的值逗号隔开
				   indexImpl.removeIndexByIds(d);
				}else {		
					indexImpl.removeIndexById(Integer.parseInt(id));
				}
				   return "ok";
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ok";
		}
					
     }
}
