package com.github.raphael008.auth.manager.Impl;

import com.github.raphael008.auth.manager.LoginManager;
import com.github.raphael008.common.Environment;
import com.github.raphael008.enums.ClientType;
import com.github.raphael008.model.User;
import com.github.raphael008.model.UserCredential;
import com.github.raphael008.service.UserCredentialService;
import com.github.raphael008.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Service
public class LoginManagerImpl implements LoginManager {

    @Autowired
    private UserService userService;

    @Autowired
    private UserCredentialService userCredentialService;

    @Override
    public User login(HttpServletRequest request, String userName, String password) {

        User user = userService.queryByUserName(userName);
        String userSalt = userService.queryUserSaltByUserId(user.getUserId());
        UserCredential userCredential = userCredentialService.queryByUserId(user.getUserId());

        String sourceHashedPassword = BCrypt.hashpw(password, userSalt);
        String targetHashedPassword = userCredential.getUserPassword();
        if (sourceHashedPassword.equals(targetHashedPassword)) {
            Environment environment = new Environment();
            environment.setUser(user);

            HttpSession session = request.getSession();
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("environment", environment);
            return user;
        } else {
            throw new RuntimeException("账号或密码错误，请重新登录。");
        }
    }

    @Override
    public Boolean checkAuth(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (Objects.isNull(session)) {
            return false;
        }

        Environment environment = (Environment) session.getAttribute("environment");
        if (Objects.isNull(environment)) {
            return false;
        }

        Environment.set(environment);
        return true;
    }

    @Override
    public Boolean checkAuth(HttpServletRequest request, ClientType clientType) {
        Boolean isAuthorized = false;
        switch (clientType) {
            case WEB:
                isAuthorized = checkAuth(request);
                break;
            case APP:
                break;
        }
        return isAuthorized;
    }
}
