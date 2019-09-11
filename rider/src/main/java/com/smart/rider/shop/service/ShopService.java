package com.smart.rider.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smart.rider.shop.mapper.ShopMapper;

@Service
public class ShopService {
	@Autowired
	private ShopMapper shopMapper;
}
