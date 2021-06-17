package com.example.web.service.impl;

import com.example.web.bean.User;
import com.example.web.common.base.Response;
import com.example.web.mapper.UserMapper;
import com.example.web.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Response<User> selectUserByUserId(Long userId) {
        User user = userMapper.selectUserByUserId(userId);
        return Response.responseSuccess(user);
    }
}
