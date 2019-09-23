package com.smart.rider.contract.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.contract.dto.ContractDTO;
import com.smart.rider.contract.dto.ContractMemberDTO;
import com.smart.rider.contract.dto.UnitDTO;

@Mapper
public interface ContractMapper {
	public List<UnitDTO> unitNew();
	
	public List<ContractDTO> contractList();
	
	public String contractCodeMax();
	
	public int contractInsert(ContractDTO Contract);
	
	public List<ContractMemberDTO> agreementList();
	
}
