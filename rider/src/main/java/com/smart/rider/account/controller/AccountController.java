package com.smart.rider.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.smart.rider.account.service.AccountService;


@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/account")
	public String account() {
		
		return "/account/account.html";
	}
}
