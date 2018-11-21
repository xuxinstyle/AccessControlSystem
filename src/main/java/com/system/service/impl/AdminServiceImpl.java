package com.system.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.system.mapper.AdminMapper;
import com.system.mapper.AdminPageMapper;

import com.system.po.PagingVO;
import com.system.po.User;
import com.system.po.UserExample;
import com.system.po.UserExample.Criteria;
import com.system.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	
	@Resource
	private AdminMapper adminMapper;
	
	@Resource
	private AdminPageMapper adminPageMapper;
	
	@Override
	public List<User> findByPaging(Integer toPageNo) throws Exception {
		PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);
        List<User> list=new ArrayList<User>();
        list = adminPageMapper.findByPaging(pagingVO);

        return list;
	}

	@Override
	public Boolean save(User user) throws Exception {
		user.setOpennum(0);
		if(adminMapper.insert(user)>=0){
			return true;
		}else{
			return false;
		} 
	}

	@Override
	public int getCountUser() throws Exception {
		UserExample userExample=new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andUsernameIsNotNull();
		return adminMapper.countByExample(userExample);
	}

	

	@Override
	public List<User> findByName(String username) throws Exception {
		System.out.println(username);
		List<User> list=adminMapper.findByFuzzyName(username);
		System.out.println(list);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			System.out.println("搜索："+user.getUsername());
		}
		return list;
	}

	@Override
	public void updataByPrimaryKey(String username, User user) throws Exception {
		user.setUsername(username);
		adminMapper.updateByPrimaryKey(user);
		
	}

	@Override
	public void removeByPrimaryKey(String username) throws Exception {
		adminMapper.deleteByPrimaryKey(username);
		
	}

	@Override
	public User findByPrimaryKey(String username) throws Exception {
		
		return adminMapper.selectByPrimaryKey(username);
	}

}
