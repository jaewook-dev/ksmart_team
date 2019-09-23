package com.smart.rider.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.customer.dto.CustomerDTO;
import com.smart.rider.customer.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//19.09.20작성
	@GetMapping("/customerInsert")
	public String customerInsert() {
		return "customer/customerInsert";
	}
	//19.09.23작성
	@GetMapping("/customerList")
	public String customerList(Model model) {
		List<CustomerDTO> list = customerService.customerList();
		model.addAttribute("custoemrList", list);
		return "customer/customerList";
	}
	@GetMapping("/getCustomerList")
	public String getCustomerList(@RequestParam(value="rentalCustomerCode") String rentalCustomerCode, Model model) {
		model.addAttribute("customerList", customerService.getCustomerList(rentalCustomerCode));
		return "customer/customerUpdate";
	}
}
