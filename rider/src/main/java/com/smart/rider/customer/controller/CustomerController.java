package com.smart.rider.customer.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.customer.dto.CustomerDTO;
import com.smart.rider.customer.service.CustomerService;
import com.smart.rider.goods.dto.GoodsHapDTO;
import com.smart.rider.goods.service.GoodsRentalService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private GoodsRentalService goodsRentalService;
	
	//19.09.20작성
	@GetMapping("/customerInsert")
	public String customerInsert() {
		return "customer/customerInsert";
	}
	//19.10.10작성
	@PostMapping("/customerInsert")
	public String customerInsert(CustomerDTO customerdto) {
		customerService.customerInsert(customerdto);
		return "redirect:/customerList";
	}
	//19.09.23작성
	@GetMapping("/getCustomerList")
	public String getCustomerList(@RequestParam(value="rentalCustomerCode") String rentalCustomerCode, Model model) {
		model.addAttribute("customerList", customerService.getCustomerList(rentalCustomerCode));
		return "customer/customerUpdate";
	}
	//19.10.02 페이지 작업
	@GetMapping("/customerList")
	public String customerList(Model model
							,@RequestParam(value="contractShopCode", defaultValue="") String contractShopCode
							 , @RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) {
		Map<String, Object> map = customerService.customerList(currentPage, contractShopCode);
		
		model.addAttribute("customerList", map.get("list"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("startPageNum", map.get("startPageNum"));
		model.addAttribute("lastPageNum", map.get("lastPageNum"));
		return "customer/customerList";
	}
	//19.10.10 작성 대여상품 리스트가져오기
	@GetMapping("/rentalGoodsList")
	public String rentalGoodsList(Model model,HttpSession session) {
		String select = null;
		String searchInput = "";
		String beginDate = "";
		String endDate = "";
		String SCODE = (String)session.getAttribute("SCODE");
		String SLEVEL = (String)session.getAttribute("SLEVEL");
		Map<String, Object> map = goodsRentalService.goodsRentalList(select, searchInput, beginDate, endDate, SCODE, SLEVEL);
		@SuppressWarnings("unchecked")
		List<GoodsHapDTO> rList = (List<GoodsHapDTO>)map.get("rList");
		
		model.addAttribute("rList", rList);
		return "customer/rentalGoodsList";
	}
	@GetMapping("/rentalGoodsDetail")
	public String goodsRentalUpdate(@RequestParam(value="goodsRentalCode")String goodsRentalCode,Model model) {
		model.addAttribute("goodsRentalCode", goodsRentalService.getGoodsRentalList(goodsRentalCode));
		return "customer/rentalGoodsDetail";
	}
	@PostMapping("/customerUpdate")
	public String customerUpdate(CustomerDTO customerdto) {
		customerService.customerUpdate(customerdto);
		return "redirect:/customerList";
	}
}
