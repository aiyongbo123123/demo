package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController/**自动返回的是json格式数据***/
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public User list(int id){
        User list = userService.findAllUser(id);
        return list;
    }
}