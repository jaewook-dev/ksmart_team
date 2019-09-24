package com.smart.rider.contract.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.contract.dto.ManagementDTO;

@Mapper
public interface ManagementMapper {

	public int managementInsert(ManagementDTO management);
	
	public String managementCodeMax();
}
