package com.smart.rider.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.smart.rider.work.service.WorkService;

@Controller
public class WorkController {

	@Autowired
	private WorkService workService;
	
	@GetMapping("/workAdmin")
	public String workAdmin() {
		return "work/workAdmin";
	}
	
	@GetMapping("/goInsert")
	public String goInsert() {
		return "work/goInsert";
	}
}
