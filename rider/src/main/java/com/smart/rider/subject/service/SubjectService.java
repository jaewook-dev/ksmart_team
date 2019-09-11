package com.smart.rider.subject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.subject.dto.SubjectDTO;
import com.smart.rider.subject.mapper.SubjectMapper;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectMapper subjectMapper;
	
	public List<SubjectDTO> subjectList(){
		return subjectMapper.subjectList();
	}

}
