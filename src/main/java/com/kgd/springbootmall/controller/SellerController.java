package com.kgd.springbootmall.controller;


import com.kgd.springbootmall.dto.seller.ProductAddDTO;
import com.kgd.springbootmall.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kgd/product")
public class SellerController {

    private final SellerService sellerService;

    @PostMapping("/post")
    public void postProduct(@RequestBody ProductAddDTO productAddDTO)
    {
        System.out.println("수신완료");
        // Json으로 받거나, 각 개별 클래스로 해당하는 데이터 수신 및 처리
        sellerService.insertData();

    }

// 필요한 기능
//    1. 제품 추가
//    2. 특정 seller의 제품 조회
//    3. 주문 관리 동향(구매알림, 주문상세, 배송상세 등)
//    4. 통계(총 주문 수, 판매수익, 매 달마다 내역 그래프 등)
//    5. 잠금기능(더 이상 판매 중지) - 제품을 바로 삭제하면 현재 있는 통계나 배송 데이터와 같이 사라짐(이에 대한 해결법)

}
