package com.kgd.springbootmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.kgd.springbootmall.entity.Test;

import java.util.Optional;


@Repository
public interface TestRepository extends JpaRepository<Test, Integer>{
    @Query("select id from Test id where id.testId = :id")
    Optional<Test> findById(@Param("id") Integer id);
    // @Query로 쿼리 전송, @Param으로 매개변수 가져올 별명 지정
    // 파라미터 바인딩 방식에는 위치기반과 이름기반이 있는데, 후자를 더 많이 사용하고 안정적으로 바라본다.
    // @Param을 사용하여 바인딩을 한 것을 이름기반 바인딩이라 한다.
    // @Query는 테이블을 대상으로 쿼리를 날리는 것이 아닌, 엔티티를 대상으로 날린다
}

