package com.smart.rider.contract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.contract.mapper.ContractMapper;

@Service
public class ContractService {
	 
	@Autowired ContractMapper contractMapper;
}
