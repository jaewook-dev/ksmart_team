package com.smart.rider.spend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.spend.dto.UtilityDTO;
import com.smart.rider.spend.dto.UtilityPay;
import com.smart.rider.subject.dto.SubjectDTO;

@Mapper
public interface UtilityMapper {
	
	// 지출_공과금 최근 등록 목록
	public List<UtilityDTO> utilityList(String contractShopCode);
	
	// 지출_공과금 등록 계정과목 selectBox
	public List<SubjectDTO> subjectSelectBox();
	
	// 지출_공과금 등록 
	public int utilityInsert(UtilityDTO utilityDTO);
	
	// 지출_공과금 코드 카운트
	public String utilityCodeCount();
	
	// 년도에 따른 월별 공과금 지출 금액 
	public List<UtilityPay> utilityPayMax(String utilityYear, String contractShopCode);
	
	// 년도에 따른 월별 공과금 지출 금액 유무 체크
	public List<UtilityPay> utilityPayCheck(String checkMonth, String contractShopCode);

}
