package com.smart.rider.shop.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.smart.rider.contract.dto.ContractDTO;
import com.smart.rider.contract.service.ContractService;
import com.smart.rider.main.dto.SearchDTO;
import com.smart.rider.shop.dto.PosDTO;
import com.smart.rider.shop.dto.ShopDTO;
import com.smart.rider.shop.dto.ShopRelationDTO;
import com.smart.rider.shop.service.ShopService;

@Controller
public class ShopController {

	@Autowired
	private ShopService shopService;
	@Autowired
	private ContractService contractService;
	//매장 관리쪽 목록들 받기

	//매장으로 넘어 갈때 필요한 값들
	@GetMapping("/shopInsert")
	public String shopInsert(Model model) {
		List<ContractDTO> contractList =  contractService.contractList();
        		
		//필요한 contractList에 담긴 값을 가져오기 위해 model 사용
		System.out.println("contractList:"+contractList);
		model.addAttribute("contractList", contractList);
		 
		return  "/shop/shopInsert";
	}
	//매장 생성
	@PostMapping("/shopInsert")
	public String shopInsert(ShopDTO shop,HttpSession session,ShopRelationDTO relation) {

		
		System.out.println(shop.toString()+"<-담겨있는값");
		shopService.shopInsert(shop,session,relation);
		
		
		return "redirect:/shop";
	}
	//수정입력 값 받기
	@GetMapping("/shopUpdate")
	public String shopUpdate(@RequestParam(value ="shopCode") String shopCode,Model model) {
		
		System.out.println(shopCode + "<--넘어오는 코드값 확인");
		List<ShopDTO> shopList = shopService.shopUpdate(shopCode);
		System.out.println(shopList + "<--코드로 조회하는 데이터 확인");
		
		model.addAttribute("shopList", shopList);
		return "shop/shopUpdate";
	}
	//수정
	@PostMapping("/shopUpdate")
	public String shopUpdate(ShopDTO shop) {
		System.out.println(shop + "<--  수정된 값");
		
		shopService.shopUpdateSet(shop);
		
		return "redirect:/shop";
	}
	
	//상세보기
	@GetMapping("/shopList")
	public String getShopList(Model model,HttpSession session) {
		//맵으로 받기
		Map<String, Object> map =  shopService.getShopList();

		//SuppressWarnings("unchecked") 메소드상태가 경고 일 때 나오지 않게 해주기
		@SuppressWarnings("unchecked")
		List<ShopDTO> shopListYes = (List<ShopDTO>)map.get("shopListYes");
		@SuppressWarnings("unchecked")
		List<ShopDTO> shopListNo = (List<ShopDTO>)map.get("shopListNo");
		System.out.println(shopListYes);
		System.out.println(shopListNo);
		
		//입력값 확인 후 모델값 값을 넣는다.
		model.addAttribute("shopListYes", shopListYes);
		model.addAttribute("shopListNo", shopListNo);
		

		return "shop/shopList";
	}
	//상세보기에서 검색시
	@PostMapping("/shopSearchList")
	public String shopSearchList(SearchDTO search, Model model) {
		System.out.println(search + "<-- 담겨있는값 ");
		
		
		Map<String,Object> map = shopService.shopSearchList(search);
		// model에 값 넣기
		@SuppressWarnings("unchecked")
		List<ShopDTO> shopListYes = (List<ShopDTO>)map.get("shopSearchListYes");
		@SuppressWarnings("unchecked")
		List<ShopDTO> shopListNo = (List<ShopDTO>)map.get("shopSearchListNo");
		
		System.out.println(shopListYes +"<--삭제가능리스트 확인");
		System.out.println(shopListNo +"<--삭제불가능리스트 확인");
		//model에 대입값 넣기
		model.addAttribute("shopListYes", shopListYes);
		model.addAttribute("shopListNo", shopListNo);
		//조회 결과가 없으면 나오는 문장
		if(shopListYes.size()  == 0  && shopListNo.size() == 0) {
			model.addAttribute("alert", "검색 결과가 없습니다");
		}
			
		return "shop/shopList";
	}
	
	
	//매장 목록 5개씩 보여주기
	@GetMapping("/shop")
	public String shop(@RequestParam(value="currentPage",required=false, defaultValue="1") int currentPage
						,Model model,HttpSession session) {
		//값 확인
		List<ShopRelationDTO> srList = shopService.relationList();
		List<PosDTO> pList = shopService.posList();
		List<ShopDTO> personnelList = shopService.personnelList(session);
		System.out.println("relationList"+srList );
		System.out.println("posList" + pList);
		System.out.println("personnelList" + personnelList);
		
		
		Map<String, Object> returnMap = shopService.shopList(currentPage);
    	//Map객체주소로 보내는 경우(model.addAttribute("map", returnMap);
		System.out.println(returnMap + " map 담긴 값 확인 ");
		
		//returnMap(Map타입 객체)에 담겨있는 값 -> model(Model타입 객체)에 복사 ->  view전달
		//매장 목록
    	model.addAttribute("shopList", returnMap.get("list"));
    	//현재 페이지
    	model.addAttribute("currentPage",returnMap.get("currentPage"));
    	//마지막페이지
    	model.addAttribute("lastPage",returnMap.get("lastPage"));	
    	//계약매장 목록
		model.addAttribute("relationList", srList);
		//pos 목록
		model.addAttribute("posList", pList);
		//매장인원 목록
		model.addAttribute("personnelList", personnelList);
		
		return "/shop/shop";
	}
	
	


}
