package com.kgd.springbootmall.dto;

import lombok.Getter;
import lombok.Setter;

public class TestDto {

    @Getter
    @Setter
    private String testStr;

    public TestDto(String testStr){
        this.testStr = testStr;
    }
}
