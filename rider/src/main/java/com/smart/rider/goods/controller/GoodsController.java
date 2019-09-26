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
import com.smart.rider.goods.service.GoodsPurchaseService;
import com.smart.rider.goods.service.GoodsService;
import com.smart.rider.member.dto.MemberDTO;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

	@Autowired
	private GoodsPurchaseService goodsPurchaseService;
	
	//상품검색추가 2019-09-26
	@PostMapping("/goodsSearchList")
	public String goodsSearchList(@RequestParam(value="select")String select
									,@RequestParam(value="searchInput")String searchInput
									,@RequestParam(value="beginDate")String beginDate
									,@RequestParam(value="endDate")String endDate
									,Model model) {
		//System.out.println(select + " <-- select goodsSearchList GoodsController.java");
		//System.out.println(searchInput + " <-- searchInput goodsSearchList GoodsController.java");
		//System.out.println(beginDate + " <-- beginDate goodsSearchList GoodsController.java");
		//System.out.println(endDate + " <-- endDate goodsSearchList GoodsController.java");
		List<GoodsDTO> search = goodsService.goodsSearchList(select, searchInput, beginDate, endDate);
		model.addAttribute("gList", search);
		if(search.size()==0) {
			model.addAttribute("alert", "검색 결과가 없습니다");
		}
		return "goods/goodsList";
	}
	//상품삭제요청
	@GetMapping("/goodsDelete")
	public String goodsDelete(@RequestParam(value="goodsCode")String goodsCode,Model model) {
		
		model.addAttribute("goodsCode", goodsService.getGoodsList(goodsCode));
		
		return "goods/goodsDelete";
	}
	//상품삭제
	@PostMapping("/goodsDelete")
	public String goodsDelete(GoodsDTO goodsDto,MemberDTO memberDto,Model model) {
		int result = goodsService.goodsDelete(goodsDto.getGoodsCode()
											,memberDto.getMemberId(),memberDto.getMemberPw());
		if(result == 0) {
			model.addAttribute("result","비밀번호가 불일치합니다");
			model.addAttribute("goodsCode", goodsService.getGoodsList(goodsDto.getGoodsCode()));
			model.addAttribute("memberId", memberDto.getMemberId());
			return "goods/goodsDelete";
		}
		return "redirect:/goodsList";
		
	}
	//상품 수정하기
	@GetMapping("/goodsUpdate")
	public String goodsUpdate(@RequestParam(value="goodsCode")String goodsCode,Model model) {
		model.addAttribute("goodsCode", goodsService.getGoodsList(goodsCode));	
		
		return "goods/goodsUpdate";
	}
	//수정처리
	@PostMapping("/goodsUpdate")
	public String goodsUpdate(GoodsDTO goodsDto) {
		//System.out.println(goodsDto);
		goodsService.goodsUpdate(goodsDto);
		return "redirect:/goodsList";		
	}
		 
	
	//상품상세보기
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
		model.addAttribute("gList", gList);
		return "/goods/goodsList";
	}
}
