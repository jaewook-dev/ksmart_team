package com.smart.rider.contract.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.contract.dto.ContractDTO;
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
}
