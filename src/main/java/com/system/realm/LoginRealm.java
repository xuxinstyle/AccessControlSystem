package com.system.realm;

import com.system.mapper.SuperMapper;
import com.system.po.User;
import com.system.service.LoginService;
import com.system.service.SuperService;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;


/**
 * Created by Jacey on 2017/6/30.
 */

@Component
public class LoginRealm extends AuthorizingRealm{

    @Resource(name = "loginServiceImpl")
    private LoginService loginService;

    /*@Resource(name = "roleServiceImpl")
    private RoleService roleService;*/

    /**
     * 获取身份信息，我们可以在这个方法中，从数据库获取该用户的权限和角色信息
     *     当调用权限验证时，就会调用此方法
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
	

        String username = (String) getAvailablePrincipal(principalCollection);
       
		try {
			User user = loginService.findByPrimaryKey(username);
			//通过用户名从数据库获取权限/角色信息
	        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
	        Set<String> r = new HashSet<String>();
	        if (user.getRolename()!= null) {
	            r.add(user.getRolename());
	            info.setRoles(r);
	        }

	        return info;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
        
        
    }

    /**
     * 在这个方法中，进行身份验证
     *         login时调用
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //用户名
        String username = (String) token.getPrincipal();
        //密码
        String password = new String((char[])token.getCredentials());

        User user = null;
        try {
        	//System.out.println("查询用户");
            user = loginService.findByPrimaryKey(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user == null) {
        	//System.out.println("没有该用户名！");
            //没有该用户名
            throw new UnknownAccountException();
        } else if (!password.equals(user.getPassword())) {
            //密码错误
        	//System.out.println("密码错误！");
            throw new IncorrectCredentialsException();
        }

        //身份验证通过,返回一个身份信息
        AuthenticationInfo aInfo = new SimpleAuthenticationInfo(username,password,getName());

        return aInfo;
    }
}
