package com.smart.rider.member.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.member.dto.MemberDTO;
import com.smart.rider.shop.dto.SsrHapDTO;

@Mapper
public interface MemberMapper {

	public int memberInsert(MemberDTO memberdto);
	
	public List<MemberDTO> memberList(Map<String, Object> map);
	//19.09.16작성
	public int memberIdCheck(String memberId);
	
	public MemberDTO getMemberList(String memberId);
	//19.09.17작성
	public int memberUpdate(MemberDTO memberdto);
	
	public List<MemberDTO> searchMember(Map<String, Object> map);
	
	//19.09.18작성
	public int memberDelete(String memberId, String memberPw);
	//19.09.24작성
	public int levelDelete(String memberId);
	//19.09.25작성
	public int changePassword(String memberId, String memberPw, String memberPw2);
	//19.10.02 페이지작업위한 작성
	public int getMemberAllCount();
	//19.10.04검색 페이지작업
	public int getSearchAllCount(String select, String searchInput, String beginDate, String endDate, String shopCode);
	
	public List<SsrHapDTO> utilityShop();
}
