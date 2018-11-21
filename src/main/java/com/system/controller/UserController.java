package com.system.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.system.po.User;
import com.system.service.AdminService;
import com.system.service.LoginService;
import com.system.service.UserFaceService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Resource(name="adminServiceImpl")
	private AdminService adminService;
	
	@Resource(name="userFaceServiceImpl")
	private UserFaceService userFaceService;
	
	
	@RequestMapping(value="/userFaceEntry")
	public String FaceEntryEdit(Model model, String username) throws Exception{
		System.out.println("开始录入：");
		userFaceService.getFace(username);
		userFaceService.getFeatures(username);
		User user = adminService.findByPrimaryKey(username);
		model.addAttribute("user", user);
		return "/user/success";
		
	}
}
