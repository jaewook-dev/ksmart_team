package com.smart.rider.sales.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smart.rider.goods.dto.GoodsHapDTO;
import com.smart.rider.sales.service.SalesService;

@Controller
public class SalesController {
	@Autowired
	private SalesService salesService;
	
	@GetMapping("/salesList")
	public String salseList(Model model) {
		List<GoodsHapDTO> sList = salesService.salesList();
		System.out.println("매출리스트 뽑아오기"+sList);
		//model.addAttribute("sList", sList);
		return "sales/salesList";
	}
	
}
