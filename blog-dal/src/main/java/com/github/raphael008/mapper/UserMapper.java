package com.github.raphael008.mapper;

import com.github.raphael008.model.User;import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 2018/11/20
*/
public interface UserMapper extends BaseMapper<User> {

    User selectByUserName(@Param("userName") String userName);
}