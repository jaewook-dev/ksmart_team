package com.smart.rider.main.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.member.dto.MemberDTO;

@Mapper
public interface LoginMapper {
	
	// 로그인 확인 
	public MemberDTO loginCheck(String memberId, String memberPw);

}
