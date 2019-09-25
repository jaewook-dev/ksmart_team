package com.smart.rider.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.smart.rider.contract.dto.ContractDTO;
import com.smart.rider.contract.service.ContractService;
import com.smart.rider.shop.dto.ShopDTO;
import com.smart.rider.shop.service.ShopService;

@Controller
public class ShopController {

	@Autowired
	private ShopService shopService;
	@Autowired
	private ContractService contractService;
	
	@GetMapping("/shop")
	public String shop(Model model) {
		//값 확인
		List<ShopDTO> List = shopService.shopList();
		System.out.println("shopList"+List);
		
		model.addAttribute("shopList", List);
		
		
		return "/shop/shop";
	}
	
	@GetMapping("/shopInsert")
	public String shopInsert(Model model) {
		List<ContractDTO> contractList =  contractService.contractList();
        		
		//필요한 contractList에 담긴 값을 가져오기 위해 model 사용
		System.out.println("contractList:"+contractList);
		model.addAttribute("contractList", contractList);
		 
		return  "/shop/shopInsert";
	}
	
	@PostMapping("/shopInsert")
	public String shopInsert(ShopDTO shop) {

		
		System.out.println(shop.toString()+"<-담겨있는값");
		shopService.shopInsert(shop);
		
		
		return "redirect:/shop";
	}


}
