package com.smart.rider.main.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.member.dto.MemberDTO;

@Mapper
public interface MainMapper {
	
	// 초기 index 화면 DB 연결 확인용 추후 삭제
	public List<MemberDTO> memberList();
}
