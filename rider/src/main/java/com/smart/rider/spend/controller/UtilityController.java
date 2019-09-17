package com.smart.rider.spend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smart.rider.spend.dto.UtilityDTO;
import com.smart.rider.spend.service.UtilityService;

@Controller
public class UtilityController {
	
	@Autowired
	private UtilityService utilityService;
	
	@GetMapping("/spend")
	public String spendUtility(Model model) {
		List<UtilityDTO> list = utilityService.utilityList();
		model.addAttribute("utilityList", list);
		return "spend/spend";
	}

}
