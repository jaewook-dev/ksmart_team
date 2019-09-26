package com.smart.rider.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smart.rider.account.dto.AccountDTO;
import com.smart.rider.account.service.AccountService;


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
	public String accountInsert(AccountDTO account) {
		System.out.println(account +"<--accountInsert에서 넘어온  값");
		accountService.accountInsert(account);
		
		return "/account/accountInsert";
	}
}
