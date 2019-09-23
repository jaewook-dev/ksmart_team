package com.smart.rider.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.member.dto.MemberDTO;

@Mapper
public interface EmployeeMapper {
	//19.09.15작성
	public int employeeInsert(MemberDTO memberdto);
	
	public List<MemberDTO> employeeList(String contractShopCode);
	//19.09.20작성
	public MemberDTO getEmployeeList(String memberId);
	
	public int employeeUpdate(MemberDTO memberdto);
}
