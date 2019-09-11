package com.smart.rider.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.member.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	public int memberInsert(MemberDTO memberdto);
	
	public List<MemberDTO> memberList();
}
