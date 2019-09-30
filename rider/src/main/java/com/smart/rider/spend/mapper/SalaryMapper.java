package com.smart.rider.spend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.member.dto.MemberDTO;
import com.smart.rider.spend.dto.SalaryDTO;

@Mapper
public interface SalaryMapper {
	
	/*** 190930 재욱, 지출_급여 코드 자동증가용 카운트 ***/
	public String salaryCodeCount();
	
	/*** 190927 재욱, 지출_급여 내역 등록 ***/
	public int salaryInsert(SalaryDTO salaryDTO);
	
	/*** 190927 재욱, 지출_급여 직원 select box list ***/
	public List<MemberDTO> salarySelectBox(String contractShopCode);

}
