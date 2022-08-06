package com.kgd.springbootmall.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EnableJpaAuditing
@SpringBootApplication
@EntityListeners(AuditingEntityListener.class)
@SequenceGenerator(
        name="GENERATOR",           // 식별자 생성기 이름
        sequenceName = "Gen",       // 데이터베이스에 등록할 sequence명(default = hibernate_seuqence)
        initialValue = 1,           // sequence 초기값
        allocationSize = 1          // 미리 할당 받을 시퀀스 수

)
public class Tests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "GENERATOR")
    @Column(nullable = false)
    private Integer testId;

    @Column(length = 100)
    private String testContents;

    @Builder
    public Tests(Integer testId, String testContents){
        this.testId = testId;
        this.testContents = testContents;
    }

}
