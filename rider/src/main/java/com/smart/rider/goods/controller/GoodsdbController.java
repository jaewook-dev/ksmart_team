package com.smart.rider.goods.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.smart.rider.goods.dto.GoodsdbDTO;
import com.smart.rider.goods.service.GoodsdbService;

@Controller
public class GoodsdbController {
	@Autowired
	public GoodsdbService goodsdbservice;

	//01상품db등록 페이지이동
	@GetMapping("/goodsdb")
	public String goods() {
		return "/goods/goodsdb";
	}

	@GetMapping("/goodsDbInsert")
	public String goodsdbInsert() {
		return "/goods/goodsDbInsert";
	}

	//02
	// 상품DB등록 확인메서드(처음단계)
	// 문영성

	/*
	 * @PostMapping("/goodsDbInsert") public String goodsdbInsert(GoodsdbDTO
	 * goodsdbdto,Model model) {
	 * System.out.println(goodsdbdto+"<<<<<<<<<<넘어오는값 확인하기");
	 * //model.addAttribute("goodsdbdto",goodsdbservice.goodsDbInsert(goodsdbdto));
	 * return "/goods/goodsDbInsert";
	 * 
	 * }
	 */





	//
	//03상품db 세션아이디가져와서 코드자동증가, db에값들어가는지확인.
	//19-09-10 문영성


	@PostMapping("/goodsDbInsert") public String goodsDbInsert(GoodsdbDTO goodsdbdto, HttpSession session) {

		goodsdbservice.goodsDbInsert(goodsdbdto, session);
		return "redirect:/goodsdb";
		
	}


}
