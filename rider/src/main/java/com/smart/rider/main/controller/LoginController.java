package com.smart.rider.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "/login/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam(value = "membeId") String memberId
						,@RequestParam(value = "memberPw") String memberPw
						,Model model) {
		System.out.println(memberId + " <-- memberId login");
		return "redirect:/";
	}
}
