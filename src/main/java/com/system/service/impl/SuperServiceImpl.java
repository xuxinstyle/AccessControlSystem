package com.system.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.mapper.SuperMapper;
import com.system.mapper.SuperPageMapper;
import com.system.mapper.UserPageMapper;
import com.system.po.PagingVO;
import com.system.po.User;
import com.system.po.UserExample;
import com.system.po.UserExample.Criteria;
import com.system.service.SuperService;

@Service
public class SuperServiceImpl implements SuperService {
	
	@Resource
	private SuperMapper superMapper;
	
	@Resource
	private SuperPageMapper superPageMapper;
	
	@Override
	public List<User> findByPaging(Integer toPageNo) throws Exception {
		PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<User> list = superPageMapper.findByPaging(pagingVO);
        return list;
	}

	@Override
	public Boolean save(User user) throws Exception {
		user.setOpennum(0);
		if(superMapper.insert(user)>=0){
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
		return superMapper.countByExample(userExample);
	}

	

	@Override
	public List<User> findByName(String username) throws Exception {
		System.out.println(username);
		List<User> list=superMapper.findByFuzzyName(username);
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
		superMapper.updateByPrimaryKey(user);
		
	}

	@Override
	public void removeByPrimaryKey(String username) throws Exception {
		superMapper.deleteByPrimaryKey(username);
		
	}

	@Override
	public User findByPrimaryKey(String username) throws Exception {
		
		return superMapper.selectByPrimaryKey(username);
	}

}
