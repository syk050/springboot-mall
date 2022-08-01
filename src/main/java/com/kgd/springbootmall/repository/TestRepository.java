package com.kgd.springbootmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kgd.springbootmall.entity.Test;

import java.util.Optional;


@Repository
public interface TestRepository extends JpaRepository<Test, Integer>{
    Optional<Test> findById(Integer id);
}

