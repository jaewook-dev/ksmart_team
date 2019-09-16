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
	public MemberDTO memberIdCheck(String memberId) {
		return memberMapper.memberIdCheck(memberId);
	}
	
	public MemberDTO getMemberList(String memberId) {
		return memberMapper.getMemberList(memberId);
	}
}
