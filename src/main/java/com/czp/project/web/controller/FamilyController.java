package com.czp.project.web.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.project.common.bean.FamilyMembers;
import com.czp.project.service.interfaces.FamilyService;

@Controller
@RequestMapping("/family")
public class FamilyController {
	@Autowired
	private FamilyService familyService;
	// 登录验证
		@ResponseBody
		@PostMapping("/login")
		public String login(@RequestBody FamilyMembers familyMembers, HttpSession session) {
			try {
				FamilyMembers login = familyService.selectLogin(familyMembers);
				if (login == null) {
					return "login";
				}
				session.setAttribute("familyLogin", login);
				return "index";
			} catch (Exception e) {
				return "login";
			}
		}
		// 修改密码
				@ResponseBody
				@PostMapping("/modifyPassword")
				public String modifyPassword(@RequestBody FamilyMembers familyMembers, HttpSession session) {
					try {
						familyService.updateBytelphone(familyMembers);
						return "login";
					} catch (Exception e) {
						return "login";
					}
				}
}
