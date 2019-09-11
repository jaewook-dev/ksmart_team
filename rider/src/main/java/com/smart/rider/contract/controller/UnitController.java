package com.smart.rider.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.smart.rider.contract.service.UnitService;

@Controller
public class UnitController {

	@Autowired UnitService unitService;
	
	@GetMapping("/unitInsert.html")
	public String contract() {
		
		return "/unit/unitInsert";
	}
}
