package com.smart.rider.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smart.rider.goods.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	//02 판매상품등록 요청
	//문영성
	@GetMapping("/goodsInsert")
	public String goodsInsert() {
		return "/goods/goodsInsert";
	}
	//01 판매상품 리스트 조회 
	//19-09-16 문영성
	@GetMapping("/goodsList")
	public String goodsList(Model model) {
		//System.out.println(model.addAttribute("goodsList", goodsService.goodsList()+"<---------------------GoodsController.java------확인"));
		model.addAttribute("goodsList", goodsService.goodsList());
		return "/goods/goodsList";
	}
}
