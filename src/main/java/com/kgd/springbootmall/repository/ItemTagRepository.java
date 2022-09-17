package com.kgd.springbootmall.repository;

import com.kgd.springbootmall.entity.ItemTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ItemTagRepository extends JpaRepository<ItemTag, Long> {

    ItemTag findByItemId(@Param("itemId") Long itemId);
}
