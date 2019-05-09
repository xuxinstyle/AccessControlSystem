package com.system.utils;

import java.util.Date;
import java.util.concurrent.Callable;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.system.controller.LoginController;
import com.system.po.User;
import com.system.service.LoginService;
import com.system.service.UserFaceService;
import com.system.service.VisitService;
@Service
public class FaceLoginTask implements Callable<Object>{
	private static Logger logger = Logger.getLogger(FaceLoginTask.class);
	
	@Resource(name="userFaceServiceImpl")
	private UserFaceService userFaceService;
	
	@Resource(name="loginServiceImpl")
	private LoginService loginService;
	
	@Resource(name="visitServiceImpl")
	private VisitService visitService;
	
	public Object call() throws Exception {  
		//System.out.println("正在识别人脸---------");
    	logger.info("开始人脸识别");
    	User user = userFaceService.CheckFace();
    	if(user!=null){
	        //如果获取不到用户名就是登录失败，但登录失败的话，会直接抛出异常
	        if("superadmin".equals(user.getRolename())||"admin".equals(user.getRolename())||"user".equals(user.getRolename())){

	        	logger.info(user.getUsername()+"，识别人脸成功");
	        	Date date=new Date();
	        	user.setLastopentime(date);
	        	user.setOpennum(user.getOpennum()+1);
	        	
	        	loginService.updateByPrimaryKey(user);
	        	System.out.println("更新完访问次数");
	        	visitService.saveVisit(user);
	        	System.out.println("添加完访客记录");
	        	//model.addAttribute("user", user);
	        	
	        	logger.info("跳转到success页面");
	        	return user;
	        }else{
	        	logger.info("跳转到failure页面");
	        	logger.info("对不起，未找到匹配的人脸信息！");
	        	return "failure";
	        }
    	}
    	return "failure";
	}  
}
