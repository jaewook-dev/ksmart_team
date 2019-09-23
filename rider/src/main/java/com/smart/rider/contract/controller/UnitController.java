package com.smart.rider.contract.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.smart.rider.contract.dto.UnitDTO;
import com.smart.rider.contract.service.UnitService;

@Controller
public class UnitController {

	@Autowired UnitService unitService;
	
	@GetMapping("/unitInsert.html")
	public String unitInsert() {
		
		return "/unit/unitInsert";
	}
	
	@GetMapping("/unitList.html")
	public String unitList(Model model) {
		
		model.addAttribute("unitList", unitService.unitList());
		
		return "/unit/unitList";
	}

	@PostMapping("/unitInsert")
	public String unitInsert(UnitDTO unit, HttpSession session) {
		
		System.out.println(unit.toString() + "<-- unit.toString");
		unitService.unitInsert(unit,session);

		return "redirect:/unitList.html";
	}
	

}
