package com.kgd.springbootmall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloK {

    @GetMapping("/test")
    public String test() {
        return "Hi";
    }  // test
}
