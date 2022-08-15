package com.kgd.springbootmall.service;

import com.kgd.springbootmall.dto.ProductDTO;
import com.kgd.springbootmall.entity.Products;
import com.kgd.springbootmall.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class SearchService {
    private final SearchRepository searchRepository;

    public List<ProductDTO> selectByURLName(String str){

        List<Products> rtn_Prod = searchRepository.findByName(str);
        List<ProductDTO> rtn_ProdDTO = ListEntitytoDTO(rtn_Prod);

        return rtn_ProdDTO;

    }


    public List<ProductDTO> getContents(){
        List<Products> rtn_prod = searchRepository.getFewProduct();
        List<ProductDTO> rtn_ProdDTO = ListEntitytoDTO(rtn_prod);
        return rtn_ProdDTO;
    }

    public List<ProductDTO> ListEntitytoDTO(List<Products> prods){

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

    public List<Products> ListDTOtoEntity(List<ProductDTO> prodDTO){

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


    public void resetDB(){
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



