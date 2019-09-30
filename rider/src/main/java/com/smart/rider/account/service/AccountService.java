package com.smart.rider.account.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.account.dto.AccountDTO;
import com.smart.rider.account.mapper.AccountMapper;
import com.smart.rider.member.dto.MemberDTO;
import com.smart.rider.shop.dto.SsrHapDTO;
import com.smart.rider.subject.dto.SubjectDTO;


@Service
public class AccountService {

	@Autowired
	private AccountMapper accountmapper;
	
	//거래처 조회
	public List<AccountDTO> accountList(){
		
		return accountmapper.accountList();
	}
	
	//세션 아이디로 조회
	public List<SsrHapDTO> getShopRelationCode(String SID){
		
		
		return accountmapper.getShopRelationCode(SID);
	}
	
	//매입거래처 생성
	public int accountInsert(AccountDTO account) {
		//매입거래처 코드 생성
		String accountCode = "AC"+ accountmapper.accountMaxCode();
		if(accountCode.equals("ACnull")) { 
			accountCode = "AC0001";
		}
		
		account.setAccountCode(accountCode);
		System.out.println(account.getAccountCode()+"<--값 담겨있는지 확인");
		
		
		return accountmapper.accountInsert(account);
	}
	//특정 값으로 목록 조회
	public List<AccountDTO> accountSearchList(String select, String searchName, String beginDate, String endDate){
		return accountmapper.accountSearchList(select, searchName, beginDate, endDate);
	}
	//특정 거래처 코드로 다른데이터 조회
	public List<AccountDTO> accountUpdate(String acCode){
		
		return accountmapper.accountUpdate(acCode);
	}
	
	//거래처 수정
	public int accountUpdateSet(AccountDTO account){
		return accountmapper.accountUpdateSet(account);
	}
	
	public List<MemberDTO> getPw(String SID){
		return accountmapper.getPw(SID);
	}
	
	public int accountDelete(String memberPw,String accountCode,HttpSession session) {
		String exactPw = (String)session.getAttribute("SACPW");
		
		if(memberPw.equals(exactPw)) {
			
			return 	accountmapper.accountDelete(accountCode);
		}else {
			accountCode = "false";
			
		}
		
		
		return 	accountmapper.accountDelete(accountCode);
	}
	
}
