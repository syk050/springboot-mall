package com.kgd.springbootmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.kgd.springbootmall.entity.Tests;

import java.util.Optional;


@Repository
public interface TestRepository extends JpaRepository<Tests, Integer>{
    @Query("select id from Tests id where id.testId = :id")
    Optional<Tests> findById(@Param("id") String id);
    // @Query로 쿼리 전송, @Param으로 매개변수 가져올 별명 지정
    // 파라미터 바인딩 방식에는 위치기반과 이름기반이 있는데, 후자를 더 많이 사용하고 안정적으로 바라본다.
    // @Param을 사용하여 바인딩을 한 것을 이름기반 바인딩이라 한다.
    // @Query는 테이블을 대상으로 쿼리를 날리는 것이 아닌, 엔티티를 대상으로 날린다

    // Optional 클래스는 Null이거나 null이 아닌 값을 담을 수 있는 클래스이다.
    // 그리하여 복잡한 NullPointerException을 피할 수 있다.

    @Override
    <S extends Tests> S save(S entity);
}

