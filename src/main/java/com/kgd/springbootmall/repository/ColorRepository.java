package com.kgd.springbootmall.repository;

import com.kgd.springbootmall.entity.seller.Color;
import com.kgd.springbootmall.entity.seller.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ColorRepository extends JpaRepository<Color, Long> {

    @Modifying
    @Query(                                                                                                             // nativeQuery 옵션을 사용하면 JPQL이 아닌 SQL로 작성가능하다.
            value="alter table product auto_increment=1;",                                                             // id auto_increment 초기화
            nativeQuery = true
    )
    void resetAuto();



    @Modifying
    @Query("delete from Product")                                                                                      // 테이블 내용 초기화
    void deleteAll();

}