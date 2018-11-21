package com.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.po.PagingVO;
import com.system.po.User;
import com.system.service.UserFaceService;
import com.system.service.LoginService;
import com.system.service.SuperService;
@Controller
@RequestMapping(value="/super")
public class SuperController {
	@Autowired
	private SuperService superService;
	
	@Autowired
	private UserFaceService userFaceService;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/showUser")
	public String ShowUser(Model model, Integer page) throws Exception{
		System.out.println("进入showUser------------");
		List<User> list = null;
	        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(superService.getCountUser());
        System.out.println("总数：superService.getCountUser()");
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = superService.findByPaging(1);
            System.out.println("list 1:"+list.get(0).getUsername());
        } else {
            pagingVO.setToPageNo(page);

            list = superService.findByPaging(page);
            System.out.println("list:"+page);
        }
        
        model.addAttribute("UserList", list);
        model.addAttribute("pagingVO", pagingVO);
        /**
         * 在前面加redirct:或forward：不经过拦截器  并不会加前缀，后缀
         * 如果需要经过拦截器只要不加redirect:或forward：
         */
		return "super/Usershow";
	}
	/**
	 * 搜索用户
	 * @param model
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectUser")
	public String SelectUser(Model model, String username) throws Exception{
		
		List<User> list = superService.findByName(username);
		model.addAttribute("UserList", list);
		
		return "super/Usershow";
		
	}
	
	 //  添加用户信息页面显示
    @RequestMapping(value = "/addUser", method = {RequestMethod.GET})
    public String addStudentUI(Model model) throws Exception {

        return "super/addUser";
    }

     // 添加用户信息操作
    @RequestMapping(value = "/addUser", method = {RequestMethod.POST})
    public String addUser(User user, Model model) throws Exception {

        Boolean result = superService.save(user);
        System.out.println(result);
        if (!result) {
            model.addAttribute("message", "用户名重复");
            return "error";
        }

        //重定向
        return "redirect:/super/showUser";
    }

   

    // 删除用户
    @RequestMapping(value = "/removeUser", method = {RequestMethod.GET} )
    private String removeStudent(String username) throws Exception {
    	
        superService.removeByPrimaryKey(username);
        

        return "redirect:/super/showUser";
    }
	// 修改个人信息
    @RequestMapping(value="/editUser")
    private String editUser(User user) throws Exception{
    	
    	loginService.updateByPrimaryKey(user);
    	
    	return "redirect:/super/showUser";
    }
    
	/**
	 * 调用python代码录入人脸信息
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/faceEntry")
	public String FaceEntry(Model model, String username) throws Exception{
		
		userFaceService.getFace(username);
		userFaceService.getFeatures(username);
		User user = superService.findByPrimaryKey(username);
		model.addAttribute("user", user);
		return "success";
		
	}
}
