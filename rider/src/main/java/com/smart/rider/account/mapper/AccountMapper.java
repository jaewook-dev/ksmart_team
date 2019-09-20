package com.smart.rider.account.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.account.dto.AccountDTO;


@Mapper
public interface AccountMapper {

	public List<AccountDTO> accountList();
}
