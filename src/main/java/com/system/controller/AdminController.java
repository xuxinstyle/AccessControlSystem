package com.system.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.po.PagingVO;
import com.system.po.User;
import com.system.service.UserFaceService;
import com.system.service.AdminService;
import com.system.service.LoginService;
@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	private LoginService loginService;
	
	@Resource(name="adminServiceImpl")
	private AdminService adminService;
	
	@Resource(name="userFaceServiceImpl")
	private UserFaceService userFaceService;
	
	@RequestMapping(value="/showUser")
	public String ShowUser(Model model, Integer page,HttpSession session) throws Exception{
		//System.out.println("进入showUser------------");
		List<User> list = null;
	        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        //System.out.println("总页数："+adminService.getCountUser());
        pagingVO.setTotalCount(adminService.getCountUser());
        
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = adminService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);

            list = adminService.findByPaging(page);
            //System.out.println(list);
        }
        User user=(User)session.getAttribute("user");
        //System.out.println("user:"+user.getUsername());
        model.addAttribute("UserList", list);
        model.addAttribute("pagingVO", pagingVO);
        /**
         * 在前面加redirct:或forward：不经过拦截器  并不会加前缀，后缀
         * 如果需要经过拦截器只要不加redirect:或forward：
         */
		return "admin/Usershow";
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
		
		List<User> list = adminService.findByName(username);
		model.addAttribute("UserList", list);
		
		return "admin/Usershow";
		
	}
	
	 //  添加用户信息页面显示
    @RequestMapping(value = "/addUser", method = {RequestMethod.GET})
    public String addUserUI(Model model) throws Exception {

        return "admin/addUser";
    }

     // 添加用户信息操作
    @RequestMapping(value = "/addUser", method = {RequestMethod.POST})
    public String addUser(User user, Model model) {
    	//System.out.println("进入addUser");
        Boolean result;
		try {
			result = adminService.save(user);
			//重定向
	        return "redirect:/admin/showUser";
		} catch (Exception e) {
			
			model.addAttribute("message", "用户名重复");
			e.printStackTrace();
			return "error";
			
		}

    }
    // 修改个人信息页面显示
    @RequestMapping(value="/editUser", method = {RequestMethod.GET})
    private String editUserUI(Model model,HttpSession session) throws Exception{
    	
    	User user1=(User)session.getAttribute("user");
    	//System.out.println("登录者："+user1.getUsername());
    	User user = loginService.findByPrimaryKey(user1.getUsername());
    	model.addAttribute("user", user);
    	return "/admin/editUser";
    }
    // 修改个人信息
    @RequestMapping(value="/editUser", method = {RequestMethod.POST})
    private String editUser(User user) throws Exception{
    	
    	int i = loginService.updateByPrimaryKey(user);
    	//System.out.println(i);
    	
    	return "redirect:/admin/showUser";
    }

    // 删除用户
    @RequestMapping(value = "/removeUser", method = {RequestMethod.GET} )
    private String removeStudent(String username) throws Exception {
    	
        adminService.removeByPrimaryKey(username);
        

        return "redirect:/admin/showUser";
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
		//System.out.println("开始录入：");
		userFaceService.getFace(username);
		userFaceService.getFeatures(username);
		User user = adminService.findByPrimaryKey(username);
		model.addAttribute("user", user);
		return "/admin/success";
		
	}
	
	
}
