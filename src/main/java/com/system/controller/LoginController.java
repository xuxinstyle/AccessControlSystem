package com.system.controller;

import com.system.po.User;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Administrator
 *
 */
@Controller
public class LoginController {

   /* //登录跳转
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String loginUI() throws Exception {
        return "../../login";
    }*/

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
        }
        session.setAttribute("user", user);
        return "redirect:/login";
        
    }

}
