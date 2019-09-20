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
}
