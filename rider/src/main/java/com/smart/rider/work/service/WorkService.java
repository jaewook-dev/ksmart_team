package com.smart.rider.work.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.member.dto.MemberDTO;
import com.smart.rider.work.dto.WorkDTO;
import com.smart.rider.work.mapper.WorkMapper;

@Service
public class WorkService{
	
	@Autowired
	private WorkMapper workMapper;
	
	public Map<String, Object> employeeCheck(MemberDTO memberdto) {
		
		String result = "";
		
		Map<String, Object> map = new HashMap<String,Object>();
		
		MemberDTO employeeCheck = workMapper.employeeCheck(memberdto);
		
		if(employeeCheck == null) {
			System.out.println(employeeCheck +"<--입력값");
			result = "아이디와 비밀번호를 확인해주세요!";
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
	/***********************19.10.01 작성******************************8*/
	public List<WorkDTO> workList() {
		return workMapper.workList();
	}

	public int leaveInsert(WorkDTO workdto) {
		return workMapper.leaveInsert(workdto);
	}
}
