package com.kgd.springbootmall.repository;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemTagRepositoryTest {

    @Autowired
    private ItemTagRepository repository;

    @Test
    @DisplayName("ItemId로 검색 되는지 확인")
    public void findByItemId() {
//        repository.findByItemId(46L).forEach(itemTag -> System.out.println(itemTag));
        repository.findByItemId(46L).forEach(System.out::println);
    }

}