package com.smart.rider.spend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.spend.dto.SpendAdminDTO;
import com.smart.rider.spend.mapper.SpendMapper;

@Service
public class SpendService {
	
	@Autowired
	private SpendMapper spendMapper;
	
	/**** 191004 재욱, Read : 관리자 확인 카운트, 2일 때 관리자 비밀번호와 점주 생년월일 일치 ****/
	public int spendAdminCheck(String contractShopCode, String memberBirth, String adminPw) {
		return spendMapper.spendAdminCheck(contractShopCode, memberBirth, adminPw);
	}
	
	/**** 191004 재욱, Read : 계약된 매장 리스트 상세보기 ****/
	public List<SpendAdminDTO> spendAdminDetails(String contractShopCode){
		return spendMapper.spendAdminDetails(contractShopCode);
	}
	
	/**** 191004 재욱, Read : 계약된 매장 리스트  ****/
	public List<SpendAdminDTO> spendAdmin(){
		return spendMapper.spendAdmin();
	}

}
