package com.smart.rider.work.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.goods.dto.GoodsDTO;
import com.smart.rider.member.dto.MemberDTO;
import com.smart.rider.member.mapper.MemberMapper;
import com.smart.rider.work.dto.WorkDTO;
import com.smart.rider.work.mapper.WorkMapper;

@Service
public class WorkService {
	
	@Autowired
	private WorkMapper workMapper;
	private MemberMapper memberMapper;
	
	public Map<String, Object> employeeCheck(MemberDTO memberdto) {
		
		String result = "";
		
		Map<String, Object> map = new HashMap<String,Object>();
		
		MemberDTO employeeCheck = workMapper.employeeCheck(memberdto);
		
		if(employeeCheck == null) {
			MemberDTO memberIdCheck = memberMapper.getMemberList(memberdto.getMemberId());
			if(memberIdCheck == null) {
				result = "등록된 아이디의 정보가 없습니다.";
			}else {
				result = "비밀번호가 일치하지 않습니다.";
			}

		}else {
			result = "확인";
			map.put("checkEmployee", employeeCheck);
		}
		
		map.put("result", result);
		
		return map;
	}
	public int goInsert(WorkDTO workdto) {
		String workCode = "W" + workMapper.workCodeCount();
		
		if(workCode.equals("Wnull")) {
			workCode = "W0001";
		}
		workdto.setWorkCode(workCode);
		return workMapper.goInsert(workdto);
	}
}
