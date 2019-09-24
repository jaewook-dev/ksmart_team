package com.smart.rider.spend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.spend.dto.UtilityDTO;
import com.smart.rider.spend.service.UtilityService;

@Controller
public class UtilityController {
	
	@Autowired
	private UtilityService utilityService;
	
	// 지출_공과금 내역 등록
		@PostMapping("/utilityInsert")
		public String utilityInsert(@RequestParam(value = "subjectCode") String subjectCode ,UtilityDTO utilityDTO, HttpSession session) {
			String contractShopCode = (String)session.getAttribute("SCODE");
			//System.out.println(subjectCode + " <-- subjectCode utilityInsert UtilityController.java");
			//System.out.println(utilityDTO.getSpendUtilityPay() + " <-- getSpendUtilityPay() utilityInsert UtilityController.java");
			//System.out.println(utilityDTO.getSpendUtilityContents() + " <-- getSpendUtilityContents() utilityInsert UtilityController.java");
			utilityService.utilityInsert(utilityDTO, contractShopCode);

			return "redirect:/spend";
		}

}
