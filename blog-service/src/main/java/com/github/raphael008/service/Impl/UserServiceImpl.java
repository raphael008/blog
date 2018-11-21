package com.github.raphael008.service.Impl;

import com.github.raphael008.mapper.UserMapper;
import com.github.raphael008.model.User;
import com.github.raphael008.model.UserCredential;
import com.github.raphael008.service.UserCredentialService;
import com.github.raphael008.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

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
}
