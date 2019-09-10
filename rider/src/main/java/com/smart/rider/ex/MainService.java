package com.smart.rider.ex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

	@Autowired
	private MainMapper mainMapper;
	
	public List<MemberDto> memberList() {
		return mainMapper.memberList();
	}
}
