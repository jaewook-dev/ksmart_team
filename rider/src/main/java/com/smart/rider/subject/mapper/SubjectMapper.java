package com.smart.rider.subject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.subject.dto.SubjectDTO;

@Mapper
public interface SubjectMapper {
	
	//계정과목관리, 계정과목 리스트 화면
	public List<SubjectDTO> subjectList();
	
	//계정과목코드 자동증가
	public String subjectCodeCount();
	
	//계정과목 등록
	public int subjectInsert(SubjectDTO subjectDTO);
	
	//계정과목 삭제
	public int subjectDelete(String subjectCode);

	//계정과목 수정화면
	public List<SubjectDTO> subjectList(String subjectCode);
	
	//계정과목 수정
	public int subjectUpdate(SubjectDTO subjectDTO);
}
