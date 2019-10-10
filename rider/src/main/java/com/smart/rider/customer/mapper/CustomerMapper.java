package com.smart.rider.customer.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.customer.dto.CustomerDTO;

@Mapper
public interface CustomerMapper {

	//19.09.23작성
	public List<CustomerDTO> customerList(Map<String, Object> map);
	
	public CustomerDTO getCustomerList(String rentalCustomerCode);
	//19.10.02 페이지작업위한 작성
	public int getCustomerAllCount(String contractShopCode);
	//19.10.10
	public String customerCodeCount();
	
	public int customerInsert(CustomerDTO customerdto);
	
	public int customerUpdate(CustomerDTO customerdto);
}
