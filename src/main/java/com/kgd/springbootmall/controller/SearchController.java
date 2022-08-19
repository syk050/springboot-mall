package com.kgd.springbootmall.controller;

import com.kgd.springbootmall.dto.ProductDTO;
import com.kgd.springbootmall.entity.Products;
import com.kgd.springbootmall.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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
    public List<ProductDTO> returnContent(@PageableDefault(size=6, sort="id", direction = Sort.Direction.ASC) Pageable pageable){

        List<ProductDTO> list = searchService.getContents(pageable);

        return list;
    }
    // 페이지 초기화 및 content 비동기 갱신용 컨트롤러(페이지 내 재 검색 시, 검색결과를 가져오는 메서드)

    
    
    @GetMapping("/name")
    public List<ProductDTO> selectByURLVariable(@RequestParam String query, @PageableDefault(page = 0, size=2, sort="id", direction = Sort.Direction.ASC) Pageable pageable){

        List<ProductDTO> rtn_ProdDTO = searchService.selectByURLName(query, pageable);


        return rtn_ProdDTO;
    }
    // 이름 매개변수로 1개만 가져오는 메소드( List로 반환하는 이유는 vue에서 변수로 매핑할 때 v-for을 쓰면 속성 개수만큼 반복하기 때문, list로 반환하면 속성이 아닌 return값의 개수만큼 반복)
    // url로 가져오는 매개변수를 보고 싶다면, 아래의 url 검색
    // http://127.0.0.1:8081/kgd/name?query=제품명&page=1


}
