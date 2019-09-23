package com.smart.rider.contract.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.contract.dto.UnitDTO;

@Mapper
public interface UnitMapper {
	
	public List<UnitDTO> unitList();
	
	public String unitCodeMax();
	
	public int unitInsert(UnitDTO unit);

	
}
