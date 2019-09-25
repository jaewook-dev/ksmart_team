package com.smart.rider.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		System.out.println(memberdto.getContractShopCode() + "<---릴레코드");
		String contractShopCode = memberdto.getContractShopCode();
		employeeService.employeeInsert(memberdto);
		return "redirect:/employeeList?contractShopCode="+contractShopCode+"";
	}
	
	@GetMapping("/employeeList")
	public String employeeList(@RequestParam(value="contractShopCode") String contractShopCode, Model model) {
		List<MemberDTO> list = employeeService.employeeList(contractShopCode);
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
		String contractShopCode = memberdto.getContractShopCode();
		employeeService.employeeUpdate(memberdto);
		return "redirect:/employeeList?contractShopCode="+contractShopCode+"";
	}
	//19.09.25작성
	
}
