package com.kgd.springbootmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


// REST @Controller는 String만 출력됨
// jsp 파일을 출력하기 위해서는 @Contoller를 사용
@Controller
@RequestMapping("/")
public class SearchController {

    @RequestMapping(value ="search", method = RequestMethod.GET)
    public ModelAndView search(){
//		Model : map구조이다. key, value로 저장되며
//		model.addAttribute("변수명", 값)으로 저장한다.
//		url을 리턴하지 않더라도 requstMapping으로 받은 url과 jsp의 이름이 같으면 자동으로 연결시켜준다.
//		하지만, 찾아서 보여주는 구조이기에 return을 하는 것은 아니므로 model에 값을 담아 전달할 수는 없다.

        ModelAndView mv = new ModelAndView("search-page")
                .addObject("data", "hello");

        return mv;

    }

}
