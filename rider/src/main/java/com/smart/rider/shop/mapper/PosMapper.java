package com.smart.rider.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.shop.dto.PosDTO;
import com.smart.rider.shop.dto.ShopRelationDTO;
import com.smart.rider.shop.dto.SsrHapDTO;

@Mapper
public interface PosMapper {

	public String posCodeMax();
	
	public int posInsert(PosDTO pos);
	
	public List<SsrHapDTO> getMemberId(String memberId);
}
