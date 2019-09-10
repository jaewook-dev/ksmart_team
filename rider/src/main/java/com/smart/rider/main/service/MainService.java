package com.smart.rider.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.main.mapper.MainMapper;
import com.smart.rider.member.dto.MemberDTO;

@Service
public class MainService {
	
	@Autowired
	private MainMapper mainMapper;
	
	// 초기 index 화면 DB 연결 확인용 추후 삭제
	public List<MemberDTO> memberList() {
		return mainMapper.memberList();
	}

}
