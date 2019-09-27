package com.smart.rider.spend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smart.rider.member.dto.MemberDTO;
import com.smart.rider.spend.service.SalaryService;

@Controller
public class SalaryController {
	
	@Autowired
	private SalaryService salaryService;
	
	/*** 190927 재욱, 지출_급여 화면 ***/
	@GetMapping("/spendSalary")
	public String spendSalary(HttpSession session, Model model) {
		
		String contractShopCode = (String)session.getAttribute("SCODE");
		
		// 지출_급여 직원 select box list
		List<MemberDTO> employeeSelect = salaryService.salarySelectBox(contractShopCode);
		//System.out.println(salarySelectList + " <-- salarySelectList spendSalary() UtilityController.java");
		model.addAttribute("employeeSelect", employeeSelect);
		
		if(employeeSelect.size() == 0) {
			model.addAttribute("alert", "등록된 직원이 없습니다");
		}
		
		return "spend/spendSalary";
	}
	
	
	
}
