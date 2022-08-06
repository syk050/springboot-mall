package com.kgd.springbootmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.kgd.springbootmall.entity.Tests;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface TestRepository extends JpaRepository<Tests, Long>{
    @Query("select id from Tests id where id.testId = :id")
    Tests findById(@Param("id") Integer id);
    // @Query로 쿼리 전송, @Param으로 매개변수 가져올 별명 지정
    // 파라미터 바인딩 방식에는 위치기반과 이름기반이 있는데, 후자를 더 많이 사용하고 안정적으로 바라본다.
    // @Param을 사용하여 바인딩을 한 것을 이름기반 바인딩이라 한다.
    // @Query는 테이블을 대상으로 쿼리를 날리는 것이 아닌, 엔티티를 대상으로 날린다

    // Optional 클래스는 Null이거나 null이 아닌 값을 담을 수 있는 클래스이다.
    // 그리하여 복잡한 NullPointerException을 피할 수 있다.

    @Override
    <S extends Tests> S save(S entity);

    // @Query에 들어가는 쿼리는 그냥 SQL이 아닌 JPQL이 들어가야 한다.
    // SQL : 테이블을 대상으로 쿼리
    // JPQL : 엔티티 객체를 대상으로 쿼리

//    @Transactional                                                          // 해당 타깃을 포인트 컷의 대상으로 자동 등록하며 트랜잭션 관리 대상이 된다.
    @Modifying                                                              // @Query 어노테이션을 통해 작성된 INSERT, UPDATE, DELETE(SELECT 제외) 쿼리에서 사용되는 어노테이션
    @Query(                                                                 // nativeQuery 옵션을 사용하면 SQL로 작성가능하다.
            value="delete table Tests",
            nativeQuery = true
    )
    void deleteAll();


}

