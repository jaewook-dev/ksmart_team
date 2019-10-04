package com.smart.rider.spend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.main.dto.SearchDTO;
import com.smart.rider.spend.dto.SpendAdminDTO;
import com.smart.rider.spend.service.SpendService;

@Controller
public class SpendController {
	
	@Autowired
	private SpendService spendService;
	

	@GetMapping("/spendTotal")
	public String spendTotal() {
		return "spend/spendTotal";
	}
	
	/**** 191004 재욱, Read : 관리자 확인을 통한 지출관리 페이지 이동 ****/
	@PostMapping("/spendAdminCheck")
	public String spendAdminCheck(@RequestParam(value = "shopCode") String shopCode
								, @RequestParam(value = "adminPw") String adminPw
								, @RequestParam(value = "memberBirth") String memberBirth) {
		
		//System.out.println(shopCode + " <-- shopCode spendAdminCheck() SpendController.java");
		//System.out.println(adminPw + " <-- adminPw spendAdminCheck() SpendController.java");
		//System.out.println(memberBirth + " <-- memberBirth spendAdminCheck() SpendController.java");
		
		// adminCheck의 값이 2일 때 관리자 비밀번호 및 해당 매장의 점주의 생년월일 일치
		int adminCheck = spendService.spendAdminCheck(shopCode, memberBirth, adminPw);
		//System.out.println(adminCheck + " <-- adimnCheck spendAdminCheck() SpendController.java");
		
		if(adminCheck == 2) {
			return "spend/spendSalary?shopCode=" + shopCode;
		}
		
		return "redirect:/spendAdminDetails";
	}
	
	/**** 191004 재욱, Read : 계약된 매장 리스트 상세보기 ****/
	@GetMapping("/spendAdminDetails")
	public String spendAdminDetails(String shopCode, Model model) {
		//System.out.println(shopCode + " <-- shopCode spendAdminDetails() SpendController.java");
		List<SpendAdminDTO> list = spendService.spendAdminDetails(shopCode);
		model.addAttribute("detailsList", list);
		return "spend/spendAdminDetails";
	}
	
	
	/**** 191004 재욱, Read : 계약된 매장 리스트 ****/
	@GetMapping("/spendAdmin")
	public String spendAdmin(Model model) {
		List<SpendAdminDTO> list = spendService.spendAdmin();
		//System.out.println(list + " <-- list spendAdmin() SpendController.java");
		model.addAttribute("shopList", list);
		return "spend/spendAdmin";
	}

}
