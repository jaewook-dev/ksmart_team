package com.smart.rider.customer.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@GetMapping("/getCustomerList")
	public String getCustomerList(@RequestParam(value="rentalCustomerCode") String rentalCustomerCode, Model model) {
		model.addAttribute("customerList", customerService.getCustomerList(rentalCustomerCode));
		return "customer/customerUpdate";
	}
	//19.10.02 페이지 작업
	@GetMapping("/customerList")
	public String customerList(Model model
							 , @RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) {
		Map<String, Object> map = customerService.customerList(currentPage);
		
		model.addAttribute("customerList", map.get("list"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("startPageNum", map.get("startPageNum"));
		model.addAttribute("lastPageNum", map.get("lastPageNum"));
		return "customer/customerList";
	}
}
