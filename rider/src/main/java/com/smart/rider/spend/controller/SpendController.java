package com.smart.rider.spend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class SpendController {
	

	@GetMapping("/spendTotal")
	public String spendTotal() {
		return "spend/spendTotal";
	}

}
