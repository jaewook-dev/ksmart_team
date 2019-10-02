package com.smart.rider.account.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.account.dto.AccountDTO;
import com.smart.rider.member.dto.MemberDTO;
import com.smart.rider.shop.dto.SsrHapDTO;


@Mapper
public interface AccountMapper {
	//리스트 조회 시
	public List<AccountDTO> accountListYes(String sCode);
	public List<AccountDTO> accountListNo(String sCode);
	

	
	//가장높은코드 가져오기
	public String accountMaxCode();
	
	public List<SsrHapDTO> getShopRelationCode(String SID);
	
	public int accountInsert(AccountDTO account);
	
	//리스트 검색시
	public List<AccountDTO> accountSearchListYes(String select,String searchName,String beginDate,String endDate,String sCode);
	public List<AccountDTO> accountSearchListNo(String select,String searchName,String beginDate,String endDate,String sCode);
	
	public List<AccountDTO> accountUpdate(String acCode);
	
	public int accountUpdateSet(AccountDTO account);
	
	public List<MemberDTO> getPw(String SID);
	
	public int accountDelete(String accountCode);
	
	public List<AccountDTO> deleteNo();
	

}
