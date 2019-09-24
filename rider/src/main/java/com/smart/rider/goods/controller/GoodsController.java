package com.smart.rider.goods.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.goods.dto.GoodsDTO;
import com.smart.rider.goods.dto.GoodsHapDTO;
import com.smart.rider.goods.dto.GoodsdbDTO;
import com.smart.rider.goods.mapper.GoodsMapper;
import com.smart.rider.goods.service.GoodsPurchaseService;
import com.smart.rider.goods.service.GoodsService;
import com.smart.rider.goods.service.GoodsdbService;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsdbService goodsdbservice;
	@Autowired
	private GoodsPurchaseService goodsPurchaseService;
	
	
	//상품상세보기,수정화면
	@GetMapping("/getGoodsList")
	public String getGoodsList(@RequestParam(value="goodsCode")String goodsCode,Model model) {
		//System.out.println(model.addAttribute("goodsCode", goodsService.getGoodsList(goodsCode)));
		model.addAttribute("goodsCode", goodsService.getGoodsList(goodsCode));
		return "goods/getGoodsList";		
	}
	//02 판매상품등록 요청
	//문영성
	@GetMapping("/goodsInsert")
	public String goodsInsert(@RequestParam(value="purchaseCode")String purchaseCode,Model model) {
		//System.out.println(purchaseCode+"<--------------------코드확인--------------------");
		model.addAttribute("purchaseCode", goodsPurchaseService.getPurchaseList(purchaseCode));
		return "/goods/goodsInsert";
	}
	
	
	  @PostMapping("/goodsInsert")
	  public String goodsInsert(GoodsDTO goodsDto,HttpSession session,Model model) {
		  //System.out.println("판매상품확인"+goodsDto);
		  String contractShopCode = (String)session.getAttribute("SCODE");
		  //System.out.println("매장코드"+contractShopCode);
		  goodsDto.setContractShopCode(contractShopCode);		 
		  goodsService.goodsInsert(goodsDto);
		  return "redirect:goodsList";
	  }
	 
	//01 판매상품 리스트 조회 
	//19-09-16 문영성
	@GetMapping("/goodsList")
	public String goodsList(Model model) {
		List<GoodsHapDTO> gList = goodsService.goodsList();
		//System.out.println(gList);
		//System.out.println(model.addAttribute("gList",gList+"<---------------------GoodsController.java------확인"));
		model.addAttribute("gList", goodsService.goodsList());
		return "/goods/goodsList";
	}
}
