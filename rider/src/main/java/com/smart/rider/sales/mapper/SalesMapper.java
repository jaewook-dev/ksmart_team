package com.smart.rider.sales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.goods.dto.GoodsHapDTO;
import com.smart.rider.sales.dto.SalesDTO;

@Mapper
public interface SalesMapper {
	//매출등록
	public int salesInsert(SalesDTO salesDto);
	//매출리스트
	public List<GoodsHapDTO> salesList();
	//insert 시 코드자동증가
	public String salesCodeCount();

}
