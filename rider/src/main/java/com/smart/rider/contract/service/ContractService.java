package com.smart.rider.contract.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.contract.dto.ContractDTO;
import com.smart.rider.contract.dto.ContractMemberDTO;
import com.smart.rider.contract.dto.UnitDTO;
import com.smart.rider.contract.mapper.ContractMapper;

@Service
public class ContractService {
	 
	@Autowired 
	private ContractMapper contractMapper;
	
	public List<UnitDTO> unitNew(){
		
		
		
		return contractMapper.unitNew();
	}
	public List<ContractDTO> contractList(){
		
		return contractMapper.contractList();
	}
	
	public int contractInsert(ContractDTO contract,HttpSession session) {
		//전체 삭제 후 다시 등록시 null을 받아오는 문제
		String contractCode = "C"+ contractMapper.contractCodeMax();
		if(contractCode.equals("Cnull")) { 
			contractCode = "C0001";
		}
		
		contract.setMemberId((String)session.getAttribute("SID"));
		System.out.println(contract.getMemberId());
		contract.setContractUnitCode((String)session.getAttribute("SCUC"));
		System.out.println(contract.getContractUnitCode());
		contract.setContractCode(contractCode);
		System.out.println(contract.getContractCode());
		return contractMapper.contractInsert(contract);
	
	}
	public List<ContractMemberDTO> agreementList(){
		
		return contractMapper.agreementList();
	}
	
}
