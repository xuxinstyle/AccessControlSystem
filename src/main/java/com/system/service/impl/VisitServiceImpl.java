package com.system.service.impl;

import java.util.Date;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.system.mapper.VisitPageMapper;
import com.system.mapper.VisitorMapper;
import com.system.po.PagingVO;
import com.system.po.User;
import com.system.po.Visitor;
import com.system.po.VisitorExample;
import com.system.po.VisitorExample.Criteria;
import com.system.service.VisitService;

@Service
public class VisitServiceImpl implements VisitService {

	@Resource
	private VisitorMapper visitorMapper;
	@Resource
	private VisitPageMapper visitPageMapper;
	@Override
	public int saveVisit(User user) {
		Visitor visitor=new Visitor();
		visitor.setVname(user.getUsername());
		visitor.setVtime(user.getLastopentime());
		return visitorMapper.insert(visitor);
	}

	@Override
	public void deleteVisit(String name) {
		// TODO Auto-generated method stub
		VisitorExample visitorExample=new VisitorExample();
		Criteria criteria = visitorExample.createCriteria();
		criteria.andVnameEqualTo(name);
		visitorMapper.deleteByExample(visitorExample);
	}

	@Override
	public List<Visitor> FindAllVisit() {
		// TODO Auto-generated method stub
		VisitorExample visitorExample=new VisitorExample();
		Criteria criteria = visitorExample.createCriteria();
		return visitorMapper.selectByExample(visitorExample);
	}

	@Override
	public List<Visitor> FindByName(String name) {
		// TODO Auto-generated method stub
		visitorMapper.selectByPrimaryKey(name);
		return visitorMapper.findByFuzzyName(name);
	}

	/*@Override
	public List<Visitor> FindByTimeRange(Date Start, Date end) {
		
		return visitorMapper.selectByTimeRange(Start, end);
	}*/

	/*@Override
	public List<Visitor> FindByTimeAfter(Date Start) {
		// TODO Auto-generated method stub
		return visitorMapper.selectByTimeAfter(Start);
	}*/

	/*@Override
	public List<Visitor> FindByTimeBefore(Date end) {
		// TODO Auto-generated method stub
		return visitorMapper.selectByTimeBefore(end);
	}*/
	
	@Override
	public List<Visitor> findByPagingVisit(Integer toPageNo) {
		PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);
        
        List<Visitor> list = visitPageMapper.findByPagingadmin(pagingVO);
        return list;
	}

	

}
