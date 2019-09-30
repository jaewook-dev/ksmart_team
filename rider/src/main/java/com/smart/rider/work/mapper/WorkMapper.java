package com.smart.rider.work.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.member.dto.MemberDTO;
import com.smart.rider.work.dto.WorkDTO;

@Mapper
public interface WorkMapper {
	/***********************직원 출,퇴근 위한 체크**********************************/
	public MemberDTO employeeCheck(MemberDTO memberdto);
	
	public String workCodeCount();
	public int goInsert(WorkDTO workdto);
}
