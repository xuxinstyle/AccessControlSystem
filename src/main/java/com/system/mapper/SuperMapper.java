package com.system.mapper;

import com.system.po.User;
import com.system.po.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SuperMapper {
    int countByExample(UserExample example);
    
    int countAdminByExample(UserExample example);
    
    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String username);

    int insert(User user);

    int insertSelective(User user);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("user") User record, @Param("example") UserExample example);

    int updateByExample(@Param("user") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);
    
    List<User> findByFuzzyName(String username);
}