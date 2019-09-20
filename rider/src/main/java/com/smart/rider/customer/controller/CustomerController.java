package com.smart.rider.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.smart.rider.customer.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	//19.09.20작성
	@GetMapping("/customerList")
	public String customerList() {
		return "customer/customerList";
	}
	@GetMapping("/customerInsert")
	public String customerInsert() {
		return "customer/customerInsert";
	}
	
}
