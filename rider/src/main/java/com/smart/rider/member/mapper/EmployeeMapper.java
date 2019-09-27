package com.smart.rider.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.member.dto.MemberDTO;
import com.smart.rider.shop.dto.SsrHapDTO;

@Mapper
public interface EmployeeMapper {
	//19.09.15작성
	public int employeeInsert(MemberDTO memberdto);
	
	public List<MemberDTO> employeeList(String contractShopCode);
	//19.09.20작성
	public MemberDTO getEmployeeList(String memberId);
	
	public int employeeUpdate(MemberDTO memberdto);
	//19.09.25작성
	public int employeeDelete(String memberId, String memberPw);
	//19.09.26작성
	public List<MemberDTO> searchEmployee(String contractShopCode, String select, String searchInput);
	
	//09.09.27 계약매장코드 
	public List<SsrHapDTO> getShopRelationCode(String SID);
}
