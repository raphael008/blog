package com.github.raphael008.controller;

import com.github.raphael008.model.Test;
import com.github.raphael008.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/test", produces = "application/json")
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("hello")
    public Test test() {
        Test test = new Test();
        test.setUsername("raphael008");
        test.setPassword("abc1234");
        return test;
    }

    @GetMapping("user")
    private List<User> user() {
//        List<User> users = userMapper.select();
        List<User> users = userService.getAllUsers();
        return users;
    }
}
