package com.kgd.springbootmall.controller;

import com.kgd.springbootmall.dto.ProductDTO;
import com.kgd.springbootmall.entity.Products;
import com.kgd.springbootmall.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


// 구조 :

                                                                                                                        // @RESTController는 String만 출력됨(해당 어노테이션 사용 시, @ResponseBody를 생략가능)
                                                                                                                        // jsp 파일을 출력하기 위해서는 @Contoller를 사용
@RestController
@RequiredArgsConstructor
@RequestMapping("/kgd")
public class SearchController {
    private final SearchService searchService;

    @GetMapping("/name")
    public Page<ProductDTO> selectProducts(@RequestParam String query, @PageableDefault(page = 0, size=6, sort="id", direction = Sort.Direction.ASC) Pageable pageable){
        Page<ProductDTO> rtn_ProdDTO = searchService.getByName(query, pageable);
        return rtn_ProdDTO;
    }
                                                                                                                        // Paging 처리를 수월하게 하기 위해 page의 변수가 담길 수 있는 Page 객체열로 반환한다.                                                                                                                    // 이름 매개변수로 1개만 가져오는 메소드( Page로 반환하는 이유는 vue에서 변수로 매핑할 때 v-for을 쓰면 속성 개수만큼 반복하기 때문, Page로 반환하면 속성이 아닌 return값의 개수만큼 반복)
                                                                                                                        // url로 가져오는 매개변수를 보고 싶다면, 아래의 url 검색
                                                                                                                        // http://127.0.0.1:8081/kgd/name?query=제품명&page=1


    @GetMapping("/detail")
    public Map<String, List<ProductDTO>> selectProductDetail(@RequestParam String query){
        Map<String, List<ProductDTO>> prodDetail = searchService.getProductDetail(query);
        return prodDetail;
    }


}
