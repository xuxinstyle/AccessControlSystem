package com.system.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.system.po.User;
import com.system.service.LoginService;
import com.system.service.UserFaceService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Resource(name="loginServiceImpl")
	private LoginService loginService;
	
	@Resource(name="userFaceServiceImpl")
	private UserFaceService userFaceService;
	
	
	@RequestMapping(value="/userFaceEntry")
	public String FaceEntryEdit(Model model, String username){
		System.out.println("开始录入：");
		try {
			//System.out.println(username);
			userFaceService.getFace(username);
			userFaceService.getFeatures(username);
			User user = loginService.findByPrimaryKey(username);
			//System.out.println("录入成功："+user.getUsername()+"权限："+user.getRolename());
			model.addAttribute("user", user);
			if("superadmin".equals(user.getRolename())){
				//System.out.println("super");
				return "/super/userSuccess";
			}else {
				//System.out.println("admin");
				return "/admin/userSuccess";
			}
			
		} catch (Exception e) {
			//System.out.println("录入失败");
			model.addAttribute("message", "录入人脸信息失败");
			e.printStackTrace();
			return "/error";
			
		}
		
		
	}
	@RequestMapping(value="/index")
	public String index(Model model){
		
		
		return "../../index";
	}
}
