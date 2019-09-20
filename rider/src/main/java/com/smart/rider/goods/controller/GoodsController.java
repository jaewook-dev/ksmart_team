package com.smart.rider.goods.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.goods.dto.GoodsDTO;
import com.smart.rider.goods.dto.GoodsdbDTO;
import com.smart.rider.goods.mapper.GoodsMapper;
import com.smart.rider.goods.service.GoodsService;
import com.smart.rider.goods.service.GoodsdbService;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsdbService goodsdbservice;
	//02 판매상품등록 요청
	//문영성
	@GetMapping("/goodsInsert")
	public String goodsInsert(@RequestParam(value="goodsDbCode")String goodsDbCode,Model model) {
		//System.out.println(goodsDbCode+"<--------------------코드확인--------------------");
		model.addAttribute("goodsDbCode", goodsdbservice.getGoodsDbCode(goodsDbCode));
		return "/goods/goodsInsert";
	}
	
	
	  @PostMapping("/goodsInsert")
	  public String goodsInsert(@RequestParam(value="goodsDbCode")String goodsDbCode,
			  					@RequestParam(value="goodsCode")String goodsCode,GoodsDTO goodsDto,Model model) {
		 
	  System.out.println(goodsDbCode+	  "<--------------------코드확인--------------------");
	  System.out.println(goodsCode+	  "<--------------------코드확인--------------------");
	  
	  return "redirect:/goodsList"; }
	 
	//01 판매상품 리스트 조회 
	//19-09-16 문영성
	@GetMapping("/goodsList")
	public String goodsList(Model model) {
		//System.out.println(model.addAttribute("goodsList", goodsService.goodsList()+"<---------------------GoodsController.java------확인"));
		model.addAttribute("goodsList", goodsService.goodsList());
		return "/goods/goodsList";
	}
}
