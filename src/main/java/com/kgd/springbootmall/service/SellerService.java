package com.kgd.springbootmall.service;

import com.kgd.springbootmall.entity.seller.Color;
import com.kgd.springbootmall.entity.seller.Product;
import com.kgd.springbootmall.repository.ColorRepository;
import com.kgd.springbootmall.repository.ProductRepository;
import com.kgd.springbootmall.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Component
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerRepository;
    private final ProductRepository productRepository;
    private final ColorRepository colorRepository;

    public void resetDB(){
        productRepository.deleteAll();
        productRepository.resetAuto();
        colorRepository.deleteAll();
        colorRepository.resetAuto();
    }

    public void insertData(){ // 매개변수로는 ColorDTO, ProductDTO 받기
        // Color 먼저 넣고, c_num return -> 받은 c_num을 참조하여 product 넣기
        Color c = new Color("컬러명", 3);                  // 임시용 Color
        Color tmp = colorRepository.save(c);
        Product p = new Product("제품1", "설명", "관련아이템 리스트", tmp.getNum());
        productRepository.save(p);


    }


}
