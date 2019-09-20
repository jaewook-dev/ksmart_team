package com.smart.rider.contract.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smart.rider.contract.dto.ContractDTO;
import com.smart.rider.contract.service.ContractService;

@Controller
public class ContractController {
	
	@Autowired ContractService contractService;
	
	@GetMapping("/contract")
	public String contract(Model model) {
		
		
		model.addAttribute("unitNew", contractService.unitNew());

		return "/contract/contract";
	}
	
	@GetMapping("/agreement")
	public String agreement() {
		
		return "/contract/agreement";
	}
	
	@GetMapping("/contractList")
	public String contractList(Model model) {
		List<ContractDTO> contractList =  contractService.contractList();
		System.out.println("=====test=====");
		System.out.println("contractList:"+contractList);
		model.addAttribute("contractList", contractList);
		
		return "/contract/contractList";
	}
	
	@GetMapping("/contractInsert")
	public String contractInsert() {
		
		
		return "/contract/contractInsert";
	}
	
	
}
