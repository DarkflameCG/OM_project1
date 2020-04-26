package com.czp.project.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 页面直接显示接口
 * @author mastercgx
 *
 */
@Controller
@RequestMapping("/common")
public class CommonController {
	
	@RequestMapping("/attendance") //护工考勤
	public String test1() {
		return "pages/attendance"; 
	}
	
	@RequestMapping("/exam") //体检
	public String test2() {
		return "pages/exam";
	}
	
	@RequestMapping("/home") //家属
	public String test3() {
		return "pages/home";
	}
	@RequestMapping("/money") //工资
	public String test4() {
		return "pages/money";
	}
	@RequestMapping("/moneyLog") //收费记录
	public String test5() {
		return "pages/moneyLog";
	}
	@RequestMapping("/moneySetting") //收费设置
	public String test6() {
		return "pages/moneySetting";
	}
	@RequestMapping("/oldmanQingjia") //老人请假
	public String test7() {
		return "pages/oldManQingjia";
	}
	@RequestMapping("/oldmanRuzhu") //老人入住
	public String test8() {
		return "pages/oldManRuzhu";
	}
	@RequestMapping("/oldmanWaichu") //老人外出
	public String test9() {
		return "pages/oldmanWaichu";
	}
	@RequestMapping("/oldmanZhuanfang") //老人转房
	public String test10() {
		return "pages/oldmanZhuanfang";
	}
	@RequestMapping("/provid") //
	public String test11() {
		return "pages/provid";
	}
	@RequestMapping("/roles") //角色管理
	public String test12() {
		return "pages/roles";
	} 
	@RequestMapping("/seek")  //外出就医
	public String test13() {
		return "pages/seek";
	}
	@RequestMapping("/setting") //个人设置
	public String test14() {
		return "pages/setting";
	}
	@RequestMapping("/usermanager") //用户管理
	public String test15() {
		return "pages/usermanager";
	}
	@RequestMapping("/waiters")
	public String test16() {
		return "pages/waiters";
	}
	
}



