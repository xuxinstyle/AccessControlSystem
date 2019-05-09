package com.system.mapper;

import java.util.List;

import com.system.po.PagingVO;
import com.system.po.User;
import com.system.po.Visitor;

public interface VisitPageMapper {

	List<Visitor> findByPaging(PagingVO pagingVO);

	List<Visitor> findByPagingadmin(PagingVO pagingVO);

	List<Visitor> findByPagingUser(PagingVO pagingVO);
	
}
