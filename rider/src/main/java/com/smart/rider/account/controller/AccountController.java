package com.smart.rider.account.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.account.dto.AccountDTO;
import com.smart.rider.account.service.AccountService;
import com.smart.rider.shop.dto.SsrHapDTO;
import com.smart.rider.subject.dto.SubjectDTO;


@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/accountList")
	public String account(Model model) {
		List<AccountDTO> accountList =  accountService.accountList();
		System.out.println("=====test=====");
		System.out.println("accountList:"+accountList);
		model.addAttribute("accountList", accountService.accountList());
		
		
		return "/account/accountList";
	}
	@GetMapping("/accountInsert")
	public String accountInsert(Model model,HttpSession session) {
		//session 값 확인
		String SID = (String)session.getAttribute("SID");
		System.out.println(SID+"<----세션에 담긴 아이디 값");
		
		//model 담을 값 가져오기 및 확인
		List<SsrHapDTO> ssrList = accountService.getShopRelationCode(SID);
		System.out.println( ssrList +"<---ssrList에 담긴 값 확인");
		
		//model에 담기
		model.addAttribute("ssrList", ssrList);
		System.out.println( ssrList + "<--제대로 담겨 있는지 확인");
		
		return "/account/accountInsert";
	}
	@PostMapping("/accountInsert")
	public String accountInsert(AccountDTO account) {
		System.out.println(account +"<--accountInsert에서 넘어온  값");
		accountService.accountInsert(account);
		

		return "redirect:/accountList";
	}
	@PostMapping("/accountSearchList")
	public String accountSearchList(@RequestParam(value = "select") String select
									, @RequestParam(value = "searchName") String searchName
									, @RequestParam(value = "beginDate") String beginDate
									, @RequestParam(value = "endDate") String endDate
									, Model model) {
		//입력값 확인
		System.out.println(select+"<--선택된 값");
		System.out.println(searchName +"<-- 입력된 매장이름");
		System.out.println(beginDate+"<--시작일자");
		System.out.println(endDate+"<--종료일자");
		
		
		// model에 값 넣기
		List<AccountDTO> accountList = accountService.accountSearchList(select, searchName, beginDate ,endDate);
		//model에 대입값 넣기
		model.addAttribute("accountList", accountList);
		//조회 결과가 없으면 나오는 문장
		if(accountList.size() == 0 ) {
			model.addAttribute("alert", "검색 결과가 없습니다");
		}
		
		return "/account/accountList";
	}
	@GetMapping("/accountUpdate")
	public String accountUpdate(@RequestParam(value="accountCode")String accountCode,Model model) {
		
		System.out.println(accountCode+"<--넘어오는 코드값 확인");
		
		//대입값 넣어서 나온 결과 updateList에 담기
		List<AccountDTO> updateList = accountService.accountUpdate(accountCode);
		System.out.println(updateList+"<--대입 결과 확인");
		//결과값 model에 담기
		model.addAttribute("updateList", updateList);
		return "account/accountUpdate";
	}
	@PostMapping("/accountUpdate")
	public String accountUpdate(AccountDTO account) {
		
		System.out.println(account+"넘어오는값확인");
		
		accountService.accountUpdateSet(account);
		
		return "redirect:/accountList";
	
	}
}
