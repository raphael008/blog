package com.github.raphael008.auth.manager;

import com.github.raphael008.model.User;

import javax.servlet.http.HttpServletRequest;

public interface LoginManager {

    User login(HttpServletRequest request, String userName, String password) throws Exception;
}
