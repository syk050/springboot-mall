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
import java.util.List;


@Slf4j                                                                                                                  // lombok 어노테이션으로 log4j를 편하게 import 하여 사용할 수 있게 한다.
@Service
@Component
@RequiredArgsConstructor
public class SearchService {
    private final SearchRepository searchRepository;

    @Transactional
    public Page<Products> selectByURLName(String str, Pageable pageable){                                               // url로 query를 받아 검색하는 service 코드
        Page<Products> rtn_Prod = searchRepository.findByName(str, pageable);
        return rtn_Prod;
    }


    public List<ProductDTO> getProductDetail(String s){                                                                 // 첫 페이지 로딩할 때 임시로 전체를 가져와서 보여주는 service 코드(임시)
        List<Products> prod = searchRepository.getProductDetail(s);
        List<ProductDTO> prodDto = entitytoDTOList(prod);

        String rel_items = prod.get(0).getRel_items();
        String[] rel_items_array = getSplit(rel_items);

        prod = searchRepository.getRelProductDetail(rel_items_array);
        prodDto.addAll(entitytoDTOList(prod));
        // json 형식 분화 시까지, 임시로 본 옵션(같은 제품명)과 부 옵션값(관련 아이템)을 나누지 않고 테스트하기 위한 코드이다.

        return prodDto;
    }


    public ProductDTO entitytoDTO(Products prod){                                                                       // Entity(DB) 에서 DTO(트랜잭션)으로 변환하는 코드(Controller나 Service 코드로 작성한다.)

        ProductDTO prodDTO = new ProductDTO(prod.getId(),
                prod.getName(),
                prod.getCategory(),
                prod.getPrice(),
                prod.getDc_rate(),
                prod.getClarif(),
                prod.isDeli(),
                prod.getColor(),
                prod.getSeller(),
                prod.getRel_items());

        return prodDTO;
    }

    public List<ProductDTO> entitytoDTOList(List<Products> prodList){

        List<ProductDTO> dtoList = new ArrayList<>();

        for(int i=0; i<prodList.size(); i++){
            dtoList.add(entitytoDTO(prodList.get(i)));

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



