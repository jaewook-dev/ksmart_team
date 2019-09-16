package com.smart.rider.goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smart.rider.goods.dto.GoodsDTO;
import com.smart.rider.goods.mapper.GoodsMapper;

@Service
@Transactional
public class GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	
	//01판매상품 리스트조회 메서드
	//문영성
	public List<GoodsDTO> goodsList(){
		
		return goodsMapper.goodsList();
	}
}
