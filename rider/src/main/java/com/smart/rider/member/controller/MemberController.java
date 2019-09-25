package com.smart.rider.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@GetMapping("/memberIdCheck")
	public int idCheck(@RequestParam("memberId") String memberId) {

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
		model.addAttribute("alert", "삭제하시겠습니까?");
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
