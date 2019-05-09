package com.system.controller;

import com.system.mapper.LoginMapper;
import com.system.po.User;
import com.system.service.LoginService;
import com.system.service.UserFaceService;
import com.system.service.VisitService;
import com.system.utils.FaceLoginTask;
import com.system.utils.ThreadUtil;

import java.util.Date;
import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Administrator
 *
 */
@Controller
public class LoginController {
	private static Logger logger = Logger.getLogger(LoginController.class);
    //登录跳转
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String loginUI() throws Exception {
        return "../../login";
    }
	@Resource(name="userFaceServiceImpl")
	private UserFaceService userFaceService;
	@Resource(name="loginServiceImpl")
	private LoginService loginService;
	@Resource(name="visitServiceImpl")
	private VisitService visitService;

    //登录表单处理
    @RequestMapping(value = "/login") //, method = {RequestMethod.POST}
    public String login(User user,HttpSession session) {

        //Shiro实现登录
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),
                user.getPassword());
        Subject subject = SecurityUtils.getSubject();
    	token.setRememberMe(true); 
    	//System.out.println("正在登录---------");
        //如果获取不到用户名就是登录失败，但登录失败的话，会直接抛出异常
        subject.login(token);
        if(subject.hasRole("superadmin")){
        	logger.info("超级管理员:"+user.getUsername()+"登录成功！");
        	//System.out.println("超级管理员登录成功！");
        	session.setAttribute("user", user);
        	return "redirect:/super/showadmin";
        }else if(subject.hasRole("admin")){
        	logger.info("管理员:"+user.getUsername()+"登录成功！");
        	//System.out.println("管理员登录成功！");
        	session.setAttribute("user", user);
        	return "redirect:/admin/showUser";
        }else if(subject.hasRole("user")){
        	logger.info(user.getUsername()+"没有登录权限，登录失败！");
        	//System.out.println("user");
        	session.setAttribute("msg", "对不起，您没有登录权限！");
        	return "redirect:/login";
        }
        session.setAttribute("user", user);
        //System.out.println("错误");
        return "../../login";
        
    }
    
    //人脸识别
    @RequestMapping(value="/facelogin")
    public String faceLogin(Model model) throws Exception{
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
	        	
	        	visitService.saveVisit(user);
	        	
	        	model.addAttribute("user", user);
	        	logger.info("跳转到success页面");
	        	return "success";
	        }else{
	        	logger.info("跳转到failure页面");
	        	logger.info("对不起，未找到匹配的人脸信息！");
	        	return "failure";
	        }
    	}
    	return "failure";
    }
    
    @RequestMapping(value="/index")
	public String index(Model model){
		
		
		return "../../facelogin";
	}
    
    /*@RequestMapping(value = "/facelogin", method = {RequestMethod.GET})
    public String facelogin(Model model){
		return "../../facelogin";
	}*/
}
