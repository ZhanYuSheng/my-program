package com.example.web.mapper;

import com.example.web.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User selectUserByUserId(@Param("id") Long id);

}
