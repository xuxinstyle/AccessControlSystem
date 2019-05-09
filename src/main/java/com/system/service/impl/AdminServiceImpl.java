package com.system.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.system.mapper.AdminMapper;
import com.system.mapper.AdminPageMapper;

import com.system.po.PagingVO;
import com.system.po.User;
import com.system.po.UserExample;
import com.system.po.UserExample.Criteria;
import com.system.service.AdminService;
import com.system.service.RemoveUtilService;
@Service
public class AdminServiceImpl implements AdminService {
	public static Logger logger = LoggerFactory.getLogger("AdminServiceImpl.class");
	
	@Resource
	private AdminMapper adminMapper;
	
	@Resource
	private AdminPageMapper adminPageMapper;
	
	@Resource
	private RemoveUtilService removeUtilService;
	
	@Override
	public List<User> findByPaging(Integer toPageNo) throws Exception {
		PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);
        List<User> list=new ArrayList<User>();
        list = adminPageMapper.findByPaging(pagingVO);

        return list;
	}
	@Override
	public List<User> findByPagingUser(Integer toPageNo) throws Exception {
		PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);
        List<User> list=new ArrayList<User>();
        list = adminPageMapper.findByPagingUser(pagingVO);

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
		//System.out.println(username);
		List<User> list=adminMapper.findByFuzzyName(username);
		//System.out.println(list);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			//System.out.println("搜索："+user.getUsername());
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
		User user = adminMapper.selectByPrimaryKey(username);
		if(user.getImagepath()!=null){
			removeUtilService.RemoveFile(user.getImagepath());
		}
		if(user.getCsvpath()!=null){
			removeUtilService.RemoveFile(user.getCsvpath());
		}
		adminMapper.deleteByPrimaryKey(username);
		
	}

	@Override
	public User findByPrimaryKey(String username) throws Exception {
		System.out.println(username);
		return adminMapper.selectByPrimaryKey(username);
	}
	@Override
	public List<User> checkHaveImage(List<User> list) throws Exception {
		// TODO Auto-generated method stub
		for(User user:list){
			String path = user.getCsvpath();
			//System.out.println(path+"我获得了csv路径");
			if(!checkHavefile(path)){
				//System.out.println(path+"不存在");
				user.setCsvpath(null);;
				updataByPrimaryKey(user.getUsername(), user);
			}
		}
		return list;
	}
	
	boolean checkHavefile(String path){
		
		File file = new File(path);
		if(file.exists()&&file.isDirectory()){
			File filelist[] = file.listFiles();
			for(File f : filelist){
				if(f.exists()){
					String filename = f.getName();
					if(filename.endsWith("csv")){
						logger.info("Existence of csv file : " + f.getAbsolutePath());
						return true;
					}
				}
				
			}
		}
		
		return false;
	}


	

}
