package com.smart.rider.spend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.spend.dto.UtilityDTO;
import com.smart.rider.spend.mapper.UtilityMapper;
import com.smart.rider.subject.dto.SubjectDTO;

@Service
public class UtilityService {
	
	@Autowired
	private UtilityMapper utilityMapper;
	
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
