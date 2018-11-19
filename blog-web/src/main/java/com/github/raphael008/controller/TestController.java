package com.github.raphael008.controller;

import com.github.raphael008.model.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test", produces = "application/json")
public class TestController {

    @GetMapping("hello")
    public Test test() {
        Test test = new Test();
        test.setUsername("raphael008");
        test.setPassword("abc1234");
        return test;
    }
}
