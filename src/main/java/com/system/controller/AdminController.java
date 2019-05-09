package com.system.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.system.po.PagingVO;
import com.system.po.User;
import com.system.po.Visitor;
import com.system.service.UserFaceService;
import com.system.service.VisitService;
import com.system.service.AdminService;
import com.system.service.LoginService;
@Controller
@RequestMapping(value="/admin")
public class AdminController {
	private static Logger logger = Logger.getLogger(AdminController.class);
	@Autowired
	private LoginService loginService;
	
	@Resource(name="adminServiceImpl")
	private AdminService adminService;
	
	@Resource(name="userFaceServiceImpl")
	private UserFaceService userFaceService;
	
	@Autowired
	private VisitService visitService;
	
	@RequestMapping(value="/showUser")
	public String ShowUser(Model model, Integer page,HttpSession session){
		try {
			//System.out.println("进入showUser------------");
			List<User> list = null;
		        //页码对象
	        PagingVO pagingVO = new PagingVO();
	        //设置总页数
	        //System.out.println("总页数："+adminService.getCountUser());
	        pagingVO.setTotalCount(adminService.getCountUser());
	        int UserNum = adminService.getCountUser();
	        if (page == null || page == 0) {
	            pagingVO.setToPageNo(1);
	            
					list = adminService.findByPaging(1);
				
	           
	        } else {
	            pagingVO.setToPageNo(page);
	
	            list = adminService.findByPaging(page);
	            //System.out.println(list);
	        }
	        list=adminService.checkHaveImage(list);
	        User user=(User)session.getAttribute("user");
	        //System.out.println("user:"+user.getUsername());
	        model.addAttribute("UserNum", UserNum);
	        model.addAttribute("UserList", list);
	        model.addAttribute("pagingVO", pagingVO);
	        /**
	         * 在前面加redirct:或forward：不经过拦截器  并不会加前缀，后缀
	         * 如果需要经过拦截器只要不加redirect:或forward：
	         */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("显示用户失败");
			e.printStackTrace();
		}
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
	public String SelectUser(Model model, String username){
		
		List<User> list;
		try {
			list = adminService.findByName(username);
			model.addAttribute("UserList", list);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("查询用户失败");
			e.printStackTrace();
		}
		
		
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
    /**
     * 修改用户信息页面显示
     * @param model
     * @return
     */
    @RequestMapping(value="/userPasswordRest",method={RequestMethod.GET})
    private String editAdminUI(Model model){
		
    	return "/admin/userPasswordRest";
    	
    }
    /**
     * 修改用户信息
     * @param model
     * @return
     * @throws Exception 
     */
    @RequestMapping(value="/userPasswordRest",method={RequestMethod.POST})
    private String editadmin(User user){
		
    	User u = new User();
		try {
			u = adminService.findByPrimaryKey(user.getUsername());
			//System.out.println(u.getPassword());
	    	u.setPassword(user.getPassword());
	    	int i = loginService.updateByPrimaryKey(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("修改用户信息失败");
			e.printStackTrace();
		}
    	
    	
    	//System.out.println(u.getPassword());
    	return "/admin/userPasswordRest";
    	
    }
    
    
 // 修改个人信息页面显示
    @RequestMapping(value="/editUser", method = {RequestMethod.GET})
    private String editUserUI(Model model,HttpSession session){
    	
    	
    	//System.out.println("登录者："+user1.getUsername());
    	
		try {
			User user1=(User)session.getAttribute("user");
			User user = loginService.findByPrimaryKey(user1.getUsername());
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("未获取的当前登录用户");
			e.printStackTrace();
		}
    	
    	return "/admin/editUser";
    }
    // 修改个人信息
    @RequestMapping(value="/editUser", method = {RequestMethod.POST})
    private String editUser(User user){
    	//System.out.println("--");
    	try {
			int i = loginService.updateByPrimaryKey(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("修改个人信息失败");
			e.printStackTrace();
		}
    	//System.out.println(i);
    	
    	return "redirect:/admin/showUser";
    }

    // 删除用户
    @RequestMapping(value = "/removeUser", method = {RequestMethod.GET} )
    private String removeStudent(String username,Integer page){
    	
        try {
			adminService.removeByPrimaryKey(username);
		} catch (Exception e) {
			logger.error("删除用户失败！");
			e.printStackTrace();
		}
        

        return "redirect:/admin/showUser?page="+page;
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
	/**
	 * 访问记录
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/showVisit")
	public String showVisit(Model model, Integer page){
		List<Visitor> list = visitService.FindAllVisit();
		logger.info("访问记录数量："+list.size());
		//System.out.println("访问记录数量："+list.size());
		//页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(list.size());
        //访问记录数量
        int VisitNum=list.size();
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = visitService.findByPagingVisit(1);
        } else {
            pagingVO.setToPageNo(page);

            list = visitService.findByPagingVisit(page);
            //System.out.println("list:"+page);
        }
        //System.out.println("-----------后台数据完成");
        model.addAttribute("VisitNum", VisitNum);
        model.addAttribute("VisitList", list);
        model.addAttribute("pagingVO", pagingVO);
		
		
		return "admin/VisitShow";
	}
	@RequestMapping(value="/selectVisitor")
	public String FindByName(Model model, Integer page,String username){
		List<Visitor> list = visitService.FindByName(username);
		//System.out.println("访问记录数量："+list.size());
		//页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(list.size());
        //访问记录数量
        int VisitNum=list.size();
       
        // System.out.println("-----------后台数据完成");
        model.addAttribute("VisitNum", VisitNum);
        model.addAttribute("VisitList", list);
        model.addAttribute("pagingVO", pagingVO);
		
		
		return "admin/VisitShow";
	}
	
}
