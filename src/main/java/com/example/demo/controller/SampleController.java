package com.example.demo.controller;

import com.example.demo.common.annotation.Log;
import com.example.demo.utils.HttpClientUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api("SampleController相关的api")
public class SampleController {
    @Value("${baseurl}")
    private String baseurl;
    @ApiOperation(value = "home", notes = "home")
    @ApiImplicitParams({ @ApiImplicitParam(name = "username", value = "姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    @RequestMapping(value = "/home.do",method = RequestMethod.POST)
    @Log(value = "home",description = "home")
    public String home(String username,String password) {
//        String result="controller：Hello " + username;
        String url=baseurl+"/sys/login/restful.do";
        Map<String,String> map=new HashMap<>();
        username=username.trim();
        password=password.trim();
        map.put("username",username);
        map.put("password",password);
        String result=HttpClientUtil.doPost(url,map);
        System.out.println(result);
        return result;
    }

}
