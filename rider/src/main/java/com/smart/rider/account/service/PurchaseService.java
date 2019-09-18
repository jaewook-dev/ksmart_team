package com.smart.rider.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.account.mapper.PurchaseMapper;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseMapper purchaseMapper;
}
