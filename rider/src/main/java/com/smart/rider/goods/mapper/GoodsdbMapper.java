package com.smart.rider.goods.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.goods.dto.GoodsdbDTO;

@Mapper
public interface GoodsdbMapper {
	//상품코드자동추가하기위한 메서드
	public int getGoodsDbCodeMax();
	
	//상품DB등록하기 
	//날짜 19-09-10 문영성
	public int goodsDbInsert(GoodsdbDTO goodsdbdto);
}
