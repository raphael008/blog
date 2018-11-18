package com.github.raphael008.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test", produces = "application/json")
public class TestController {

    @GetMapping("hello")
    public String test() {
        return "Hello, world";
    }
}
