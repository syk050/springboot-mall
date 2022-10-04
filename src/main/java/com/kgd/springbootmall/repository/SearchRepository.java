package com.kgd.springbootmall.repository;

import com.kgd.springbootmall.entity.seller.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SearchRepository extends JpaRepository<Products, Long> {
    @Query(value = "SELECT * FROM products WHERE name LIKE %?1% GROUP BY name",                                         // id는 다르더라도 제품명이 같은(ex)같은 제품의 다른 색상) 제품은 1개만 검색되게끔 group by로 중복을 제거한다(중복 제거에는 같은 이름-다른색상-다른개수 인 아이템을 하나만 가져오기 위함).
    nativeQuery = true)
    Page<Products> findByName(@Param("name") String name, Pageable pageable);
                                                                                                                        // 제품명을 검색하여 결과를 Page 객체 배열로 가져오는 쿼리
                                                                                                                        // 현재 Pageable 변수로 가져오는 query 결과의 양을 조절했다.
                                                                                                                        // JpaRepository가 기본 제공하는 query가 존재하지만, 사용할 것이라면 List<>가 아닌 Page<> 형식으로 받아야 한다는 것을 명심해야 한다.


    @Query(value = "SELECT * FROM products WHERE name LIKE ?1",                                                         // 제품명을 검색하여 어떤 제품명과 정확히 일치하는 제품 가져오기
            nativeQuery = true)
    List<Products> getProductDetail(@Param("name") String name);



    @Query(value = "SELECT * FROM products WHERE id IN ?1",                                               // 관련 아이템인 만큼 필요한 속성(id, 제품명, 가격)만 select 하면 된다.    ( "SELECT id, name, price FROM products WHERE id IN ?1" )
    nativeQuery = true)
    List<Products> getRelProductDetail(@Param("relItems") String[] relItems);



    @Query("select p from Products p")                                                                                  // 전체 아이템 가져오기
    List<Products> getAll(Pageable pageable);



    @Override                                                                                                           // 제품 저장
    <S extends Products> S save(S entity);



    @Override                                                                                                           // 제품 배열 저장
    <S extends Products> List<S> saveAll(Iterable<S> entities);



    @Modifying
    @Query(                                                                                                             // nativeQuery 옵션을 사용하면 JPQL이 아닌 SQL로 작성가능하다.
            value="alter table products auto_increment=1;",                                                             // id auto_increment 초기화
            nativeQuery = true
    )
    void resetAuto();



    @Modifying
    @Query("delete from Products")                                                                                      // 테이블 내용 초기화
    void deleteAll();

}




//  @Query :  테이블을 대상으로 쿼리를 날리는 것이 아닌, 엔티티를 대상으로 날린다, JPQL 쿼리를 사용
//  @Modifying : @Query 어노테이션을 통해 작성된 INSERT, UPDATE, DELETE(SELECT 제외) 쿼리에서 사용되는 어노테이션
//  @Param : 매개변수로 가져올 별명 지정
//           파라미터 바인딩 방식에는 위치기반과 이름기반이 있는데, 후자를 더 많이 사용하고 안정적으로 바라본다.
//           @Param을 사용하여 바인딩을 한 것을 이름기반 바인딩이라 한다.
//  SQL : 테이블을 대상으로 쿼리
//  JPQL : 엔티티 객체를 대상으로 쿼리


// ----------- DB SQL 구문 순서 --------------
// SELECT -> FROM -> WHERE -> GROUP BY -> HAVING -> ORDER BY

