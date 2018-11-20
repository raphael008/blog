package com.github.raphael008.controller;

import com.github.raphael008.auth.manager.LoginManager;
import com.github.raphael008.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("web")
public class WebController {

    @Autowired
    private LoginManager loginManager;

    @PostMapping("login")
    public User login(@RequestBody Map<String, String> params) {
        try {
            User user = loginManager.login(params.get("userName"), params.get("password"));
            return user;
        } catch (Exception e) {
            throw new RuntimeException("登陆失败。");
        }
    }
}
