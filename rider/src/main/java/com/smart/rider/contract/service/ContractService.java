package com.smart.rider.contract.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smart.rider.contract.dto.ContractDTO;
import com.smart.rider.contract.dto.ContractMemberDTO;
import com.smart.rider.contract.dto.ManagementDTO;
import com.smart.rider.contract.dto.UnitDTO;
import com.smart.rider.contract.mapper.ContractMapper;
import com.smart.rider.contract.mapper.ManagementMapper;

@Service
@Transactional
public class ContractService {
	 
	@Autowired 
	private ContractMapper contractMapper;
	@Autowired
	private ManagementService managementService;
	@Autowired
	private ManagementMapper ManagementMapper;
	
	public List<UnitDTO> unitNew(){
		
		
		
		return contractMapper.unitNew();
	}
	public List<ContractDTO> contractList(){
		
		return contractMapper.contractList();
	}
	
	public int contractInsert(ContractDTO contract,HttpSession session,ManagementDTO management) {
		//계약코드 생성
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
		
		int result = 0;
		result += contractMapper.contractInsert(contract);
		
		
		//contractList에 담겨있는 contractCode 중에  마지막에 등록된 코드 가져오기
		List<ContractDTO> contractList = contractList();
		String getContractCode = contractList.get(contractList.size()-1).getContractCode();
		System.out.println(getContractCode);
		session.setAttribute("SCC",getContractCode);
		
		
		//계약관리쪽 마지막 contractCode를 가져와서  managemenDTO 쪽에 set을 한다.
		management.setContractCode((String)session.getAttribute("SCC"));
		System.out.println(management.getContractCode());
		
		//코드 만들기 : managementCodeMax로 마지막 번호를 받아서 M +번호를 붙여서 코드를 만든다
		String managementCode= "M"+ ManagementMapper.managementCodeMax();
		if(managementCode.equals("Mnull")) { 
			managementCode = "M0001";
		}
		//기본값 넣어주기
		management.setContractManagementAmout(0);
		management.setContractManagementUnpaid(0);
		management.setContractManagementContents("");
		management.setContractManagementState("계약상태");
		//만든 코드를  ContractManagementCode에다가 set 해주고 get으로 값이 들어가있는지 확인
		management.setContractManagementCode(managementCode);
		System.out.println(management.getContractManagementCode());
				
	
		
		result += managementService.managementInsert(management, session);
		
		
		
		
		
		
		
		
		return result;
		
		
	
	}
	public List<ContractMemberDTO> agreementList(){
		
		return contractMapper.agreementList();
	}
	
}
