package com.kgd.springbootmall.repository;

import com.kgd.springbootmall.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemsRepository extends JpaRepository<Items, Long> {

}
