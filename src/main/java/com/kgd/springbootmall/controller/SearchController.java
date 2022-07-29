package com.kgd.springbootmall.controller;

import com.kgd.springbootmall.dto.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


// 구조 :

// @RESTController는 String만 출력됨(해당 어노테이션 사용 시, @ResponseBody를 생략가능)
// jsp 파일을 출력하기 위해서는 @Contoller를 사용
@Controller
@RequestMapping("/kgd")
public class SearchController {

    @RequestMapping(value ="search", method = RequestMethod.GET)
    public ModelAndView search(){
//		Model : map구조이다. key, value로 저장되며
//		model.addAttribute("변수명", 값)으로 저장한다.
//		url을 리턴하지 않더라도 requstMapping으로 받은 url과 jsp의 이름이 같으면 자동으로 연결시켜준다.
//		하지만, 찾아서 보여주는 구조이기에 return을 하는 것은 아니므로 model에 값을 담아 전달할 수는 없다.

        ModelAndView mv = new ModelAndView("index")
                .addObject("data", "hello");

        return mv;

    }

    @GetMapping("get")
    @ResponseBody                                       // @ResponseBody는 HTTP 규격에 맞는 응답을 만들어주기 위한 Annotation이다.
    public List<Item> vueGet(){
        List<Item> items = new ArrayList<>();           // List는 인터페이스 ArrayList는 클래스
        Item item1 = new Item("aaa", "bbb");
        Item item2 = new Item("ccc", "ddd");
        items.add(item1);
        items.add(item2);
        return items;


//        String result = "Get 결과값 : 성공";
//        return result;
    }

}

// https://febdy.tistory.com/65
// vue 파일을 spring boot 서버로 확인하기 위해서는 npm run build로 늘 빌드해줘야 한다.
// 하지만 바로 확인가능한 방법도 존재한다.


//현재 localhost:8080/kgd/search 접속 시, 빌드 경로에 있는 파일을 볼 수 있게 되었지만
// vue 서버(8081) -> spring 서버(8080) 으로 접속 시, css 및 javascrpt 파일은 404에러가 나는 버그가 있다(현재 수정 중)
