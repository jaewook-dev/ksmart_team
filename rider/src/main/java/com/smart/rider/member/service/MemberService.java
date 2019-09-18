package com.smart.rider.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.member.dto.MemberDTO;
import com.smart.rider.member.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	public int memberInsert(MemberDTO memberdto) {
		return memberMapper.memberInsert(memberdto);
	}
	public List<MemberDTO> memberList() {
		List<MemberDTO> list = memberMapper.memberList();
		return list;
	}
	//19.09.16작성
	public int memberIdCheck(String memberId) {
		return memberMapper.memberIdCheck(memberId);
	}
	//member정보를 화면에 출력
	public MemberDTO getMemberList(String memberId) {
		return memberMapper.getMemberList(memberId);
	}
	//19.09.17작성
	public int memberUpdate(MemberDTO memberdto) {
		return memberMapper.memberUpdate(memberdto);
	}
	public List<MemberDTO> searchMember(String select, String searchInput) {
		List<MemberDTO> search = memberMapper.searchMember(select, searchInput);
		return search;
	}
	//19.09.18작성
	public int memberDelete(String memberId) {
		System.out.println("삭제 서비스");
		return memberMapper.memberDelete(memberId);
	}
}
