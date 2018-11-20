package com.github.raphael008.auth.manager.Impl;

import com.github.raphael008.auth.manager.LoginManager;
import com.github.raphael008.model.User;
import com.github.raphael008.model.UserCredential;
import com.github.raphael008.service.UserCredentialService;
import com.github.raphael008.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

@Service
public class LoginManagerImpl implements LoginManager {

    @Autowired
    private UserService userService;

    @Autowired
    private UserCredentialService userCredentialService;

    @Override
    public User login(String userName, String password) throws Exception {
        User user = userService.queryByUserName(userName);
        UserCredential userCredential = userCredentialService.queryByUserId(user.getUserId());

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(password.getBytes());
        byte[] digest = md5.digest();

        String targetHashedPassword = DatatypeConverter.printHexBinary(digest);
        String sourceHashedPassword = userCredential.getUserPassword();
        if (sourceHashedPassword.equals(targetHashedPassword)) {
            return user;
        } else {
            throw new RuntimeException("账号或密码错误，请重新登录。");
        }
    }
}
