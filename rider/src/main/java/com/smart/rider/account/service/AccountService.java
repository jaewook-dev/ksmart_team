package com.smart.rider.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.account.mapper.AccountMapper;

@Service
public class AccountService {

	@Autowired
	private AccountMapper accountmapper;
}
