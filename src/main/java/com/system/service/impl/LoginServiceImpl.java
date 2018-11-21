package com.system.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.mapper.LoginMapper;
import com.system.mapper.SuperMapper;
import com.system.mapper.UserPageMapper;
import com.system.po.PagingVO;
import com.system.po.User;
import com.system.po.UserExample;
import com.system.po.UserExample.Criteria;
import com.system.service.LoginService;
import com.system.service.SuperService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Resource
	private LoginMapper loginMapper;
	
	@Override
	public User findByPrimaryKey(String username) throws Exception {
		
		return loginMapper.selectByPrimaryKey(username);
	}

	@Override
	public int updateByPrimaryKey(User user) throws Exception {
		return loginMapper.updateByPrimaryKey(user);
	}
}
