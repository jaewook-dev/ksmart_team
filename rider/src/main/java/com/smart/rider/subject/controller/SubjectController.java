package com.smart.rider.subject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smart.rider.subject.dto.SubjectDTO;
import com.smart.rider.subject.service.SubjectService;

@Controller
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/subject")
	public String subject(Model model) {
		List<SubjectDTO> list = subjectService.subjectList();
		model.addAttribute("subjectList", list);
		return "subject/subjectList";
	}

}
