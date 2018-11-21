package com.system.service;

import java.util.List;

import com.system.po.User;

public interface SuperService {
	 //根据id个更新用户信息
    void updataByPrimaryKey(String username, User user) throws Exception;

    //根据id删除用户信息
    void removeByPrimaryKey(String username) throws Exception;

    //获取分页查询用户信息
    List<User> findByPaging(Integer toPageNo) throws Exception;

    //保存用户信息
    Boolean save(User user) throws Exception;

    //获取用户总数
    int getCountUser() throws Exception;

    //根据username获取用户信息
    User findByPrimaryKey(String username) throws Exception;

    //根据名字模糊查询
    List<User> findByName(String username) throws Exception;

}
