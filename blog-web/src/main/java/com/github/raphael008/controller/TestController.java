package com.github.raphael008.controller;

import com.github.raphael008.enums.BlockStatus;
import com.github.raphael008.enums.Gender;
import com.github.raphael008.model.Test;
import com.github.raphael008.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/test", produces = "application/json")
public class TestController {

    @Autowired
    private UserService userService;

    @PostMapping("test")
    private Test test() {
        Test test = new Test();
        test.setUsername("raphael008");
        test.setPassword("123456");
        test.setGender(Gender.MALE);
        test.setBlockStatus(BlockStatus.NO);
        return test;
    }

    @PostMapping("deserialize")
    public void deserialize(@RequestBody Test test) {
        System.out.println();
    }
}
