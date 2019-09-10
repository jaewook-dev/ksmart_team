package com.smart.rider.ex;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainMapper {
	
	public List<MemberDto> memberList();
}
