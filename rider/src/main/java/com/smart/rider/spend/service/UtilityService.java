package com.smart.rider.spend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.spend.dto.UtilityDTO;
import com.smart.rider.spend.mapper.UtilityMapper;

@Service
public class UtilityService {
	
	@Autowired
	private UtilityMapper utilityMapper;
	
	public List<UtilityDTO> utilityList(){
		return utilityMapper.utilityList();
	}

}
