package com.smart.rider.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.account.dto.AccountDTO;
import com.smart.rider.account.mapper.AccountMapper;


@Service
public class AccountService {

	@Autowired
	private AccountMapper accountmapper;
	
	public List<AccountDTO> accountList(){
		
		return accountmapper.accountList();
	}
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
}
