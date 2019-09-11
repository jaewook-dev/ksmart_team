package com.smart.rider.subject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.subject.dto.SubjectDTO;

@Mapper
public interface SubjectMapper {
	
	public List<SubjectDTO> subjectList();

}
