package com.system.service.impl;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.mapper.SuperMapper;
import com.system.mapper.SuperPageMapper;
import com.system.mapper.UserPageMapper;
import com.system.po.PagingVO;
import com.system.po.User;
import com.system.po.UserExample;
import com.system.po.UserExample.Criteria;
import com.system.service.RemoveUtilService;
import com.system.service.SuperService;

@Service
public class SuperServiceImpl implements SuperService {
	
	public static Logger logger = Logger.getLogger(SuperServiceImpl.class);
	
	@Resource
	private SuperMapper superMapper;
	
	@Resource
	private SuperPageMapper superPageMapper;
	
	@Resource
	private RemoveUtilService removeUtilService;
	
	@Override
	public List<User> findByPaging(Integer toPageNo) throws Exception {
		PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<User> list = superPageMapper.findByPaging(pagingVO);
        return list;
	}
	@Override
	public List<User> findByPagingadmin(Integer toPageNo) throws Exception {
		PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<User> list = superPageMapper.findByPagingadmin(pagingVO);
        return list;
	}
	@Override
	public List<User> findByPagingUser(Integer toPageNo) throws Exception {
		PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<User> list = superPageMapper.findByPagingUser(pagingVO);
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
	public int getCountAdmin() throws Exception {
		UserExample userExample=new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andUsernameIsNotNull();
		return superMapper.countAdminByExample(userExample);
	}

	@Override
	public List<User> findByName(String username) throws Exception {
		//System.out.println(username);
		List<User> list=superMapper.findByFuzzyName(username);
		//System.out.println("list:"+list);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			//System.out.println("搜索："+user.getUsername());
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
		User user = superMapper.selectByPrimaryKey(username);
		if(user.getImagepath()!=null){
			removeUtilService.RemoveFile(user.getImagepath());
		}
		if(user.getCsvpath()!=null){
			removeUtilService.RemoveFile(user.getCsvpath());
		}
		superMapper.deleteByPrimaryKey(username);
		logger.info("删除："+username+"成功！");
	}

	@Override
	public User findByPrimaryKey(String username) throws Exception {
		
		return superMapper.selectByPrimaryKey(username);
	}
	@Override
	public List<User> checkHaveImage(List<User> list) throws Exception {
		for(User user:list){
			String path = user.getCsvpath();
			//System.out.println(path+"我获得了csv路径");
			if(path==null||path.equals("")) return list;
			if(!checkHavefile(path)){
				user.setCsvpath(null);;
				
				//System.out.println(path+"不存在");
				updataByPrimaryKey(user.getUsername(), user);
			}
			//System.out.println(user.getUsername()+"循环");
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
