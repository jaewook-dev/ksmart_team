package com.smart.rider.spend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.spend.dto.UtilityDTO;

@Mapper
public interface UtilityMapper {
	
	public List<UtilityDTO> utilityList(String contractShopCode);

}
