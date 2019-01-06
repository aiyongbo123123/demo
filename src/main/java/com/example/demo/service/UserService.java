package com.example.demo.service;

import com.example.demo.bean.User;

import java.util.List;

public interface UserService {
    /**
     * 根据接口查询所用的用户
     */
    public User findAllUser(int id);
}
