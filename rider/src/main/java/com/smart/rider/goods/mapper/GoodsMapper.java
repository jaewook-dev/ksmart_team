package com.smart.rider.goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.goods.dto.GoodsDTO;
import com.smart.rider.goods.dto.GoodsdbDTO;

@Mapper
public interface GoodsMapper {
	
	//01판매상품 리스트 조회 메서드
	//테이블 3개조인.. 문영성
	public List<GoodsDTO> goodsList();
	
	//02판매상품 입력메서드
	public int goodsInsert(GoodsDTO goodsDto);
	
	public GoodsdbDTO getGoodsDb(GoodsDTO goodsDto,String goodsDbCode);
}
