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
public class Tests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)                 // mysql은 identity(기본 키 생성을 DB에 위임하는 전략), oracle은 sequence 사용
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
