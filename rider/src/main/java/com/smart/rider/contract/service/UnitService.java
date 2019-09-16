package com.smart.rider.contract.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.contract.dto.UnitDTO;
import com.smart.rider.contract.mapper.UnitMapper;

@Service
public class UnitService {

	@Autowired 
	private UnitMapper unitMapper;
	
	public List<UnitDTO> UnitList(){
		
		return unitMapper.UnitList();
	}
	
	public int unitInsert(UnitDTO unit,HttpSession session) {
		int max = unitMapper.UnitCodeMax()+1;
		String tempCode = "U_0";
		unit.setContractUnitCode(tempCode+max);
		
		return unitMapper.UnitInsert(unit);
	}
	
}
