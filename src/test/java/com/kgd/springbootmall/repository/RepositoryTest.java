package com.kgd.springbootmall.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class RepositoryTest {

    @Autowired
    TestRepository testRepository;

    @Test
    public void findIdTest(){
        Integer tmp_id = 10;
        String tmp_content = "안녕하세요";

        com.kgd.springbootmall.entity.Test tmp_user = new com.kgd.springbootmall.entity.Test(tmp_id, tmp_content);

        testRepository.save(tmp_user);
        Optional<com.kgd.springbootmall.entity.Test> tmp_test = testRepository.findById(tmp_user);
    }
}
