package com.smart.rider.main.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.subject.dto.SubjectDTO;

@Mapper
public interface MainMapper {
	
	// 재욱, 초기 index 화면 계정과목 DB 연결 확인용 추후 삭제
	public List<SubjectDTO> subjectList();

}
