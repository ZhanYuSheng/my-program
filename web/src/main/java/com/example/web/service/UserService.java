package com.example.web.service;

import com.example.web.bean.User;
import com.example.web.common.base.Response;
import org.springframework.stereotype.Service;

public interface UserService {

    Response<User> selectUserByUserId(Long userId);

}
