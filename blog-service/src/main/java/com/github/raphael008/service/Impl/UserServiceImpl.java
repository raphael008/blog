package com.github.raphael008.service.Impl;

import com.github.raphael008.mapper.UserMapper;
import com.github.raphael008.model.User;
import com.github.raphael008.model.UserCredential;
import com.github.raphael008.service.UserCredentialService;
import com.github.raphael008.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserCredentialService userCredentialService;

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

    @Transactional
    @Override
    public int insertSelective(User user) {

        user.setCreatorId(0L);
        int count = super.insertSelective(user);

        String password = user.getPassword();
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md5.update(password.getBytes());
        byte[] digest = md5.digest();

        String hashedPassword = DatatypeConverter.printHexBinary(digest);

        UserCredential userCredential = new UserCredential();
        userCredential.setUserId(user.getUserId());
        userCredential.setUserPassword(hashedPassword);
        userCredentialService.insertSelective(userCredential);
        return count;
    }
}
