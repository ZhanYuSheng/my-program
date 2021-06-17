package com.example.web.controller;

import com.example.web.bean.User;
import com.example.web.common.base.Response;
import com.example.web.common.params.UserParam;
import com.example.web.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/getById")
    public Response<User> getUserByUserId(@RequestBody UserParam userParam){
        return userService.selectUserByUserId(userParam.getId());
    }

}
