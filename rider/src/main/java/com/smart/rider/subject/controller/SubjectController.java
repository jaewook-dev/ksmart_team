package com.smart.rider.subject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.subject.dto.SubjectDTO;
import com.smart.rider.subject.service.SubjectService;

@Controller
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	// 계정과목 리스트 화면
	@GetMapping("/subjectList")
	public String subject(Model model) {
		List<SubjectDTO> list = subjectService.subjectList();
		model.addAttribute("subjectList", list);
		return "subject/subjectList";
	}
	
	// 계정과목 등록 화면 이동 
	@GetMapping("/subjectInsert")
	public String subjectInsert() {
		return "subject/subjectInsert";
	}
	
	// 계정과목 등록 
	@PostMapping("/subjectInsert")
	public String subjectInsert(SubjectDTO subjectDTO) {
		//System.out.println(subjectDTO.getSubjectNumber() + " <-- subjectNumber subjectInsert SubjectController.java");
		//System.out.println(subjectDTO.getSubjectName() + " <-- subjectName subjectInsert SubjectController.java");
		subjectService.subjectInsert(subjectDTO);
		
		return "redirect:/subjectList";
	}

}
