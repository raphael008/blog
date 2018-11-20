package com.github.raphael008.auth.manager;

import com.github.raphael008.model.User;

public interface LoginManager {

    User login(String userName, String password) throws Exception;
}
