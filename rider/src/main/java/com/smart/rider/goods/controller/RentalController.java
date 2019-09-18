package com.smart.rider.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RentalController {
	@GetMapping("/rentalList")
	public String rentalList() {
		return "/goods/rentalList";
	}
}
