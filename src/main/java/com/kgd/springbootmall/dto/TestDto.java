package com.kgd.springbootmall.dto;


import com.sun.istack.NotNull;
import lombok.*;


// !!!!!!!!!!!!!!!!!!!! 제일 중요 lombok 어노테이션 자동 생성 기능을 사용하려면
//                      lombok 플러그인 다운받고, 파일 -> 설정 -> 빌드,실행,배포 -> 컴파일러 -> 어노테이션 프로세서 -> 어노테이션 처리 활성화
//@Data                                   //@Getter + @Setter + @toString + @equals  + @hashcode 자동구현
@Getter
@Setter
@AllArgsConstructor
public class TestDto {

    @NotNull
    private Integer testId;
    @NotNull
    private String testContents;

}
