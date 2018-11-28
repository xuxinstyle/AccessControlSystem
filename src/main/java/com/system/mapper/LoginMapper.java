package com.system.mapper;

import com.system.po.User;
import com.system.po.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginMapper {
   
    User selectByPrimaryKey(String username);
    
    int updateByPrimaryKey(User user);
    
    
}