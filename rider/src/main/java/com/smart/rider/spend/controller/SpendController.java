package com.smart.rider.spend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	/**** 191004 재욱, Modal ajax 호출, 관리자 확인 카운트, 2일 때 관리자 비밀번호와 점주 생년월일 일치 ****/
	@RequestMapping(value = "/adminCheck") // 요청에 반응하는 url
	public @ResponseBody int adminCheck(String shopCode, String memberBirth, String adminPw) {
		
		int result = spendService.spendAdminCheck(shopCode, memberBirth, adminPw); // DB 조회 결과
		//System.out.println(result + " <-- result adminCheck() SpendController.java"); 
		
		return result;
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
