package com.smart.rider.sales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.goods.dto.GoodsHapDTO;

@Mapper
public interface SalesMapper {
	public List<GoodsHapDTO> salesList();

}
