package com.smart.rider.contract.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.contract.dto.ManagementDTO;
import com.smart.rider.contract.mapper.ManagementMapper;

@Service
public class ManagementService {

	@Autowired
	private ManagementMapper managementMapper;
	
	public int managementInsert(ManagementDTO management,HttpSession session) {
		//코드 만들기 : managementCodeMax로 마지막 번호를 받아서 M +번호를 붙여서 코드를 만든다
		String  managementCode= "M"+ managementMapper.managementCodeMax();
		if(managementCode.equals("Mnull")) { 
			managementCode = "M0001";
		}
		//계약관리쪽 마지막 contractCode를 가져와서  managemenDTO 쪽에 set을 한다.
		management.setContractCode((String)session.getAttribute("SCC"));
		System.out.println(management.getContractCode());
		
		//만든 코드를  ContractManagementCode에다가 set 해주고 get으로 값이 들어가있는지 확인
		management.setContractManagementCode(managementCode);
		System.out.println(management.getContractManagementCode());
				
		
		return managementMapper.managementInsert(management);
	
	}
}
