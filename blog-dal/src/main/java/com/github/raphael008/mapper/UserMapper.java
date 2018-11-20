package com.github.raphael008.mapper;

import com.github.raphael008.model.User;

/**
* Created by Mybatis Generator 2018/11/20
*/
public interface UserMapper extends BaseMapper<User> {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}