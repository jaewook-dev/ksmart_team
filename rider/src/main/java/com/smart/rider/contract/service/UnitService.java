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
	
	public List<UnitDTO> unitList(){
		
		return unitMapper.unitList();
	}
	

	
	public int unitInsert(UnitDTO unit,HttpSession session) {
		//전체 삭제 후 다시 등록시 null을 받아오는 문제
		String unitCode = "U"+ unitMapper.unitCodeMax();
		if(unitCode.equals("Unull")) { 
			unitCode = "U0001";
		}
		
		unit.setMemberId((String)session.getAttribute("SID"));
		unit.setContractUnitCode(unitCode);
		
		return unitMapper.unitInsert(unit);
	
	}
	
}
