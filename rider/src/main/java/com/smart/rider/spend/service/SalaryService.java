package com.smart.rider.spend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.member.dto.MemberDTO;
import com.smart.rider.spend.mapper.SalaryMapper;

@Service
public class SalaryService {
	
	@Autowired
	private SalaryMapper salaryMapper;
	
	// 지출_급여 직원 select box list
	public List<MemberDTO> salarySelectBox(String contractShopCode) {
		return salaryMapper.salarySelectBox(contractShopCode);
	}

}
