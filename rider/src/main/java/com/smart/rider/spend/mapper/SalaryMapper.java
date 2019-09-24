package com.smart.rider.spend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.member.dto.MemberDTO;

@Mapper
public interface SalaryMapper {
	
	// 지출_급여 직원 select box list
	public List<MemberDTO> salarySelectBox(String contractShopCode);

}
