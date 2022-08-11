package com.kgd.springbootmall.repository;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import com.kgd.springbootmall.entity.Tests;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
public class RepositoryCodeTest {

    @Autowired
    private TestRepository testRepository;

    @Before
    public void beforeTest(){
        testRepository.deleteAll();
        testRepository.resetAuto();
    }

    @Test
    public void insertTests(){
        Integer tmp_id = 1;
        String tmp_content = "안녕하세요";



        Tests tmp_user = new Tests(tmp_content);                    // 객체
        Tests tmp_user2 = testRepository.save(tmp_user);            // DB에 저장하면서 결과로 가져온 객체
        Tests tmp_user3 = testRepository.findById(tmp_id);          // id로 select 문을 써서 가져온 객체

        Assertions.assertThat(tmp_user.getTestId()).isEqualTo(tmp_user2.getTestId());
    }
    // repository에 객체 하나 넣어보기
    
    
    @Test
    public void insertTwoTests(){
        Tests testUser1 = new Tests("첫 번째 입니다.");
        Tests testUser2 = new Tests("두 번째 입니다.");
        List<Tests> userList = Arrays.asList(testUser1, testUser2);


        List<Tests> savedUserList = testRepository.saveAll(userList);


        Assertions.assertThat(userList.get(1).getTestContents()).isEqualTo(savedUserList.get(1).getTestContents());
        
    }
    // 두개 이상 넣어보기
}
