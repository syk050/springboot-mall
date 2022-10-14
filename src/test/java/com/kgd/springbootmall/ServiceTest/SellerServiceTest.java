package com.kgd.springbootmall.ServiceTest;

import com.kgd.springbootmall.repository.ColorRepository;
import com.kgd.springbootmall.repository.ProductRepository;
import com.kgd.springbootmall.service.SearchService;
import com.kgd.springbootmall.service.SellerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
public class SellerServiceTest {

    @Autowired
    private SellerService sellerService;



    @Before
    public void beforeTest(){
        sellerService.resetDB();


    }

    @Test
    public void test(){

        sellerService.insertData();

    }
}

