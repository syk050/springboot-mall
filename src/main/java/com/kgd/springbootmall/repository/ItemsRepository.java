package com.kgd.springbootmall.repository;

import com.kgd.springbootmall.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Items, Long> {

    @Query("select p from Items p order by p.item_id DESC")
    List<Items> findAllDesc();

}
