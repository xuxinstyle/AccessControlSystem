package com.system.service;

import java.util.Date;
import java.util.List;

import com.system.po.*;
public interface VisitService {
	//添加访问记录
	int saveVisit(User user);
	
	//删除访问记录
	void deleteVisit(String name);
	
	//查询所有访问记录
	List<Visitor> FindAllVisit();
	
	//根据用户名查询访问记录
	List<Visitor> FindByName(String name);
	
	//根据时间段查询访问记录
	//List<Visitor> FindByTimeRange(Date Start,Date end);
	
	//查询大于start的访问记录
	//List<Visitor> FindByTimeAfter(Date Start);
	
	//查询小于end的访问记录
	//List<Visitor> FindByTimeBefore(Date end);
	
	//根据页码查询响应页数的访问记录
	public List<Visitor> findByPagingVisit(Integer toPageNo);

}
