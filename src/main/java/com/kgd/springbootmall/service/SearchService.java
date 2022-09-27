package com.kgd.springbootmall.service;

import com.kgd.springbootmall.dto.ProductDTO;
import com.kgd.springbootmall.entity.Products;
import com.kgd.springbootmall.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j                                                                                                                  // lombok 어노테이션으로 log4j를 편하게 import 하여 사용할 수 있게 한다.
@Service
@Component
@RequiredArgsConstructor
public class SearchService {
    private final SearchRepository searchRepository;

    @Transactional
    public Page<ProductDTO> getByName(String str, Pageable pageable){                                               // url로 query를 받아 검색하는 service 코드
        Page<Products> rtn_Prod = searchRepository.findByName(str, pageable);
        return new ProductDTO().toDTOPage(rtn_Prod);
    }


    public Map<String, List<ProductDTO>> getProductDetail(String s){
        Map<String, List<ProductDTO>> prodMap = new HashMap<>();                                                        // 본 아이템 옵션과 서브 아이템 옵션을 리턴시키는 메서드
        List<Products> prod;
        List<ProductDTO> prodDto;

        prod = searchRepository.getProductDetail(s);                                                     
        prodDto = entitytoDTOList(prod, 0);
        prodMap.put("realItems", prodDto);


        String rel_items = prod.get(0).getRel_items();
        String[] rel_items_array = getSplit(rel_items);

        prod = searchRepository.getRelProductDetail(rel_items_array);
        prodDto = entitytoDTOList(prod, 1);
        prodMap.put("subItems", prodDto);


        return prodMap;
    }


    public List<ProductDTO> entitytoDTOList(List<Products> prodList, int bool){

        List<ProductDTO> dtoList = new ArrayList<>();

        if(bool==0){                                                                                                    // realDTO Translate
            for(int i=0; i<prodList.size(); i++)
                dtoList.add(new ProductDTO().toDTO(prodList.get(i)));
        } else if (bool==1) {                                                                                           // subDTO Translate
            for(int i=0; i<prodList.size(); i++)
                dtoList.add(new ProductDTO().toSubDTO(prodList.get(i)));
        }

        return dtoList;
    }


    public void isSecureInputData(String s){

    }

    public String[] getSplit(String s){

        String[] array = s.split(",");
        return array;
    }



    public void resetDB(){                                                                                              // Test 코드에 필요한 Products 테이블 reset service 코드(id속성의 auto_increment를 초기화하고, 테이블 내용을 전체 삭제 한다)
        searchRepository.deleteAll();
        searchRepository.resetAuto();
    }

}


// DAO와 Repository의 차이점
// DAO : 데이터 퍼시스턴스의 추상화이다. 테이블 중심의 데이터베이스와 가깝게 고려 된다.(CRUD 제공)
// Repositoy : 도메인 레이어에 속하는 존재, 객체 컬렉션의 추상화, 여러 DAO를 통해 데이터를 가져와 도메인 객체를 만들어 제공하는 것이 역할이다.

// Service와 Repository의 차이점
// 본래 Service 계층이 해야하는 기능인 DAO에  접근하는 기능을 모듈화 시킨 것이 Repository이다.
// 그리하여, DB에 밀접한 접근 기능을 service 계층이 repository에 전부 위임했다 보면 된다.



