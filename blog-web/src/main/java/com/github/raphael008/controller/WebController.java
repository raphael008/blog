package com.github.raphael008.controller;

import com.github.raphael008.auth.manager.LoginManager;
import com.github.raphael008.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("web")
public class WebController {

    @Autowired
    private LoginManager loginManager;

    @Autowired
    FindByIndexNameSessionRepository sessionRepository;

    @PostMapping("login")
    public User login(HttpServletRequest request, @RequestBody Map<String, String> params) {
        try {
            User user = loginManager.login(request, params.get("userName"), params.get("password"));
            return user;
        } catch (Exception e) {
            throw new RuntimeException("登录失败。");
        }
    }

    @PostMapping("session")
    public void session() {
        Map test = sessionRepository.findByIndexNameAndIndexValue(FindByIndexNameSessionRepository.PRINCIPAL_NAME_INDEX_NAME, "test");
        Session a = sessionRepository.findById("a");
        System.out.println();
    }
}
