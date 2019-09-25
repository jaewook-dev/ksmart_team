package com.smart.rider.goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smart.rider.goods.dto.GoodsHapDTO;
import com.smart.rider.goods.dto.GoodsRentalDTO;
import com.smart.rider.goods.mapper.GoodsRentalMapper;

@Service
@Transactional
public class GoodsRentalService {
	@Autowired
	private GoodsRentalMapper goodsRentalMapper;
	
	//대여상품상세보기 select
	public GoodsHapDTO getGoodsRentalList(String goodsRentalCode) {
		return goodsRentalMapper.getGoodsRentalList(goodsRentalCode);
	}
	
	//대여상품 등록 insert 19-09-25 문영성
	public int goodsRentalInsert(GoodsRentalDTO goodsRentalDto) {
		String goodsRentalCode = "GR"+goodsRentalMapper.goodsRentalCodeCount();
		System.out.println(goodsRentalCode+"<<<<<<<<<<<<<<<<<코드확인");
		
		
		  if(goodsRentalCode.equals("GRnull")) {
			  
			  goodsRentalCode = "GR0001"; 
			 }
		  	goodsRentalDto.setGoodsRentalCode(goodsRentalCode);
		 
		
		
		return goodsRentalMapper.goodsRentalInsert(goodsRentalDto);		
	}
	
	//대여상품 리스트조회
	public List<GoodsHapDTO> goodsRentalList(){
		return goodsRentalMapper.goodsRentalList();
	}

	
}
