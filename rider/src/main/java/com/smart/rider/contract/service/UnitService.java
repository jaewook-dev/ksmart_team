package com.smart.rider.contract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.contract.mapper.UnitMapper;

@Service
public class UnitService {

	@Autowired 
	private UnitMapper unitMapper;
	
}
