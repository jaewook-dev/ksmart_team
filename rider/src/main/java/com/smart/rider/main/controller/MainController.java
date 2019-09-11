package com.smart.rider.main.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smart.rider.main.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@GetMapping("/")
	public String index(Model model) {
		
		// 재욱, 초기 index 화면 계정과목 DB 연결 확인용 추후 삭제
		Map<String, Object> map = mainService.subjectList();
		
		
		//System.out.println(map.get("subjectList") + " <-- subjectList index MainController.java");
		model.addAttribute("subjectList", map.get("subjectList"));
		model.addAttribute("unitList", map.get("unitList"));
		//영성 index화면 상품db연결 확인 (삭제용)
		//System.out.println(map.get("goodsDbList")+"<-------------goodsDbList확인----MainController.java");
		model.addAttribute("goodsDbList",map.get("goodsDbList"));
		return "index";
	}
	
	
}
