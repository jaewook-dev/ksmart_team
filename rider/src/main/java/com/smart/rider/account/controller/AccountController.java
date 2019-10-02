package com.smart.rider.account.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.account.dto.AccountDTO;
import com.smart.rider.account.service.AccountService;
import com.smart.rider.member.dto.MemberDTO;
import com.smart.rider.shop.dto.SsrHapDTO;



@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/accountList")
	public String account(Model model,HttpSession session) {
		
		
		//세션값 받아오지
		String sCode = (String)session.getAttribute("SCODE");
		String sLevel = (String)session.getAttribute("SLEVEL");
		System.out.println(sCode + "<-- 세션에 담긴 값");
		System.out.println(sLevel + "<-- 세션에 담긴 값");
		
		//맵으로 받기
		Map<String, Object> map =  accountService.accountList(sCode,sLevel);
		//맵에 담겨져 있는 값 가져오기
		map.get("accountListYes");
		map.get("accountListNo");
		
		//SuppressWarnings("unchecked") 메소드상태가 경고 일 때 나오지 않게 해주기
		@SuppressWarnings("unchecked")
		List<AccountDTO> accountListYes = (List<AccountDTO>)map.get("accountListYes");
		@SuppressWarnings("unchecked")
		List<AccountDTO> accountListNo = (List<AccountDTO>)map.get("accountListNo");
		System.out.println(accountListYes);
		System.out.println(accountListNo);
		
		//입력값 확인 후 모델값 값을 넣는다.
		model.addAttribute("accountListYes", accountListYes);
		model.addAttribute("accountListNo", accountListNo);


		
		return "/account/accountList";
	}
	@GetMapping("/accountInsert")
	public String accountInsert(Model model,HttpSession session) {
		//session 값 확인
		String SID = (String)session.getAttribute("SID");
		System.out.println(SID+"<----세션에 담긴 아이디 값");
		
		//model 담을 값 가져오기 및 확인
		List<SsrHapDTO> ssrList = accountService.getShopRelationCode(SID);
		System.out.println( ssrList +"<---ssrList에 담긴 값 확인");
		
		//model에 담기
		model.addAttribute("ssrList", ssrList);
		System.out.println( ssrList + "<--제대로 담겨 있는지 확인");
		
		return "/account/accountInsert";
	}
	@PostMapping("/accountInsert")
	public String accountInsert(AccountDTO account) {
		System.out.println(account +"<--accountInsert에서 넘어온  값");
		accountService.accountInsert(account);

		
		return "redirect:/accountList";
	}
	@PostMapping("/accountSearchList")
	public String accountSearchList(@RequestParam(value = "select") String select
									, @RequestParam(value = "searchName") String searchName
									, @RequestParam(value = "beginDate") String beginDate
									, @RequestParam(value = "endDate") String endDate
									, Model model) {
		//입력값 확인
		System.out.println(select+"<--선택된 값");
		System.out.println(searchName +"<-- 입력된 매장이름");
		System.out.println(beginDate+"<--시작일자");
		System.out.println(endDate+"<--종료일자");
		
		Map<String,Object> map = accountService.accountSearchList(select, searchName, beginDate, endDate);
		// model에 값 넣기
		@SuppressWarnings("unchecked")
		List<AccountDTO> accountListYes = (List<AccountDTO>)map.get("accountSearchListYes");
		@SuppressWarnings("unchecked")
		List<AccountDTO> accountListNo = (List<AccountDTO>)map.get("accountSearchListNo");
		
		System.out.println(accountListYes +"<--삭제가능리스트 확인");
		System.out.println(accountListNo +"<--삭제불가능리스트 확인");
		//model에 대입값 넣기
		model.addAttribute("accountListYes", accountListYes);
		model.addAttribute("accountListNo", accountListNo);
		//조회 결과가 없으면 나오는 문장
		if(accountListYes.size()  == 0  && accountListNo.size() == 0) {
			model.addAttribute("alert", "검색 결과가 없습니다");
		}
		
		
		return "/account/accountList";
	}
	@GetMapping("/accountUpdate")
	public String accountUpdate(@RequestParam(value="accountCode")String accountCode,Model model) {
		
		System.out.println(accountCode+"<--넘어오는 코드값 확인");
		
		//대입값 넣어서 나온 결과 updateList에 담기
		List<AccountDTO> updateList = accountService.accountUpdate(accountCode);
		System.out.println(updateList+"<--대입 결과 확인");
		//결과값 model에 담기
		model.addAttribute("updateList", updateList);
		return "account/accountUpdate";
	}
	@PostMapping("/accountUpdate")
	public String accountUpdate(AccountDTO account) {
		
		System.out.println(account+"넘어오는값확인");
		
		accountService.accountUpdateSet(account);
		
		return "redirect:/accountList";
	
	}
	@GetMapping("/accountDelete")
	public String accountDelete(@RequestParam(value="accountCode")String accountCode,
								Model model,HttpSession session) {
		
		System.out.println(accountCode+"<--넘어오는 코드값 확인");
		String SID = (String)session.getAttribute("SID");
		System.out.println(SID + "<--세션 아이디 값");
		
		//세션 값이 대입되어 나오는 결과 확인
		List<MemberDTO> memberList =  accountService.getPw(SID);
		System.out.println(memberList+ "<--조회된 값 확인");
		session.setAttribute("SACPW", memberList.get(0).getMemberPw());
		
		
		//대입값 넣어서 나온 결과 updateList에 담기
		List<AccountDTO> updateList = accountService.accountUpdate(accountCode);
		System.out.println(updateList+"<--대입 결과 확인");
		//결과값 model에 담기
		model.addAttribute("updateList", updateList);
		
		return "account/accountDelete";
	}
	@PostMapping("/accountDelete")
	public String accountDelete(@RequestParam(value="memberPw")String memberPw,
								@RequestParam(value="accountCode")String accountCode,
								HttpSession session,
								Model model){
		
		//입력되는 PW 값 과 삭제할 Code값 확인
		System.out.println(memberPw +"<--PW에 입력된 값");
		System.out.println(accountCode +"<--accountCode에 입력된 값");
		
		//삭제 확인을 위해서 변수를 선언한다.
		int deleteCk = accountService.accountDelete(memberPw, accountCode, session);
		
		//deleteCk가 0이면  삭제가 안되므로 다시 값을 가지고 삭제화면으로 리턴 시킨다.
		if(deleteCk == 0 ) {
			model.addAttribute("result", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("updateList", accountService.accountUpdate(accountCode));
	
			
			return "account/accountDelete";
		}
		
		
		return "redirect:/accountList";
		
	}
	
}
