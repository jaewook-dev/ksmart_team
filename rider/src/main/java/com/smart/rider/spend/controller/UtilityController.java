package com.smart.rider.spend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.spend.dto.UtilityDTO;
import com.smart.rider.spend.service.UtilityService;
import com.smart.rider.subject.dto.SubjectDTO;

@Controller
public class UtilityController {
	
	@Autowired
	private UtilityService utilityService;
	
	// 지출 화면
	@GetMapping("/spend")
	public String spendUtility(Model model, HttpSession session) {
		String contractShopCode = (String)session.getAttribute("SCODE");
		//System.out.println(contractShopCode + " <-- contractShopCode spendUtility UtilityController.java");
		
		// 지출_공과금 최근 등록내역
		List<UtilityDTO> utilityList = utilityService.utilityList(contractShopCode); 
		model.addAttribute("utilityList", utilityList);
		
		// 지출_공과금 등록 계정과목 select box 리스트
		List<SubjectDTO> subjectList = utilityService.subjectSelectBox();
		model.addAttribute("subjectSelectBox", subjectList);
		return "spend/spend";
	}
	
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
