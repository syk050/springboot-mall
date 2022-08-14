package com.kgd.springbootmall.repository;

import com.kgd.springbootmall.entity.Products;
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

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
public class SearchRepositoryTest {

    @Autowired
    private SearchRepository searchRepository;

    Products prod1;

    @Before
    public void beforeTest(){
        searchRepository.deleteAll();
        searchRepository.resetAuto();

        prod1 = new Products(
                "제품명", "카테고리", 10000, 10, "설명", false, 2, "셀러"
        );


    }

    @Test
    public void insertTest(){
        Products rtn_prods = searchRepository.save(prod1);

        assert(prod1.getName().equals(rtn_prods.getName()));
    }
}
