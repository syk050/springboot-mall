package com.kgd.springbootmall.service;

import com.kgd.springbootmall.dto.ProductDTO;
import com.kgd.springbootmall.entity.Products;
import com.kgd.springbootmall.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j                                                      // lombok 어노테이션으로 log4j를 편하게 import 하여 사용할 수 있게 한다.
@Service
@Component
@RequiredArgsConstructor
public class SearchService {
    private final SearchRepository searchRepository;
    private Boolean isEmptyBoolean;

    @Transactional
    public List<ProductDTO> selectByURLName(String str, Pageable pageable){                     // url로 query를 받아 검색하는 service 코드

        List<Products> rtn_Prod = searchRepository.findByName(str, pageable);
        isListEmpty(rtn_Prod);

        List<ProductDTO> rtn_ProdDTO = new ArrayList<>();

        if(!isEmptyBoolean)                                     // 데이터 있으면 넣고
            rtn_ProdDTO = ListEntitytoDTO(rtn_Prod);

        return rtn_ProdDTO;

    }


    public List<ProductDTO> getContents(Pageable pageable){                                     // 첫 페이지 로딩할 때 임시로 전체를 가져와서 보여주는 service 코드(임시)
        List<Products> rtn_Prod = searchRepository.getAll(pageable);
        isListEmpty(rtn_Prod);

        List<ProductDTO> rtn_ProdDTO = ListEntitytoDTO(rtn_Prod);
        return rtn_ProdDTO;
    }

    public void isListEmpty(List<Products> prods){                                           // 리턴 값 비어 있는 지 확인, List로 받으면 nulll 이 안들어가고, 비어있는 배열이 들어간다.
        isEmptyBoolean = prods.isEmpty();

        if(!isEmptyBoolean)
            log.info("rtn_Prod", prods);

    }


    public List<ProductDTO> ListEntitytoDTO(List<Products> prods){                              // Entity(DB) 에서 DTO(트랜잭션)으로 변환하는 코드(Controller나 Service 코드로 작성한다.)

        List<ProductDTO> prodDTOList = new ArrayList<>() {};
        ProductDTO tmp;
        for(int i=0; i < prods.size(); i++){
            tmp = new ProductDTO(prods.get(i).getId(),
                    prods.get(i).getName(),
                    prods.get(i).getCategory(),
                    prods.get(i).getPrice(),
                    prods.get(i).getDc_rate(),
                    prods.get(i).getClarif(),
                    prods.get(i).isDeli(),
                    prods.get(i).getColor(),
                    prods.get(i).getSeller());
            prodDTOList.add(tmp);
        }
        return prodDTOList;
    }

    public List<Products> ListDTOtoEntity(List<ProductDTO> prodDTO){                            // DTO(트랜잭션)에서 Entity(DB)로의 변환코드(검색 페이지에서는 사용할 필요가 없다)

        List<Products> prodList = new ArrayList<>() {};
        Products tmp;
        for(int i=0; i < prodDTO.size(); i++){
            tmp = new Products(
                    prodDTO.get(i).getName(),
                    prodDTO.get(i).getCategory(),
                    prodDTO.get(i).getPrice(),
                    prodDTO.get(i).getDc_rate(),
                    prodDTO.get(i).getClarif(),
                    prodDTO.get(i).isDeli(),
                    prodDTO.get(i).getColor(),
                    prodDTO.get(i).getSeller());
            prodList.add(tmp);
        }
        return prodList;
    }


    public void resetDB(){                                                                      // Test 코드에 필요한 Products 테이블 reset service 코드(id속성의 auto_increment를 초기화하고, 테이블 내용을 전체 삭제 한다)
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



