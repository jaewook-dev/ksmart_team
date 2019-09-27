package com.smart.rider.account.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.smart.rider.account.dto.AccountDTO;
import com.smart.rider.account.service.AccountService;
import com.smart.rider.shop.dto.SsrHapDTO;


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
}
