package com.smart.rider.spend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.spend.dto.JoinUtilityDTO;
import com.smart.rider.spend.dto.UtilityDTO;
import com.smart.rider.spend.dto.UtilityPay;
import com.smart.rider.spend.mapper.UtilityMapper;
import com.smart.rider.subject.dto.SubjectDTO;

@Service
public class UtilityService {
	
	@Autowired
	private UtilityMapper utilityMapper;
	
	
	// 년도에 따른 월별 공과금 지출 금액 유무 체크
	public List<JoinUtilityDTO> utilityPayCheck(String utilityYear, String contractShopCode) {
		Map<String, Object> map = new HashMap<String, Object>();

		String month = "";
		String checkMonth = "";
		for(int i=0; i<12; i++) {
			
			// DB에 들어있는 월별 데이터 비교를 위한 조건문
			if(i<9) {
				month = "0" + String.valueOf(i+1); 
			} else {
				month = String.valueOf(i+1);
			}
			//System.out.println(month + " <-- month utilityPayList UtilityService.java");
			
			checkMonth = utilityYear + "-" + month;
			//System.out.println(checkMonth + " <-- check utilityPayList UtilityService.java");
			List<JoinUtilityDTO> list = utilityMapper.utilityPayCheck(checkMonth, contractShopCode);
			//System.out.println(list + " <-- list utilityPayList UtilityService.java");
			if(list.size()==0) {
				//System.out.println(checkMonth + " <-- DB 조회 결과 없는 달");
				
			}
			
		}
		
		return utilityMapper.utilityPayCheck(checkMonth, contractShopCode);
	}
	
	// 지출_공과금 최근 등록 목록
	public List<UtilityDTO> utilityList(String contractShopCode){
		return utilityMapper.utilityList(contractShopCode);
	}
	
	// 지출_공과금 등록 계정과목 selectBox
	public List<SubjectDTO> subjectSelectBox(){
		return utilityMapper.subjectSelectBox();
	}
	
	// 지출_공과금 등록 
	public int utilityInsert(UtilityDTO utilityDTO, String contractShopCode) {
		String spendUtilityCode = "SU" + utilityMapper.utilityCodeCount(); // 지출_공과금 코드 자동증가
		//System.out.println(spendUtilityCode + " <-- spendUtilityCode check utilityInsert UtilityService.java");
		
		if(spendUtilityCode.equals("ASnull")) { //전체 삭제 후 다시 등록시 null을 받아오는 문제
			spendUtilityCode = "SU0001";
		}

		utilityDTO.setSpendUtilityCode(spendUtilityCode);
		utilityDTO.setContractShopCode(contractShopCode);
		//System.out.println(utilityDTO + " <-- utilityDTO utilityInsert UtilityService.java");
		return utilityMapper.utilityInsert(utilityDTO);
	}

}
