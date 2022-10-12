package com.kgd.springbootmall.repository;

import com.kgd.springbootmall.entity.Items;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestRepository extends JpaRepository<Items, Long> {
}
