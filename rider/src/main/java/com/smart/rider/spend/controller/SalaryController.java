package com.smart.rider.spend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.main.service.MainService;
import com.smart.rider.member.dto.MemberDTO;
import com.smart.rider.shop.dto.SsrHapDTO;
import com.smart.rider.spend.service.SalaryService;
import com.smart.rider.spend.service.UtilityService;

@Controller
public class SalaryController {
	
	@Autowired
	private SalaryService salaryService;
	
	@Autowired
	private UtilityService utilityService;
	
	@Autowired
	private MainService mainService;
	
	/*** 190927 재욱, 지출_급여 화면 ***/
	@GetMapping("/spendSalary")
	public String spendSalary(@RequestParam(value = "selectShopCode", required = false, defaultValue = "SR0000") String selectShopCode
							, @RequestParam(value = "salaryYear", required = false, defaultValue = "2019") String salaryYear
							, HttpSession session
							, Model model) {
		
		String contractShopCode = (String)session.getAttribute("SCODE");
		String userLevel = (String)session.getAttribute("SLEVEL");
		
		//System.out.println(salaryYear + " <-- salaryYear spendSalary() SalaryController.java");
		
		/*** 190930 재욱, 관리자 권한으로 계약된 매장 내역 ***/
		if(userLevel.equals("관리자")) {
			contractShopCode = selectShopCode;
			List<SsrHapDTO> salaryShop = utilityService.utilityShop();
			//System.out.println(salaryShop + " <-- salaryShop spendSalary() SalaryController.java");
			model.addAttribute("salaryShop", salaryShop);
			model.addAttribute("masterShopCode", contractShopCode);
		}
		
		// 지출_급여 직원 select box list
		List<MemberDTO> employeeSelect = salaryService.salarySelectBox(contractShopCode);
		//System.out.println(salarySelectList + " <-- salarySelectList spendSalary() SalaryController.java");
		model.addAttribute("employeeSelect", employeeSelect);
		model.addAttribute("selectedYear", salaryYear);
		
		if(employeeSelect.size() == 0) {
			model.addAttribute("alert", "등록된 직원이 없습니다");
		}
		
		
		return "spend/spendSalary";
	}
	
	
	
}
