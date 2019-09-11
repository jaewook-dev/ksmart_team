package com.smart.rider.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.smart.rider.shop.service.ShopService;

@Controller
public class ShopController {

	@Autowired
	private ShopService shopService;
}
