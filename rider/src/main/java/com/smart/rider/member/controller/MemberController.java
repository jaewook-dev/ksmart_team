package com.smart.rider.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	//19.09.16작성
	@ResponseBody
	@RequestMapping(value = "/memberIdCheck", method = RequestMethod.POST)
	public int idCheck(@RequestParam(value="memberId") String memberId) {
		System.out.println(memberId + "아이디체크");
		
		return memberService.memberIdCheck(memberId);
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
	public String searchMember( @RequestParam(value="select") String select
							   ,@RequestParam(value="searchInput") String searchInput
							   ,Model model) {
		List<MemberDTO> search = memberService.searchMember(select, searchInput);
		model.addAttribute("memberList", search);
		return "member/memberList";
	}
	//19.09.18작성
	@RequestMapping(value="/memberDelete" , method = RequestMethod.POST)
	public String memberDelete(String memberId) {
		System.out.println("삭제 컨트롤");
		return "redirect:/memberList";
	}
	//비밀번호 수정화면 팝업으로 띄우기
	@GetMapping("/changePassword")
	public String memberPassword() {
		return "member/memberPassword";
	}
}
