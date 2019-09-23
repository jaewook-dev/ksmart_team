package com.smart.rider.customer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.customer.dto.CustomerDTO;

@Mapper
public interface CustomerMapper {

	//19.09.23작성
	public List<CustomerDTO> customerList();
	
	public CustomerDTO getCustomerList(String rentalCustomerCode);
}
