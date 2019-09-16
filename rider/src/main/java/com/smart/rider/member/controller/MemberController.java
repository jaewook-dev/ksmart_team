package com.smart.rider.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.smart.rider.member.dto.MemberDTO;
import com.smart.rider.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/memberInsert")
	public String memberInsert() {
		return "member/memberInsert";
	}
	
	@PostMapping("/memberInsert")
	public String memberInsert(MemberDTO memberdto) {
		memberService.memberInsert(memberdto);
		return "redirect:/login";
	}
	
	@GetMapping("/memberList")
	public String memberList(Model model) {
		List<MemberDTO> list = memberService.memberList();
		model.addAttribute("memberList", list);
		return "member/memberList";
	}
}
