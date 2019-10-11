package com.smart.rider.contract.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smart.rider.contract.dto.AgreementDTO;
import com.smart.rider.contract.dto.ContractDTO;
import com.smart.rider.contract.dto.ManagementDTO;
import com.smart.rider.contract.dto.UnitDTO;
import com.smart.rider.contract.mapper.ContractMapper;
import com.smart.rider.contract.mapper.ManagementMapper;
import com.smart.rider.main.dto.SearchDTO;

@Service
@Transactional
public class ContractService {
	 
	@Autowired 
	private ContractMapper contractMapper;
	@Autowired
	private ManagementService managementService;
	@Autowired
	private ManagementMapper ManagementMapper;
	
	//최근단가표
	public List<UnitDTO> unitNew(){
		return contractMapper.unitNew();
	}
	
	//계약 목록
	public List<ContractDTO> contractList(){
		return contractMapper.contractList();
	}
	
	//계약금 검색
	public List<ContractDTO> contractSearchList(SearchDTO search){
		return contractMapper.contractSearchList(search);
	}
	
	//계약  생성하기
	public int contractInsert(ContractDTO contract,HttpSession session,ManagementDTO management) {
		//계약코드 생성
		String contractCode = "C"+ contractMapper.contractCodeMax();
		if(contractCode.equals("Cnull")) { 
			contractCode = "C0001";
		}
		//로그인 되어있는 아이디값 가져오기
		contract.setMemberId((String)session.getAttribute("SID"));
		//System.out.println(contract.getMemberId());
		//최근단가표 세션으로 가져오기
		contract.setContractUnitCode((String)session.getAttribute("SCUC"));
		//System.out.println(contract.getContractUnitCode());
		//계약코드 생성 후 ContractDTO에 넣기
		contract.setContractCode(contractCode);
		//System.out.println(contract.getContractCode());
		//리턴을 2번 하기 위해  선언
		int result = 0;
		result += contractMapper.contractInsert(contract);
		//contractList에 담겨있는 contractCode 중에  마지막에 등록된 코드 가져오기
		List<ContractDTO> contractList = contractList();
		String getContractCode = contractList.get(contractList.size()-1).getContractCode();
		//System.out.println(getContractCode);
		
		//가장 최근에 계약한 코드 가져오기
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
		//System.out.println(management.getContractManagementCode());
		//리턴
		result += managementService.managementInsert(management, session);
		
		return result;
	}
	
	//계약서 목록
	public List<AgreementDTO> agreementList(HttpSession session){
		String id = (String)session.getAttribute("SID");
		String level = (String)session.getAttribute("SLEVEL");
		//System.out.println(level+"<--로그인 권한 확인");
		//System.out.println(id+"<--로그인 아이디 확인");
		
		return contractMapper.agreementList(id,level);
	}
	
	//계약 내용 및 계약금 납부 현황 보기
	public List<AgreementDTO> getAgreementList(String agreementCode){
		return contractMapper.getAgreementList(agreementCode);
	}
	
	//특정 계약코드로 데이터조회
	public List<ContractDTO> getContractList(String contractCode){
		return contractMapper.getContractList(contractCode);
	}
	

}
