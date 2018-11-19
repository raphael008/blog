package com.github.raphael008.service;

import com.github.raphael008.model.User;

import java.util.List;

public interface UserService {
    User queryByUserId(Long userId);
}
