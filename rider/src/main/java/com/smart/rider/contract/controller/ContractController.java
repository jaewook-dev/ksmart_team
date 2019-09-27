package com.smart.rider.contract.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.smart.rider.contract.dto.ContractDTO;
import com.smart.rider.contract.dto.ManagementDTO;
import com.smart.rider.contract.dto.UnitDTO;
import com.smart.rider.contract.service.ContractService;


@Controller
public class ContractController {
	
	@Autowired  private ContractService contractService;

	
	@GetMapping("/contract")
	public String contract(Model model,HttpSession session) {
		List<UnitDTO>  UnitDTO = contractService.unitNew();

		model.addAttribute("unitNew", contractService.unitNew());
		System.out.println(UnitDTO.toString());
		
		//최근 계약 단가표 코드 session으로 받아오기
		String getContractUnitCode = UnitDTO.get(0).getContractUnitCode();
		System.out.println(getContractUnitCode);
		session.setAttribute("SCUC",getContractUnitCode);
		
		
		return "/contract/contract";
	}
	
	@GetMapping("/agreement")
	public String agreement(Model model) {
			
		//입력값 확인
		System.out.println("=====test=====");
		System.out.println("agreement:"+contractService.agreementList());
		model.addAttribute("agreement", contractService.agreementList());

		return "/contract/agreement";
	}
	

	
	@GetMapping("/contractList")
	public String contractList(Model model) {
		List<ContractDTO> contractList =  contractService.contractList();
	
		System.out.println("=====test=====");
		System.out.println("contractList:"+contractList);
		model.addAttribute("contractList", contractList);
		
	
		
		return "contract/contractList";
	}
	
	@GetMapping("/contractInsert")
	public String contractInsert(Model model){
		List<UnitDTO> contractInsert =   contractService.unitNew();
		
		System.out.println("=====test=====");
		System.out.println("contractList:"+contractInsert);
		model.addAttribute("contractInsert", contractInsert);
		
	
		return "/contract/contractInsert";
	}
	
	@PostMapping("/contractInsert")
	public String contractInsert(ContractDTO contract,HttpSession session,ManagementDTO management) {
		
		System.out.println(contract.toString() + "<-- contract.toString");
		contractService.contractInsert(contract, session, management);
		
		return "redirect:/contractList";
	}
	

	
	
	
}
