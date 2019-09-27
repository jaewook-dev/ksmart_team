package com.smart.rider.account.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.account.dto.AccountDTO;
import com.smart.rider.shop.dto.SsrHapDTO;


@Mapper
public interface AccountMapper {

	public List<AccountDTO> accountList();
	
	public String accountMaxCode();
	
	public List<SsrHapDTO> getShopRelationCode(String SID);
	
	public int accountInsert(AccountDTO account);
}
