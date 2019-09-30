package com.smart.rider.spend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.main.dto.SearchDTO;
import com.smart.rider.member.dto.MemberDTO;
import com.smart.rider.spend.dto.JoinSalaryDTO;
import com.smart.rider.spend.mapper.SalaryMapper;

@Service
public class SalaryService {
	
	@Autowired
	private SalaryMapper salaryMapper;
	
	
	/*** 190930 재욱, 지출_급여 등록 내역 ***/
	public Map<String, Object> salaryList(String contractShopCode, SearchDTO searchDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("contractShopCode", contractShopCode);
		map.put("searchKey", searchDTO.getSearchKey());
		map.put("searchValue", searchDTO.getSearchValue());
		map.put("beginDate", searchDTO.getBeginDate());
		map.put("endDate", searchDTO.getEndDate());
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("salaryList", salaryMapper.salaryList(map));
		return resultMap;
	}
	
	/*** 190927 재욱, 지출_급여 내역 등록 ***/
	public int salaryInsert(JoinSalaryDTO salaryDTO, String contractShopCode) {
		
		String spendSalaryCode = "SS" + salaryMapper.salaryCodeCount(); // 지출_급여 코드 자동증가
		//System.out.println(spendUtilityCode + " <-- spendUtilityCode check utilityInsert UtilityService.java");
		
		if(spendSalaryCode.equals("SSnull")) { //전체 삭제 후 다시 등록시 null을 받아오는 문제
			spendSalaryCode = "SS0001";
		}
		
		salaryDTO.setContractShopCode(contractShopCode);
		salaryDTO.setSpendSalaryCode(spendSalaryCode);
		
		return salaryMapper.salaryInsert(salaryDTO);
	}
	
	/*** 190927 재욱, 지출_급여 직원 select box list ***/
	public List<MemberDTO> salarySelectBox(String contractShopCode) {
		return salaryMapper.salarySelectBox(contractShopCode);
	}

}
