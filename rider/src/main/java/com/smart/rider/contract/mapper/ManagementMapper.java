package com.smart.rider.contract.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.contract.dto.ContractManagementDTO;
import com.smart.rider.contract.dto.ManagementDTO;

@Mapper
public interface ManagementMapper {

	//계약금 생성
	public int managementInsert(ManagementDTO management);
	
	//계약금 중 가장 높은 숫자 가져오기
	public String managementCodeMax();
	
	//계약금 목록
	public List<ContractManagementDTO> managementList();
	
	//계약금 상세보기
	public List<ManagementDTO> getManagementList(String managementCode);
	
	//계약금 수정하기
	public int managementUpdate(ManagementDTO management);
}
