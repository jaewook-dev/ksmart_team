package com.smart.rider.goods.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.account.dto.AccountDTO;
import com.smart.rider.account.service.AccountService;
import com.smart.rider.goods.dto.GoodsPurchaseDTO;
import com.smart.rider.goods.service.GoodsPurchaseService;
import com.smart.rider.goods.service.GoodsdbService;


@Controller
public class GoodsPurchaseController {
	@Autowired
	private GoodsPurchaseService goodsPurchaseService;
	@Autowired
	private GoodsdbService goodsdbservice;
	@Autowired
	private AccountService accountService;
	
	
	//매입리스트 이동
	@GetMapping("/purchaseList")
	public String purchase() {
		
		return "purchase/purchaseList";
	}
	
	
	//상품DB코드로 매입상품등록하기
	//19-09-20 문영성
	@GetMapping("/purchaseInsert")
	public String purchaseInsert(@RequestParam(value="goodsDbCode")String goodsDbCode, Model model) {
		//System.out.println(goodsDbCode+"<======매입등록시작 DB코드값 확인");
		model.addAttribute("goodsDbCode", goodsdbservice.getGoodsDbCode(goodsDbCode));
		
		/* 거래처 코드리스트 */
		model.addAttribute("pList", accountService.accountList());
		
		return "purchase/purchaseInsert"; 
	}
	@PostMapping("/purchaseInsert")
	public String purchaseInsert(GoodsPurchaseDTO goodsPurchaseDto,HttpSession session, Model model) {
		/* System.out.println(goodsPurchaseDto+"<<<<<<<<<<<<<<<<<<<<<<매입insert 확인"); */
		String contractShopCode = (String)session.getAttribute("SCODE");
		//System.out.println(contractShopCode+"<======매입등록시작 DB코드값 확인");
		goodsPurchaseDto.setContractShopCode(contractShopCode);
		//System.out.println("goodsPurchaseDto: "+goodsPurchaseDto);
		goodsPurchaseService.purchaseInsert(goodsPurchaseDto);
		return "redirect:purchaseList";
	}
	
	
}
