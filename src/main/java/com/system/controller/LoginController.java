package com.system.controller;

import com.system.mapper.LoginMapper;
import com.system.po.User;
import com.system.service.LoginService;
import com.system.service.UserFaceService;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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

    //登录跳转
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String loginUI() throws Exception {
        return "../../login";
    }
	@Resource(name="userFaceServiceImpl")
	private UserFaceService userFaceService;
	@Resource(name="loginServiceImpl")
	private LoginService loginService;
	
    //登录表单处理
    @RequestMapping(value = "/login") //, method = {RequestMethod.POST}
    public String login(User user,HttpSession session) {

        //Shiro实现登录
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),
                user.getPassword());
        Subject subject = SecurityUtils.getSubject();
    	token.setRememberMe(true); 
    	System.out.println("正在登录---------");
        //如果获取不到用户名就是登录失败，但登录失败的话，会直接抛出异常
        subject.login(token);
        if(subject.hasRole("superadmin")){
        	System.out.println("超级管理员登录成功！");
        	session.setAttribute("user", user);
        	return "redirect:/super/showUser";
        }else if(subject.hasRole("admin")){
        	System.out.println("管理员登录成功！");
        	session.setAttribute("user", user);
        	return "redirect:/admin/showUser";
        }else if(subject.hasRole("user")){
        	System.out.println("user");
        	session.setAttribute("msg", "对不起，您没有登录权限！");
        	return "redirect:/admin/showUser";
        }
        session.setAttribute("user", user);
        System.out.println("错误");
        return "../../login";
        
    }
    
    @RequestMapping(value="/facelogin")
    public String faceLogin(Model model) throws Exception{
    	System.out.println("正在识别人脸---------");
    	User user = userFaceService.CheckFace();
    	System.out.println("username:"+user.getUsername());
        //如果获取不到用户名就是登录失败，但登录失败的话，会直接抛出异常
        if("superadmin".equals(user.getRolename())||"admin".equals(user.getRolename())||"user".equals(user.getRolename())){
        	System.out.println("欢迎您："+user.getUsername());
        	Date date=new Date();
        	user.setLastopentime(date);
        	user.setOpennum(user.getOpennum()+1);
        	loginService.updateByPrimaryKey(user);
        	model.addAttribute("user", user);
        	return "success";
        }else{
        	System.out.println("对不起，未找到匹配的人脸信息！");
        	return "failure";
        }
    }
    
    @RequestMapping(value="/index")
	public String index(Model model){
		
		
		return "../../index";
	}
}
