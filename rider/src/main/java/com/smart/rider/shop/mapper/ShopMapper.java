package com.smart.rider.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.contract.dto.ContractDTO;
import com.smart.rider.shop.dto.ShopDTO;

@Mapper
public interface ShopMapper {

	public List<ShopDTO> shopList();
	
	public int shopInsert(ShopDTO shop);
	
	public String shopCodeMax();
	
	public List<ContractDTO> getCode(String Code);

}
