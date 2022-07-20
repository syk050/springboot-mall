package com.kgd.springbootmall.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.bind.annotation.ControllerAdvice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)  // ①
@WebMvcTest(controllers = HelloKTest.class)  // ②
public class HelloKTest {

    @Autowired  // ③
    private MockMvc mvc;  // ④

    @Test
    public void test1() throws Exception{
        String hello = "Hi";

        mvc.perform(get("/test"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
}

/*
① @RunWith(SpringRunner.class)
    - JUnit에 내장된 실행자 외에 다른 실행자를 실행
    - SpringRunner라는 스프링 실핼자를 사용
    - 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 수행

② @WebMvcTest
    - Web(Spring MVC)에 집중한 테스트 어노테이션
    - @Controller, @ControllerAdvice 등 사용 가능
    - @Service, @Component, @Repository 등 사용 불가

*/
