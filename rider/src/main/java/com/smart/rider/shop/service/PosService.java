package com.smart.rider.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.shop.mapper.PosMapper;

@Service
public class PosService {

	@Autowired
	private PosMapper posMapper;
}
