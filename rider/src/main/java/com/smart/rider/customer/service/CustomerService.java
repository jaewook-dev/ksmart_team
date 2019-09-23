package com.smart.rider.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.customer.dto.CustomerDTO;
import com.smart.rider.customer.mapper.CustomerMapper;

@Service
public class CustomerService {
	@Autowired
	private CustomerMapper customerMapper;
	
	//19.09.23작성
	public List<CustomerDTO> customerList() {
		return customerMapper.customerList();
	}
	public CustomerDTO getCustomerList(String rentalCustomerCode) {
		return customerMapper.getCustomerList(rentalCustomerCode);
	}
}
