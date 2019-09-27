package com.smart.rider.sales.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smart.rider.goods.dto.GoodsHapDTO;
import com.smart.rider.sales.dto.SalesDTO;
import com.smart.rider.sales.mapper.SalesMapper;


@Service
@Transactional
public class SalesService {
	@Autowired
	private SalesMapper salesMapper;
	//매출등록
	public int salesInsert(SalesDTO salesDto) {
		String salesCode = "SI"+salesMapper.salesCodeCount();
		System.out.println(salesCode+"<<<<<<<<<<<<<<<<<코드확인");
		
		
		  if(salesCode.equals("SInull")) {
			  
			  salesCode = "SI0001"; 
			 }
		  salesDto.setSalesCode(salesCode);
		
		return salesMapper.salesInsert(salesDto);
		
	}
	
	//매출리스트
	public List<GoodsHapDTO> salesList(){
		return salesMapper.salesList();
	}
}
