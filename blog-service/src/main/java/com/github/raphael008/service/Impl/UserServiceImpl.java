package com.github.raphael008.service.Impl;

import com.github.raphael008.mapper.UserMapper;
import com.github.raphael008.model.User;
import com.github.raphael008.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryByUserId(Long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }

    @Override
    public User queryByUserName(String userName) {
        User user = userMapper.selectByUserName(userName);
        return user;
    }

    @Override
    public String queryUserSaltByUserId(Long userId) {
        String userSalt = userMapper.selectUserSaltByUserId(userId);
        return userSalt;
    }
}
