package com.smart.rider.work.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.member.dto.MemberDTO;
import com.smart.rider.work.dto.WorkDTO;

@Mapper
public interface WorkMapper {
	/***********************직원 출,퇴근 위한 체크**********************************/
	public MemberDTO employeeCheck(MemberDTO memberdto);
	
	public String workCodeCount();
	
	public int goInsert(WorkDTO workdto);
	
	public List<WorkDTO> workList(Map<String, Object> map);
	
	public int leaveInsert(WorkDTO workdto);
	//페이지작업위한 목록 총 카운트
	public int getWorkAllCount(String contractShopCode);
	
	public List<WorkDTO> searchWork(Map<String, Object> map);
}
