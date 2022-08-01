package com.kgd.springbootmall.controller;


import com.kgd.springbootmall.dto.TestDto;
import com.kgd.springbootmall.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kgd/test")
public class TestController {
    private final TestService testService;

    @GetMapping("/{str}")
    public String test(@PathVariable String str){
        TestDto res = testService.testServiceMethod(str);

        return "hello" + res.getTestStr();
    }
}
