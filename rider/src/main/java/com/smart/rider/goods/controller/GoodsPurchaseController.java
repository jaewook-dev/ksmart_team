package com.smart.rider.goods.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.goods.service.GoodsdbService;


@Controller
public class GoodsPurchaseController {
	@Autowired
	private GoodsdbService goodsdbservice;

	@GetMapping("/purchaseList")
	public String purchase() {
		
		return "purchase/purchaseList";
	}
	
	//상품DB코드로 매입상품등록하기
	//19-09-20 문영성
	@GetMapping("/purchaseInsert")
	public String purchaseInsert(@RequestParam(value="goodsDbCode")String goodsDbCode,Model model) {
		System.out.println(goodsDbCode+"<======매입등록시작 DB코드값 확인");
		
		model.addAttribute("goodsDbCode", goodsdbservice.getGoodsDbCode(goodsDbCode));
		return "purchase/purchaseInsert"; 
	}
}
