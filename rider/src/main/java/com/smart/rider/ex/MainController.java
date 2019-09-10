package com.smart.rider.ex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<MemberDto> memberList = mainService.memberList();
		model.addAttribute("member", memberList);
		return "index";
	}
	
}
