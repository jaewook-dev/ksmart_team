package com.smart.rider.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smart.rider.account.dto.AccountDTO;
import com.smart.rider.account.service.AccountService;
import com.smart.rider.contract.dto.ContractDTO;


@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/account")
	public String account(Model model) {
		List<AccountDTO> accountList =  accountService.accountList();
		System.out.println("=====test=====");
		System.out.println("accountList:"+accountList);
		model.addAttribute("accountList", accountService.accountList());
		
		
		return "/account/account.html";
	}
}
