package com.smart.rider.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.member.dto.MemberDTO;
import com.smart.rider.member.service.EmployeeService;
import com.smart.rider.shop.dto.SsrHapDTO;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	//19.09.15작성
	@GetMapping("/employeeInsert")
	public String employeeInsert(Model model,HttpSession session) {
		//session 값 확인
		String SID = (String)session.getAttribute("SID");
		System.out.println(SID+"<----세션에 담긴 아이디 값");
		//model 담을 값 가져오기 및 확인
		List<SsrHapDTO> ssrList = employeeService.getShopRelationCode(SID);
		System.out.println( ssrList +"<---ssrList에 담긴 값 확인");
		//model에 담기
		model.addAttribute("ssrList", ssrList);
		System.out.println( ssrList + "<--제대로 담겨 있는지 확인");	
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
	@PostMapping("/employeeDelete")
	public String employeeDelete(MemberDTO memberdto, Model model) {
		String contractShopCode = memberdto.getContractShopCode();
		int result = employeeService.employeeDelete(memberdto.getMemberId(), memberdto.getMemberPw());
		if(result == 0) {
			model.addAttribute("result", "비밀번호가 일치하지 않습니다!");
			model.addAttribute("memberId", memberdto.getMemberId());
			return "employee/employeeDelete";
		}
		return "redirect:/employeeList?contractShopCode="+contractShopCode+"";
	}
	@GetMapping("/employeeDelete")
	public String employeeDelete(@RequestParam(value="memberId") String memberId, Model model) {
		model.addAttribute("memberId", memberId);
		return "employee/employeeDelete";
	}
	//19.09.26작성
	@PostMapping("/searchEmployee")
	public String searchEmployee(@RequestParam(value="contractShopCode") String contractShopCode,
								 @RequestParam(value="select") String select,
								 @RequestParam(value="searchInput") String searchInput, Model model) {
		List<MemberDTO> searchList = employeeService.searchEmployee(contractShopCode, select, searchInput);
		model.addAttribute("employeeList", searchList);
		return "employee/employeeList";
	}
}
