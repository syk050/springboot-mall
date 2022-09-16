package com.kgd.springbootmall.repository;

import com.kgd.springbootmall.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
