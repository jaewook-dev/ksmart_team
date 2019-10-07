package com.smart.rider.spend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.main.dto.SearchDTO;
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
	public Map<String, Object> spendShopList(int currentPage, SearchDTO searchDTO){
		
		Map<String, Object> map = new HashMap<String, Object>();
        
        map.put("searchKey", searchDTO.getSearchKey());
		map.put("searchValue", searchDTO.getSearchValue());
		map.put("beginDate", searchDTO.getBeginDate());
		map.put("endDate", searchDTO.getEndDate());
		
		System.out.println(map.toString() + " <-- map.toString() spendShopList() SpendService.java");
		
		List<SpendAdminDTO> list = spendMapper.spendShopList(map);
		
		System.out.println(list + " <-- list spendShopList() SpendService.java");
		
		map.put("spendShopList", list);
		
		return map;
	}

}
