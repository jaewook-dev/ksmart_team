package com.smart.rider.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.member.dto.MemberDTO;

@Mapper
public interface EmployeeMapper {

	public int EmployeeInsert(MemberDTO memberdto);
}
