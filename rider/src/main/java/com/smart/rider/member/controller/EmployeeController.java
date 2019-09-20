package com.smart.rider.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.member.dto.MemberDTO;
import com.smart.rider.member.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	//19.09.15작성
	@GetMapping("/employeeInsert")
	public String employeeInsert() {
		return "employee/employeeInsert";
	}
	
	@PostMapping("/employeeInsert")
	public String employeeInsert(MemberDTO memberdto) {
		employeeService.employeeInsert(memberdto);
		return "redirect:/employeeList";
	}
	
	@GetMapping("/employeeList")
	public String employeeList(Model model) {
		List<MemberDTO> list = employeeService.employeeList();
		model.addAttribute("employeeList", list);
		return "employee/employeeList";
	}
	//19.09.20작성
	@GetMapping("/getEmployeeList")
	public String getEmployeeList(@RequestParam(value="memberId") String memberId, Model model) {
		model.addAttribute("getEmployeeList", employeeService.getEmployeeList(memberId));
		return "employee/employeeUpdate";
	}
	@PostMapping("/employeeUpdate")
	public String employeeUpdate(MemberDTO memberdto) {
		employeeService.employeeUpdate(memberdto);
		return "redirect:/employeeList";
	}
}
