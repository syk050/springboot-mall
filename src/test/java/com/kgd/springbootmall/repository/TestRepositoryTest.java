package com.kgd.springbootmall.repository;

import com.kgd.springbootmall.entity.Items;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestRepositoryTest {

    @Autowired
    private TestRepository repository;

    @Test
    @DisplayName("상품 정보와 태그까지 가져와짐")
    public void getItemAndTag() {
//        repository.findById(1000L);
//        repository.findOne(1000L);
//        System.out.println(repository.findById(46L));
        Items temp = new Items();
        temp.setId(1000L);
//        repository.findOne(temp.getId());
    }

}
