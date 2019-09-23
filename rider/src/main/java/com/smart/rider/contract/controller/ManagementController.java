package com.smart.rider.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.smart.rider.contract.service.ManagementService;

@Controller
public class ManagementController {

	@Autowired
	private ManagementService managementService;
}
