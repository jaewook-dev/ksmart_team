package com.smart.rider.contract.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.contract.dto.ContractDTO;
import com.smart.rider.contract.dto.ContractMemberDTO;
import com.smart.rider.contract.dto.UnitDTO;

@Mapper
public interface ContractMapper {
	
	//최근단가표목록
	public List<UnitDTO> unitNew();
	
	//계약 관리
	public List<ContractDTO> contractList();
	
	//계약코드중 가장 높은 숫자 가져오기
	public String contractCodeMax();
	
	//생성
	public int contractInsert(ContractDTO Contract);
	
	//계약된 매장 목록
	public List<ContractMemberDTO> agreementList();
	
}
