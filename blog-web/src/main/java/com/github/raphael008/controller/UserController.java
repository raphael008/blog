package com.github.raphael008.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.raphael008.enums.BlockStatus;
import com.github.raphael008.enums.Gender;
import com.github.raphael008.model.Test;
import com.github.raphael008.model.User;
import com.github.raphael008.serializer.BaseEnumSerializer;
import com.github.raphael008.service.UserService;
import jdk.nashorn.internal.ir.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping("queryAllUsers")
    public List<User> queryAllUsers() {
        List<User> users = userService.selectList();
        return users;
    }
}
