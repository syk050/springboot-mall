package com.kgd.springbootmall.repository;

import com.kgd.springbootmall.entity.ItemTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemTagRepository extends JpaRepository<ItemTag, Long> {

    List<ItemTag> findByItemId(@Param("itemId") Long itemId);
}
