package com.kgd.springbootmall.repository;

import com.kgd.springbootmall.entity.seller.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Products, Long> {



}
