package com.smart.rider.work.controller;

import java.util.Map;


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
	public String workList(@RequestParam(value="contractShopCode") String contractShopCode
						  ,@RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage
						  ,Model model) {
		Map<String, Object> map = workService.workList(currentPage, contractShopCode);
		
		model.addAttribute("workList", map.get("list"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("startPageNum", map.get("startPageNum"));
		model.addAttribute("lastPageNum", map.get("lastPageNum"));
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
		//System.out.println(workService.leaveInsert(workdto) + "<-----출근체크 X일때 퇴근등록");
		int fail = workService.leaveInsert(workdto);
		if(fail == 0) {
			model.addAttribute("alert", "출근등록을 하지 않았습니다!");
			return "work/leaveInsert";
		}
		workService.leaveInsert(workdto);
		return "redirect:/workSuccess";
	}
	@PostMapping("/searchWork")
	public String searchMember(@RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage
							  ,@RequestParam(value="contractShopCode") String contractShopCode
							  ,@RequestParam(value="select") String select
							  ,@RequestParam(value="searchInput") String searchInput
							  ,@RequestParam(value="beginDate") String beginDate
							  ,@RequestParam(value="endDate") String endDate
							  ,Model model) {
		System.out.println(beginDate + "~" + endDate + "<----날짜검색");
		model.addAttribute("totalWork", workService.searchTotalWork(select, searchInput, beginDate, endDate));
		Map<String, Object> map = workService.searchWork(currentPage, contractShopCode, select, searchInput, beginDate, endDate);
		model.addAttribute("workList", map.get("list"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("startPageNum", map.get("startPageNum"));
		model.addAttribute("lastPageNum", map.get("lastPageNum"));
		return "work/workAdmin";
	}
}
