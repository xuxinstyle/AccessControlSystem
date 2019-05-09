package com.system.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.po.User;
import com.system.service.LoginService;
import com.system.service.UserFaceService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	@Resource(name="loginServiceImpl")
	private LoginService loginService;
	
	@Resource(name="userFaceServiceImpl")
	private UserFaceService userFaceService;
	
	
	@RequestMapping(value="/userFaceEntry")
	public String FaceEntryEdit(Model model, String username){
		logger.info("开始录入:"+username+" 人脸信息");
		try {
			//System.out.println(username);
			userFaceService.getFace(username);
			userFaceService.getFeatures(username);
			User user = loginService.findByPrimaryKey(username);
			logger.info("录入"+username+"人脸信息成功！");
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
			logger.error(username+"的人脸信息录入失败！");
			//System.out.println("录入失败");
			model.addAttribute("message", "录入人脸信息失败");
			e.printStackTrace();
			return "/error";
			
		}
		
		
	}
	
}
