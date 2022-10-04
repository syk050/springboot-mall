package com.kgd.springbootmall.repository;

import com.kgd.springbootmall.entity.seller.Products;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

// repository 테스트 JSQL 코드를 직접 테스트 시, 사용한다.(search 페이지는 insert 문이 필요 없기에 여기서 추가 기능을 담당한다.)

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
public class SearchRepositoryTest {

    @Autowired
    private SearchRepository searchRepository;

    List<Products> prodList;
    Products prod1;

    @Before
    public void beforeTest(){
        searchRepository.deleteAll();
        searchRepository.resetAuto();

        String name = "제품명";
        String category = "카테고리";
        int price = 10000;
        int dc_rate = 10;
        String clarif = "설명";
        boolean deli = true;
        String color = "red";
        String seller = "셀러";
        String rel_items = "3, 4";


//        prod1 = new Products(                                                                                         // 낱개 추가 테스트 코드
//                "제품명", "카테고리", 10000, 10, "설명", true, 2, "셀러"
//        );
        
        
        prodList = new ArrayList<>();

        for (int i=0; i<40; i++)
        {
            prod1 = new Products(name+i, category+i, price, dc_rate, clarif+i, deli, color, seller, rel_items);
            prodList.add(prod1);
        }

        prod1 = new Products("제품명0", category, price, dc_rate, clarif, deli, "blue", seller, rel_items);              // detail 페이지에서 옵션으로 복수 개의 옵션을 가져오기 위한 데이터
        prodList.add(prod1);

    }

    @Test
    public void resetDB(){                                                                                              // DB reset test
        searchRepository.deleteAll();
        searchRepository.resetAuto();
    }


    @Test
    public void insertTest(){                                                                                           // 낱개 추가 테스트 코드
        Products rtn_prods = searchRepository.save(prod1);

        assert(prod1.getName().equals(rtn_prods.getName()));
    }


    @Test
    public void insetListTest(){                                                                                        // 리스트 추가 테스트 코드
        List<Products> list = searchRepository.saveAll(prodList);

        assert(prodList.get(0).getName().equals(list.get(0).getName()));
    }
}
