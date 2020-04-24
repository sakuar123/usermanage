package com.sakura.usermanage.web.controller;

import com.sakura.usermanage.common.util.JsonResult;
import com.sakura.usermanage.entity.User;
import com.sakura.usermanage.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("测试接口")
@RequestMapping("/user")
public class TestController {
    @Autowired
    private UserService userService;


    @CrossOrigin(origins = "*")
    @RequestMapping("/getUserList")
    public JsonResult<User> getUserList() {
        return userService.getUserList();
    }

    @RequestMapping("/hello")
    @ApiOperation("say Hello")
    public String hello() {
        return "hello,world";
    }
}
