package com.smart.rider.contract.service;

import java.util.List;

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
	
}
