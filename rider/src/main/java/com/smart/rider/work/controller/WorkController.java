package com.smart.rider.work.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.member.dto.MemberDTO;
import com.smart.rider.work.dto.WorkDTO;
import com.smart.rider.work.service.WorkService;

@Controller
public class WorkController {

	@Autowired
	private WorkService workService;
	
	@GetMapping("/goInsert")
	public String goInsert() {
		return "work/goInsert";
	}
	
	@GetMapping("/leaveInsert")
	public String leaveInsert() {
		return "work/leaveInsert";
	}
	@GetMapping("/workSuccess")
	public String workSuccess() {
		return "work/workSuccess";
	}
	@PostMapping("/goInsert")
	public String goInsert(@RequestParam(value="memberId") String memberId
						 , @RequestParam(value="memberPw") String memberPw
						 , WorkDTO workdto, MemberDTO memberdto, Model model) {
		
		Map<String,Object> map = workService.employeeCheck(memberdto);
		String result 			= (String) map.get("result");
		
		if(!result.equals("확인")) {
			model.addAttribute("result", result);
			System.out.println(result + "<--실패");
			return "work/goInsert";
		}
		System.out.println(result + "<--직원아이디확인");
		
		workService.goInsert(workdto);
		return "redirect:/workSuccess";
	}
	@GetMapping("/workAdmin")
	public String workList(Model model) {
		model.addAttribute("workList", workService.workList());
		return "work/workAdmin";
	}
	
	@PostMapping("/leaveInsert")
	public String leaveInsert(@RequestParam(value="memberId") String memberId
			 				, @RequestParam(value="memberPw") String memberPw
			 				, WorkDTO workdto, MemberDTO memberdto, Model model) {
		Map<String,Object> map = workService.employeeCheck(memberdto);
		String result 			= (String) map.get("result");
		
		if(!result.equals("확인")) {
			model.addAttribute("result", result);
			System.out.println(result + "<--퇴근실패");
			return "work/leaveInsert";
		}
		System.out.println(result + "<--퇴근 직원아이디확인");
		
		workService.leaveInsert(workdto);
		return "redirect:/workSuccess";
	}
}
