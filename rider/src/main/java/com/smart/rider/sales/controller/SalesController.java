package com.smart.rider.sales.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.goods.dto.GoodsHapDTO;
import com.smart.rider.goods.service.GoodsRentalService;
import com.smart.rider.goods.service.GoodsService;
import com.smart.rider.sales.dto.SalesDTO;
import com.smart.rider.sales.service.SalesService;

@Controller
public class SalesController {
	@Autowired
	private SalesService salesService;
	@Autowired
	private GoodsRentalService goodsRentalService;
	@Autowired
	private GoodsService goodsService;
	
	//매출등록요청
	@GetMapping("/salesInsert")
	public String salesInsert(Model model,String goodsCode) {
		//System.out.println("매출등록시 상품코드값"+goodsCode);
		//System.out.println("등록요청시 값확인"+goodsService.getGoodsList(goodsCode));
		
		model.addAttribute("goodsCode", goodsService.getGoodsList(goodsCode));
		//model.addAttribute("goodsRentalCode", goodsRentalService.getGoodsRentalList(goodsRentalCode));
		
		return "sales/salesInsert";
	}
	//매출등록처리
	@PostMapping("/salesInsert")
	public String salesInsert(SalesDTO salesDto,HttpSession session) {
		//System.out.println("매출등록 입력확인"+salesDto);
		String contractShopCode = (String)session.getAttribute("SCODE");
		salesDto.setContractShopCode(contractShopCode);
		salesService.salesInsert(salesDto);
		return "redirect:salesList";
		
	}
	//매출리스트 조회요청
	@GetMapping("/salesList")
	public String salseList(Model model) {
		List<GoodsHapDTO> sList = salesService.salesList();
		//System.out.println("매출리스트 뽑아오기"+sList);
		model.addAttribute("sList", sList);
		
		return "sales/salesList";
	}
	
}
