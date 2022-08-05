package com.kgd.springbootmall.repository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import com.kgd.springbootmall.entity.Tests;
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
public class RepositoryTest {

    @Autowired
    private TestRepository testRepository;

    @Test
    public void findIdTest(){
        Integer tmp_id = 10;
        String tmp_content = "안녕하세요";


        Tests tmp_user = new Tests(tmp_id, tmp_content);

        Tests tmp_user2 = testRepository.save(tmp_user);

        Assertions.assertThat(tmp_user).isSameAs(tmp_user2);
    }
}
