package com.github.raphael008.service;

import com.github.raphael008.model.User;

import java.util.List;

public interface UserService extends BaseService<User> {

    User queryByUserId(Long userId);

    User queryByUserName(String userName);

    String queryUserSaltByUserId(Long userId);
}
