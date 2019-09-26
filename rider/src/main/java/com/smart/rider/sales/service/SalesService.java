package com.smart.rider.sales.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smart.rider.goods.dto.GoodsHapDTO;
import com.smart.rider.sales.mapper.SalesMapper;


@Service
@Transactional
public class SalesService {
	@Autowired
	private SalesMapper salesMapper;
	
	public List<GoodsHapDTO> salesList(){
		return salesMapper.salesList();
	}
}
