package com.smart.rider.contract.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.contract.dto.ContractManagementDTO;
import com.smart.rider.contract.dto.ManagementDTO;
import com.smart.rider.contract.mapper.ManagementMapper;

@Service
public class ManagementService {

	@Autowired
	private ManagementMapper managementMapper;
	
	//계약단가표 생성
	public int managementInsert(ManagementDTO management,HttpSession session) {
	
		return managementMapper.managementInsert(management);
	}
	
	//계약금 목록
	public List<ContractManagementDTO> managementList(){
		
		return managementMapper.managementList();
	}
	
	//계약금 상세조회 
	public List<ManagementDTO> getManagementList(String managementCode){
		
		return managementMapper.getManagementList(managementCode);
	}
	
	//계약금 수정하기
	public int managementUpdate(ManagementDTO management) {
		
		return managementMapper.managementUpdate(management);
	}
}
