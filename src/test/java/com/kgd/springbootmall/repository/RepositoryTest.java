package com.kgd.springbootmall.repository;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.kgd.springbootmall.entity.Tests;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
public class RepositoryTest {

    @Autowired
    private TestRepository testRepository;

    @Before
    public void beforeTest(){
        testRepository.deleteAll();
        testRepository.resetAuto();
    }

    @Test
    public void findIdTest(){
        Integer tmp_id = 1;
        String tmp_content = "안녕하세요";



        Tests tmp_user = new Tests(tmp_id, tmp_content);

        Tests tmp_user2 = testRepository.save(tmp_user);

        Tests tmp_user3 = testRepository.findById(tmp_id);

        Assertions.assertThat(tmp_user.getTestId()).isEqualTo(tmp_user2.getTestId());
    }
}
