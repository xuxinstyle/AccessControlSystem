package com.system.mapper;

import java.util.List;

import com.system.po.PagingVO;
import com.system.po.User;

public interface SuperPageMapper {

	List<User> findByPaging(PagingVO pagingVO);
	
}
