package com.kgd.springbootmall.controller;

import com.kgd.springbootmall.dto.ProductDTO;
import com.kgd.springbootmall.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


// 구조 :

// @RESTController는 String만 출력됨(해당 어노테이션 사용 시, @ResponseBody를 생략가능)
// jsp 파일을 출력하기 위해서는 @Contoller를 사용
@RestController
@RequiredArgsConstructor
@RequestMapping("/kgd")
public class SearchController {

    private final SearchService searchService;

//    @RequestMapping(value ="search", method = RequestMethod.GET)
//    public ModelAndView search(){
////		Model : map구조이다. key, value로 저장되며
////		model.addAttribute("변수명", 값)으로 저장한다.
////		url을 리턴하지 않더라도 requstMapping으로 받은 url과 jsp의 이름이 같으면 자동으로 연결시켜준다.
////		하지만, 찾아서 보여주는 구조이기에 return을 하는 것은 아니므로 model에 값을 담아 전달할 수는 없다.
//
//        ModelAndView mv = new ModelAndView("index")
//                .addObject("data", "hello");
//
//        return mv;
//
//    }
    // 현재는 vue가 이 기능을 하고 있어 필요 없음

    
    
    @RequestMapping(value ="/content", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductDTO> returnContent(){

        List<ProductDTO> list = searchService.getContents();

        return list;
    }
    //content 비동기 갱신용 컨트롤러(페이지 내 재 검색 시, 검색결과를 가져오는 메서드)

    
    
    @GetMapping("/name/{str}")
    public List<ProductDTO> selectByURLVariable(@PathVariable String str){

        List<ProductDTO> rtn_ProdDTO = searchService.selectByURLName(str);

        return rtn_ProdDTO;
    }
    // 이름 매개변수로 1개만 가져오는 메소드( List로 반환하는 이유는 vue에서 변수로 매핑할 때 v-for을 쓰면 속성 개수만큼 반복하기 때문, list로 반환하면 속성이 아닌 return값의 개수만큼 반복)

}






// https://febdy.tistory.com/65
// vue 파일을 spring boot 서버로 확인하기 위해서는 npm run build로 늘 빌드해줘야 한다.
// 하지만 바로 확인가능한 방법도 존재한다.


//현재 localhost:8080/kgd/search 접속 시, 빌드 경로에 있는 파일을 볼 수 있게 되었지만
// vue 서버(8081) -> spring 서버(8080) 으로 접속 시, css 및 javascrpt 파일은 404에러가 나는 버그가 있다(현재 수정 중)
