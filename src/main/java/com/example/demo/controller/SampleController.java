package com.example.demo.controller;

import com.example.demo.common.annotation.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("SampleController相关的api")
public class SampleController {
    @ApiOperation(value = "home", notes = "home")
    @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String")
    @RequestMapping(value = "/home.do",method = RequestMethod.POST)
    @Log(value = "home",description = "home")
    public String home(String username,String password) {
        String result="controller：Hello " + username;
        System.out.println(result);
        return result;
    }

}
