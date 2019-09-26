package com.smart.rider.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.shop.dto.PosDTO;
import com.smart.rider.shop.dto.ShopRelationDTO;
import com.smart.rider.shop.dto.SsrHapDTO;
import com.smart.rider.shop.service.PosService;

@Controller
public class PosController {

	@Autowired
	private PosService posService;
	
	@GetMapping("/posInsert")
	public String posInsert(HttpSession session,Model model) {
		
		String memberId = (String)session.getAttribute("SID");
		System.out.println(memberId+"<--담겨있는 세션값 확인");
		
		List<SsrHapDTO> ssrList = posService.getMemberId(memberId);
		System.out.println(ssrList+"<--memberId 대입 결과");
		

		
		model.addAttribute("ssrHapList", ssrList);
		
		
		return "pos/posInsert";
	}
	@PostMapping("/posInsert")
	public String posInsert(PosDTO pos) {
		
		System.out.println(pos+"<--받아온 pos 값");
		posService.posInsert(pos);
		
		return "redirect:/shop";
	}
}
