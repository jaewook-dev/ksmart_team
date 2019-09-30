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
import com.smart.rider.goods.dto.GoodsRentalDTO;
import com.smart.rider.goods.service.GoodsRentalService;
import com.smart.rider.goods.service.GoodsService;
import com.smart.rider.member.dto.MemberDTO;
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
	
	//매출삭제
	
	@GetMapping("/salesDelete")
	public String salesDelete(@RequestParam(value="salesCode")String salesCode,Model model) {
		model.addAttribute("salesCode", salesService.getSalesList(salesCode));
		return "sales/salesDelete";
	}
	//매출삭제처리
	@PostMapping("/salesDelete")
	public String goodsRentalDelete(SalesDTO salesDto,MemberDTO memberDto,Model model) {
		int result = salesService.salesDelete(salesDto.getSalesCode(), memberDto.getMemberId(),memberDto.getMemberPw());
		if(result == 0) {
			model.addAttribute("result", "비밀번호를 바르게입력하세요");
			model.addAttribute("salesCode", salesService.getSalesList(salesDto.getSalesCode()));
			return "sales/salesDelete";
		}
		return "redirect:salesList";
	
	}	

	//매출수정
	@PostMapping("/salesUpdate")
	public String salesUpdate(SalesDTO salesDto) {
		//System.out.println("매출수정값 가져오기"+salesDto);
		salesService.salesUpdate(salesDto);
		return "redirect:salesList";
		
	}
	//매출상세보기
	@GetMapping("/getSalesList")
	public String getSalesList(@RequestParam(value="salesCode")String salesCode,Model model) {
		model.addAttribute("salesCode", salesService.getSalesList(salesCode));
		return "sales/getSalesList";
	}
	
	//매출등록요청
	@GetMapping("/salesInsert")
	public String salesInsert(Model model,String goodsCode) {
		//System.out.println("매출등록시 상품코드값"+goodsCode);
		//System.out.println("등록요청시 값확인"+goodsService.getGoodsList(goodsCode));
		
		model.addAttribute("goodsCode", goodsService.getGoodsList(goodsCode));
		//model.addAttribute("goodsRentalCode", goodsRentalService.getGoodsRentalList(goodsRentalCode));
		
		return "sales/salesInsert";
	}
	//대여품매출등록
	@GetMapping("/salesInsert2")
	public String salesInsert2(Model model,String goodsRentalCode) {
		//System.out.println("매출등록시 상품코드값"+goodsCode);
		//System.out.println("등록요청시 값확인"+goodsService.getGoodsList(goodsCode));
		
		model.addAttribute("goodsRentalCode", goodsRentalService.getGoodsRentalList(goodsRentalCode));
		//model.addAttribute("goodsRentalCode", goodsRentalService.getGoodsRentalList(goodsRentalCode));
		
		return "sales/salesInsert2";
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
