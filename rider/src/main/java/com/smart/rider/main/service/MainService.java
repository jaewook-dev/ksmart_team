package com.smart.rider.main.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.contract.dto.UnitDTO;
import com.smart.rider.main.mapper.MainMapper;
import com.smart.rider.subject.dto.SubjectDTO;

@Service
public class MainService {
	
	@Autowired
	private MainMapper mainMapper;
	
	// 재욱, 초기 index 화면 계정과목 DB 연결 확인용 추후 삭제
	public Map<String, Object> subjectList(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<SubjectDTO> list = mainMapper.subjectList();
		//System.out.println(list + " <-- list subjectList MainService.java");
		List<UnitDTO> Ulist = mainMapper.UnitList();
		//System.out.println(list + " <-- Ulist UnitList MainService.java");
		map.put("subjectList", list);
		// System.out.println(map.get("subjectList") + " <-- map.put 확인 MainService.java");
		map.put("unitList", Ulist);
		
		return map;
	}
}
