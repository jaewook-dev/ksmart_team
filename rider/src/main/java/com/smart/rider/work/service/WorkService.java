package com.smart.rider.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.work.mapper.WorkMapper;

@Service
public class WorkService {
	
	@Autowired
	private WorkMapper workMapper;
}
