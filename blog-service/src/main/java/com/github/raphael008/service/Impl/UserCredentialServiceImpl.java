package com.github.raphael008.service.Impl;

import com.github.raphael008.mapper.UserCredentialMapper;
import com.github.raphael008.model.UserCredential;
import com.github.raphael008.service.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialServiceImpl extends BaseServiceImpl<UserCredential> implements UserCredentialService {

    @Autowired
    private UserCredentialMapper userCredentialMapper;

    @Override
    public UserCredential queryByUserId(Long userId) {
        UserCredential userCredential = userCredentialMapper.selectByUserId(userId);
        return userCredential;
    }
}
