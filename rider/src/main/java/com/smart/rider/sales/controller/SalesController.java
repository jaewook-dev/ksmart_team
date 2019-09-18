package com.smart.rider.sales.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class SalesController {

	
	@GetMapping("/salesList")
	public String salseList() {
		return "sales/salesList";
	}

}
