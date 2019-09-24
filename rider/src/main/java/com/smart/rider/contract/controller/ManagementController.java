package com.smart.rider.contract.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.smart.rider.contract.dto.ManagementDTO;
import com.smart.rider.contract.service.ManagementService;

@Controller
public class ManagementController {

	@Autowired
	private ManagementService managementService;
	
	@GetMapping("/managementList")
	public String managementList(Model model) {
		
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
