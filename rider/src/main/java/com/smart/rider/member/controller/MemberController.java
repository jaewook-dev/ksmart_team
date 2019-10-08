package com.smart.rider.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
	public String memberList(Model model
						    ,@RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) {
		Map<String, Object> map = memberService.memberList(currentPage);
		
		model.addAttribute("memberList", map.get("list"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("startPageNum", map.get("startPageNum"));
		model.addAttribute("lastPageNum", map.get("lastPageNum"));
		return "member/memberList";
	}
	//19.09.16작성
	@GetMapping("/memberIdCheck")
	public int idCheck(@RequestParam(value="memberId") String memberId, Model model) {
		System.out.println(memberId + "<---체크아이디");
		System.out.println(memberService.memberIdCheck(memberId) + "<---아이디체크수");
		int result = memberService.memberIdCheck(memberId);
		if(result == 1) {
			model.addAttribute("check", "사용중인 아이디입니다!");
		}
			model.addAttribute("check", "사용가능한 아이디입니다.");
		return result;
	}

	@GetMapping("/getMemberList")
	public String getMemberList(@RequestParam(value="memberId") String memberId, Model model) {
		System.out.println(memberId + "<--상세보기id");
		model.addAttribute("memberList", memberService.getMemberList(memberId));

		return "member/memberUpdate";
	}
	//19.09.17작성
	@PostMapping("/memberUpdate")
	public String memberUpdate(MemberDTO memberdto) {
		memberService.memberUpdate(memberdto);
		return "redirect:/memberList";
	}
	@PostMapping("/searchMember")
	public String searchMember(@RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage
							  ,@RequestParam(value="select") String select
							  ,@RequestParam(value="searchInput") String searchInput
							  ,@RequestParam(value="beginDate") String beginDate
							  ,@RequestParam(value="endDate") String endDate
							  ,Model model) {
		Map<String, Object> map = memberService.searchMember(currentPage, select, searchInput, beginDate, endDate);
		model.addAttribute("memberList", map.get("list"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("startPageNum", map.get("startPageNum"));
		model.addAttribute("lastPageNum", map.get("lastPageNum"));
		//List<MemberDTO> search = memberService.searchMember(select, searchInput, beginDate, endDate);
		//model.addAttribute("memberList", search);
		return "member/memberList";
	}
	//19.09.18작성
	//비밀번호 수정화면 팝업으로 띄우기
	@GetMapping("/changePassword")
	public String memberPassword(@RequestParam(value="memberId") String memberId, Model model) {
		model.addAttribute("memberId", memberId);
		return "member/memberPassword";
	}
	//19.09.20작성
	@GetMapping("/memberDelete")
	public String memberDelete(@RequestParam(value="memberId") String memberId, Model model) {
		System.out.println(memberId + "<--딜리트 아이디");
		model.addAttribute("memberId", memberId);
		return "/member/memberDelete";
	}
	//19.09.23 작성
	@PostMapping("/memberDelete")
	public String memberDelete(MemberDTO memberdto, Model model) {
		int result = memberService.memberDelete(memberdto.getMemberId(), memberdto.getMemberPw());
		if(result == 0) {
			model.addAttribute("result", "비밀번호가 일치하지 않습니다!");
			model.addAttribute("memberId", memberdto.getMemberId());
			return "member/memberDelete";
		}
		return "redirect:/memberList";
	}
	@GetMapping("/levelDelete")
	public String levelDelete(@RequestParam(value="memberId") String memberId, Model model) {
		System.out.println(memberId + "<--바로 삭제할 아이디");
		model.addAttribute("deleteMember", memberService.levelDelete(memberId));
		return "redirect:/memberList";
	}
	//19.09.25작성
	//팝업창 완료 메시지
	@GetMapping("/memberSuccess")
	public String memberSuccess() {
		return "member/memberSuccess";
	}
	@PostMapping("/updatePassword")
	public String changePassword(@RequestParam(value="memberPw2") String memberPw2, MemberDTO memberdto, Model model) {
		int result = memberService.changePassword(memberdto.getMemberId(), memberdto.getMemberPw(), memberPw2);
		if(result == 0) {
			model.addAttribute("result", "비밀번호가 일치하지 않습니다!");
			model.addAttribute("memberId", memberdto.getMemberId());
			return "member/memberPassword";
		}
		return "redirect:/memberSuccess";
	}
}
