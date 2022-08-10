package com.kgd.springbootmall.service;


import com.kgd.springbootmall.dto.TestDto;
import com.kgd.springbootmall.entity.Tests;
import com.kgd.springbootmall.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public TestDto testServiceMethod(String str){
        Tests tests = new Tests(str);

        testRepository.deleteAll();
        testRepository.resetAuto();

        Tests return_tests = testRepository.save(tests);
        TestDto testDto = new TestDto(return_tests.getTestId(), return_tests.getTestContents());

        return testDto;
    }


    public List<TestDto> insertListService(String str){
        Tests tests = new Tests(str);
        Tests tests2 = new Tests(str + " 두 번째");

        List<Tests> testUserList = Arrays.asList(tests, tests2);

        testRepository.deleteAll();
        testRepository.resetAuto();

        List<Tests> return_tests = testRepository.saveAll(testUserList);

        List<TestDto> testDtos = ListEntitytoDTO(return_tests);

        return testDtos;
    }

    public List<TestDto> ListEntitytoDTO(List<Tests> tests){

        List<TestDto> testDtos = new ArrayList<>() {};
        TestDto tmp;
        for(int i=0; i < tests.size(); i++){
            tmp = new TestDto(i, tests.get(i).getTestContents());
            testDtos.add(tmp);
        }

        return testDtos;


    }





}


// DAO와 Repository의 차이점
// DAO : 데이터 퍼시스턴스의 추상화이다. 테이블 중심의 데이터베이스와 가깝게 고려 된다.(CRUD 제공)
// Repositoy : 도메인 레이어에 속하는 존재, 객체 컬렉션의 추상화, 여러 DAO를 통해 데이터를 가져와 도메인 객체를 만들어 제공하는 것이 역할이다.

// Service와 Repository의 차이점
// 본래 Service 계층이 해야하는 기능인 DAO에  접근하는 기능을 모듈화 시킨 것이 Repository이다.
// 그리하여, DB에 밀접한 접근 기능을 service 계층이 repository에 전부 위임했다 보면 된다.


