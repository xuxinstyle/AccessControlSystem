package com.system.service;

import java.util.List;

import com.system.po.User;

public interface LoginService {
    //根据username获取用户信息
    User findByPrimaryKey(String username) throws Exception;

    int updateByPrimaryKey(User user) throws Exception;
}
