package com.system.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.system.po.PagingVO;
import com.system.po.User;
import com.system.po.Visitor;
import com.system.service.UserFaceService;
import com.system.service.VisitService;
import com.system.service.LoginService;
import com.system.service.SuperService;
@Controller
@RequestMapping(value="/super")
public class SuperController {
	private static Logger logger = Logger.getLogger(SuperController.class);
	@Autowired
	private SuperService superService;
	
	@Autowired
	private UserFaceService userFaceService;
	
	@Autowired
	private VisitService visitService;
	
	@Autowired
	private LoginService loginService;
	/**
	 * 显示用户列表
	 * @param model
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/showUser")
	public String ShowUser(Model model, Integer page) throws Exception{
		logger.info("进入showUser页面---");
		//System.out.println("进入showUser------------");
		List<User> list = null;
	        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(superService.getCountUser());
        int UserNum=superService.getCountUser();
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = superService.findByPagingUser(1);
        } else {
            pagingVO.setToPageNo(page);

            list = superService.findByPagingUser(page);
            //System.out.println("list:"+page);
        }
        //System.out.println("usershow之前1");
        list=superService.checkHaveImage(list);
        //System.out.println("usershow之前2");
        model.addAttribute("UserNum", UserNum);
        model.addAttribute("UserList", list);
        model.addAttribute("pagingVO", pagingVO);
        /**
         * 在前面加redirct:或forward：不经过拦截器  并不会加前缀，后缀
         * 如果需要经过拦截器只要不加redirect:或forward：
         */
		return "super/Usershow";
	}
	/**
	 * 显示管理员列表
	 * @param model
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/showadmin")
	public String Showadmin(Model model, Integer page) throws Exception{
		logger.info("进入showadmin页面----");
		//System.out.println("进入showadmin------------");
		List<User> list = null;
	    //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(superService.getCountAdmin());
        int AdminNum=superService.getCountAdmin();
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = superService.findByPagingadmin(1);
        } else {
            pagingVO.setToPageNo(page);

            list = superService.findByPagingadmin(page);
            //System.out.println("list:"+page);
        }
        //System.out.println("检查之前");
        list=superService.checkHaveImage(list);
        //System.out.println("检查之后");
        model.addAttribute("AdminNum", AdminNum);
        model.addAttribute("UserList", list);
        model.addAttribute("pagingVO", pagingVO);
        /**
         * 在前面加redirct:或forward：不经过拦截器  并不会加前缀，后缀
         * 如果需要经过拦截器只要不加redirect:或forward：
         */
		return "super/adminshow";
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
		if(username!=null){
			Pattern p=Pattern.compile("\\s*|\t|\r|\n");
			Matcher m=p.matcher(username);
			username=m.replaceAll("");
		}
		//System.out.println("username："+username);
		List<User> list = superService.findByName(username);
		//System.out.println("list size:");
		model.addAttribute("UserList", list);
		
		return "super/Usershow";
		
	}
	
	 //  添加用户信息页面显示
    @RequestMapping(value = "/addUser", method = {RequestMethod.GET})
    public String addUserUI(Model model) throws Exception {

        return "super/addUser";
    }
	 //  添加用户信息页面显示
    @RequestMapping(value = "/addAdmin", method = {RequestMethod.GET})
    public String addAdminUI(Model model) throws Exception {

        return "super/addAdmin";
    }
     // 添加用户信息操作
    @RequestMapping(value = "/addUser", method = {RequestMethod.POST})
    public String addUser(User user, Model model) throws Exception {

        Boolean result = superService.save(user);
       
        if (!result) {
            model.addAttribute("message", "用户名重复");
            logger.error("添加用户失败!");
            //System.out.println("添加失败!");
            return "error";
        }
        logger.info("添加用户:"+user.getUsername()+"成功!");
        //System.out.println("添加成功:"+result);
        //重定向
        return "redirect:/super/showUser";
    }
    // 添加用户信息操作
    @RequestMapping(value = "/addAdmin", method = {RequestMethod.POST})
    public String addAdmin(User user, Model model) throws Exception {

        Boolean result = superService.save(user);
       
        if (!result) {
            model.addAttribute("message", "用户名重复");
            logger.error("添加管理员失败!");
            return "error";
        }
        logger.info("添加管理员:"+user.getUsername()+"成功!");
        //System.out.println("添加成功:"+result);
        //重定向
        return "redirect:/super/showadmin";
    }

   

    // 删除用户
    @RequestMapping(value = "/removeUser", method = {RequestMethod.GET} )
    private String removeStudent(Integer page,String username) throws Exception {
        User user = superService.findByPrimaryKey(username);
        superService.removeByPrimaryKey(username);
        
        if(user.getRolename().equals("admin")){
        	return "redirect:/super/showadmin?page="+page;
        }else{
        	return "redirect:/super/showUser?page="+page;
        }
        
        
    }
    /**
     * 修改用户信息页面显示
     * @param model
     * @return
     */
    @RequestMapping(value="/userPasswordRest",method={RequestMethod.GET})
    private String editAdminUI(Model model){
		
    	return "/super/userPasswordRest";
    	
    }
    /**
     * 修改用户信息
     * @param model
     * @return
     * @throws Exception 
     */
    @RequestMapping(value="/userPasswordRest",method={RequestMethod.POST})
    private String editAdmin(User user) throws Exception{
		User u = superService.findByPrimaryKey(user.getUsername());
		u.setPassword(user.getPassword());
    	int i = loginService.updateByPrimaryKey(u);
    	logger.info("用户"+user.getUsername()+"修改密码成功");
    	//System.out.println(u.getPassword());
    	return "/super/userPasswordRest";
    	
    }
    
    // 修改个人信息页面显示
    @RequestMapping(value="/editUser", method = {RequestMethod.GET})
    private String editUserUI(Model model,HttpSession session) throws Exception{
    	User user1=(User)session.getAttribute("user");
    	
    	//System.out.println("登录者："+user1.getUsername());
    	User user = loginService.findByPrimaryKey(user1.getUsername());
    	model.addAttribute("user", user);
    	//System.out.println("马上跳转到/super/editUser");
    	return "/super/editUser";
    }
    // 修改个人信息
    @RequestMapping(value="/editUser", method = {RequestMethod.POST})
    private String editUser(User user) throws Exception{
    	System.out.println(user.getLastopentime());
    	int i = loginService.updateByPrimaryKey(user);
    	//System.out.println(i);
    	logger.info(user.getUsername()+"修改个人信息成功");
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
		//System.out.println("转码前用户名："+username);
		username=new String(username.getBytes("ISO-8859-1"),"UTF-8");
		//System.out.println("转码后用户名："+username);
		userFaceService.getFace(username);
		userFaceService.getFeatures(username);
		User user = superService.findByPrimaryKey(username);
		model.addAttribute("user", user);
		return "/super/success";
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
		
		
		return "super/VisitShow";
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
       
        //System.out.println("-----------后台数据完成");
        model.addAttribute("VisitNum", VisitNum);
        model.addAttribute("VisitList", list);
        model.addAttribute("pagingVO", pagingVO);
		
		
		return "super/VisitShow";
	}
	
}
