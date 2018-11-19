package com.github.raphael008.controller;

import com.github.raphael008.model.User;
import com.github.raphael008.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user", produces = "application/json")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("queryByUserId")
    public User queryByUserId(@RequestBody Long userId) {
        User user = userService.queryByUserId(userId);
        return user;
    }
}
