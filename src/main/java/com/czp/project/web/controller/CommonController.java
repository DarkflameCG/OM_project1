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
	
	@RequestMapping("/attendance")
	public String test1() {
		return "pages/attendance";
	}
	
	@RequestMapping("/exam")
	public String test2() {
		return "pages/exam";
	}
	
	@RequestMapping("/home")
	public String test3() {
		return "pages/home";
	}
	@RequestMapping("/money")
	public String test4() {
		return "pages/money";
	}
	@RequestMapping("/moneyLog")
	public String test5() {
		return "pages/moneyLog";
	}
	@RequestMapping("/moneySetting")
	public String test6() {
		return "pages/moneySetting";
	}
	@RequestMapping("/oldmanQingjia")
	public String test7() {
		return "pages/oldmanQingjia";
	}
	@RequestMapping("/oldmanRuzhu")
	public String test8() {
		return "pages/oldmanRuzhu";
	}
	@RequestMapping("/oldmanWaichu")
	public String test9() {
		return "pages/oldmanWaichu";
	}
	@RequestMapping("/oldmanZhuanfang")
	public String test10() {
		return "pages/oldmanZhuanfang";
	}
	@RequestMapping("/provid")
	public String test11() {
		return "pages/provid";
	}
	@RequestMapping("/roles")
	public String test12() {
		return "pages/roles";
	}
	@RequestMapping("/seek")
	public String test13() {
		return "pages/seek";
	}
	@RequestMapping("/setting")
	public String test14() {
		return "pages/setting";
	}
	@RequestMapping("/usermanager")
	public String test15() {
		return "pages/usermanager";
	}
	@RequestMapping("/waiters")
	public String test16() {
		return "pages/waiters";
	}
	
}



