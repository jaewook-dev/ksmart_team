package com.smart.rider.contract.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
		
		System.out.println(management.toString() + "<-- unit.toString");
		managementService.managementInsert(management, session);
		
		return "redirect:/managementList";
	}
	
	
}
