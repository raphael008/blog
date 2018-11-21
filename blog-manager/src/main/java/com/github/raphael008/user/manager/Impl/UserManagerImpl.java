package com.github.raphael008.user.manager.Impl;

import com.github.raphael008.model.User;
import com.github.raphael008.model.UserCredential;
import com.github.raphael008.service.UserCredentialService;
import com.github.raphael008.service.UserService;
import com.github.raphael008.user.manager.UserManager;
import com.github.raphael008.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserService userService;

    @Autowired
    private UserCredentialService userCredentialService;

    @Transactional
    @Override
    public Map<String, String> addUser(UserVO vo) {

        SecureRandom random = new SecureRandom();
        String userSalt = BCrypt.gensalt(15, random);

        vo.setUserSalt(userSalt);
        vo.setCreatorId(0L);
        userService.insertSelective(vo);

        Long userId = vo.getUserId();
        String userName = vo.getUserName();
        String password = vo.getPassword();

        String hashedPassword = BCrypt.hashpw(password, userSalt);

        UserCredential credential = new UserCredential();
        credential.setUserId(userId);
        credential.setUserPassword(hashedPassword);
        userCredentialService.insert(credential);

        Map<String, String> userMap = new HashMap<>();
        userMap.put("用户名:", userName);
        userMap.put("密码:", password);
        return userMap;
    }
}
