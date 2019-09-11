package com.smart.rider.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.smart.rider.shop.service.PosService;

@Controller
public class PosController {

	@Autowired
	private PosService posService;
}
