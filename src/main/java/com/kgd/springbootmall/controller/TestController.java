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

        return "helloword " + res.getTestId() + "님, 내용 : " + res.getTestContents();
    }
}

//  --------------------- 도메인 오브젝트(VO, DTO, Entities)------------------
//                                  |
//        --------------------------------------------------
//        |                   |                            |
//  프레젠테이션 계층   -   비지니스 계층     -      데이터 접근(영속성 계층)
//    (Controller)       (Service)  (Repository)      (DAO)

// 프레젠테이션 : 웹 페이지 보여주는 계층
// 비지니스 계층 : 비지니스 로직(다채로운 기능을 구현하는 계층, 카테고리 보여주기, 시간 보여주기 등)
// 데이터 접근 : DB에 접근하여 원하는 데이터를 가져와 비지니스 계층에 제공
// 도메인 오브젝트
//    ㄴ VO : Read Only 객체로, 변화시키지 않기 때문에 getter, setter가 없다.
//    ㄴ DTO : Data Transfer Object로, 웹페이지 쪽으로 보내는 jqeury 형식에 맞춘다고 보면된다.
//    ㄴ Entity : DB 쪽에서 받는 객체로, DB 스키마 구조와 정확히 일치한다고 보면된다.
