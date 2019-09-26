package com.smart.rider.contract.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.contract.dto.ContractDTO;
import com.smart.rider.contract.dto.ContractManagementDTO;
import com.smart.rider.contract.dto.ManagementDTO;
import com.smart.rider.contract.service.ContractService;
import com.smart.rider.contract.service.ManagementService;

@Controller
public class ManagementController {

	@Autowired
	private ManagementService managementService;
	@Autowired
	private ContractService contractService;
	
	
	@GetMapping("/managementList")
	public String managementList(Model model,HttpSession session) {
		List<ContractManagementDTO> managementList = managementService.managementList();
		
		//contractList에 담겨있는 contractCode 중에  마지막에 등록된 코드 가져오기
		List<ContractDTO> contractList =  contractService.contractList();
		String getContractCode = contractList.get(contractList.size()-1).getContractCode();
		System.out.println(getContractCode);
		session.setAttribute("SCC",getContractCode);
		//모델에 넣기 전에 managementList들어있는 값을 확인  
		System.out.println("ContractManagementDTO" + managementList);
		model.addAttribute("managementList", managementList);
		
		return "management/managementList";
	}
	
	@GetMapping("/managementInsert")
	public String managementInsert() {
		
		return "management/managementInsert";
	}
	
	@PostMapping("/managementInsert")
	public String managementInsert(ManagementDTO management,HttpSession session) {
		
		System.out.println(management.toString() + "<-- management.toString");
		managementService.managementInsert(management, session);
		
		return "redirect:/managementList";
	}
	
	@GetMapping("/managementUpdate")
	public String managementUpdate(@RequestParam(value = "contractManagementCode") String managementCode, Model model) {
		//값들어오는지 확인
		System.out.println(managementCode);
		//getManagementList 값 확인
		List<ManagementDTO> List = managementService.getManagementList(managementCode);
		System.out.println("ManagementList"+List);
		model.addAttribute("managementList", List);
		
		return "management/managementUpdate";
	}
	@PostMapping("/managementUpdate")
	public String managementUpdate(ManagementDTO management) {
		
		managementService.managementUpdate(management);
		
		//들어오는  값 확인 
		System.out.println(management.toString() + "<-- management.toString");
		
		return "redirect:/managementList";
	}
	
	
}
