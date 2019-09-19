package com.smart.rider.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.customer.mapper.CustomerMapper;

@Service
public class CustomerService {
	@Autowired
	private CustomerMapper customerMapper;
}
