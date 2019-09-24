package com.smart.rider.contract.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.contract.dto.ContractManagementDTO;
import com.smart.rider.contract.dto.ManagementDTO;

@Mapper
public interface ManagementMapper {

	public int managementInsert(ManagementDTO management);
	
	public String managementCodeMax();
	
	public List<ContractManagementDTO> managementList();
	
	public List<ManagementDTO> getManagementList(String managementCode);
	
	public int managementUpdate(ManagementDTO management);
}
