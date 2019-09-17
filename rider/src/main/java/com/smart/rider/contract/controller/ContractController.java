package com.smart.rider.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	
}
