package com.smart.rider.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smart.rider.main.service.MainService;
import com.smart.rider.member.dto.MemberDTO;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@GetMapping("/")
	public String index(Model model) {
		
		// 초기 index 화면 DB 연결 확인용 추후 삭제
		List<MemberDTO> memberList = mainService.memberList();
		model.addAttribute("member", memberList);
		return "index";
	}
}
