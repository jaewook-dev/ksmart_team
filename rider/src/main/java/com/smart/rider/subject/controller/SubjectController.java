package com.smart.rider.subject.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.ls.LSInput;

import com.smart.rider.main.controller.StringCheck;
import com.smart.rider.subject.dto.SubjectDTO;
import com.smart.rider.subject.service.SubjectService;

@Controller
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	// 계정과목 리스트 화면
	@GetMapping("/subjectList")
	public String subject(Model model) {
		
		// 삭제 가능한 계정과목 리스트
		List<SubjectDTO> deletePossible = subjectService.subjectDeletePossible();
		//System.out.println(deletePossible +  " <-- deletePossible subject SubjectController.java");
		model.addAttribute("deletePossible", deletePossible);
		
		// 삭제 불가능한 계정과목 리스트 (외래키 참조중)
		List<SubjectDTO> DeleteImpossible = subjectService.subjectDeleteImpossible();
		model.addAttribute("deleteImpossible", DeleteImpossible);
		
		return "subject/subjectList";
	}
	
	// 계정과목 등록 화면 이동 
	@GetMapping("/subjectInsert")
	public String subjectInsert() {
		return "subject/subjectInsert";
	}
	
	// 계정과목 등록 
	@PostMapping("/subjectInsert")
	public String subjectInsert(SubjectDTO subjectDTO, HttpSession session, Model model) {
		//System.out.println(subjectDTO.getSubjectNumber() + " <-- subjectNumber subjectInsert SubjectController.java");
		//System.out.println(subjectDTO.getSubjectName() + " <-- subjectName subjectInsert SubjectController.java");
		String memberId = (String)session.getAttribute("SID");
		
		// 문자열, 숫자 판별
		if(StringCheck.isNumeric(subjectDTO.getSubjectNumber()) == false) {
			//System.out.println("미스 매칭 subjectInsert SubjectController.java");
			model.addAttribute("alert", "계정과목코드는 숫자만 입력하세요");
			return "subject/subjectInsert";
		} else {
			subjectService.subjectInsert(subjectDTO, memberId);
			return "redirect:/subjectList";
		}
		
	}
	
	// 계정과목 수정화면
	@GetMapping("/subjectUpdate")
	public String subjectUpdate(@RequestParam(value = "subjectCode") String subjectCode, Model model) {
		List<SubjectDTO> list = subjectService.getSubjectList(subjectCode);
		//System.out.println(list + " <-- list subjectUpdate SubjectController.java");
		model.addAttribute("subjectList", list);
		return "subject/subjectUpdate";
	}

	// 계정과목 수정
	@PostMapping("/subjectUpdate")
	public String subjectUpdate(SubjectDTO subjectDTO, Model model, HttpSession session) {
		//System.out.println(subjectDTO.getSubjectCode() + " <-- subjectCode subjectUpdate SubjectController.java");
		String memberId = (String)session.getAttribute("SID");
		subjectDTO.setMemberId(memberId);
		
		List<SubjectDTO> list = subjectService.getSubjectList(subjectDTO.getSubjectCode());
		
		if(StringCheck.isNumeric(subjectDTO.getSubjectNumber()) == false) {
			model.addAttribute("alert", "계정과목코드는 숫자만 입력하세요");
			model.addAttribute("subjectList", list);
			return "subject/subjectUpdate";
		} else {
			subjectService.subjectUpdate(subjectDTO);
			return "redirect:/subjectList";
		}
	}
}
