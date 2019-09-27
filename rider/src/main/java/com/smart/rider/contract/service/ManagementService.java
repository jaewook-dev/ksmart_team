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
	
	public int managementInsert(ManagementDTO management,HttpSession session) {
	
		return managementMapper.managementInsert(management);
	}
	public List<ContractManagementDTO> managementList(){
		
		return managementMapper.managementList();
	}
	
	public List<ManagementDTO> getManagementList(String managementCode){
		
		return managementMapper.getManagementList(managementCode);
	}
	public int managementUpdate(ManagementDTO management) {
		
		return managementMapper.managementUpdate(management);
	}
}
