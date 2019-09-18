package com.smart.rider.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.smart.rider.account.service.PurchaseService;

@Controller
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	@GetMapping("/purchase")
	public String purchase() {
		
		return "purchase/purchase";
	}
}
