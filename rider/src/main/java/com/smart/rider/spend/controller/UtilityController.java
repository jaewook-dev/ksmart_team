package com.smart.rider.spend.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.main.service.MainService;
import com.smart.rider.spend.dto.JoinUtilityDTO;
import com.smart.rider.spend.dto.UtilityDTO;
import com.smart.rider.spend.dto.UtilityPay;
import com.smart.rider.spend.service.UtilityService;
import com.smart.rider.subject.dto.SubjectDTO;

@Controller
public class UtilityController {

	@Autowired
	private UtilityService utilityService;
	
	@Autowired
	private MainService mainService;
	
	// 지출_공과금 등록내역 상세보기
	@GetMapping("/spendUtilityDetails")
	public String spendUtilityDetails(String spendUtilityCode, Model model) {
		//System.out.println(spendUtilityCode + " <-- spendUtilityCode spendUtilityDetails UtilityController.java");
		List<JoinUtilityDTO> detailsList = utilityService.utilityDetails(spendUtilityCode);
		//System.out.println(detailsList + " <-- detailsList spendUtilityDetails UtilityController.java");
		model.addAttribute("detailsList", detailsList);
		
		return "spend/spendUtilityDetails";
	}
	
	/*** 190925 재욱, 지출_공과금 검색 ***/
	@PostMapping("/spendUtilityList")
	public String utilityList(@RequestParam(value = "utilityKey") String utilityKey
							, @RequestParam(value = "utilityValue") String utilityValue
							, @RequestParam(value = "beginDate") String beginDate
							, @RequestParam(value = "endDate") String endDate
							, Model model
							, @RequestParam(value = "utilityYear", required = false, defaultValue = "2019") String utilityYear
							, @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage
							, HttpSession session) {
		
		//System.out.println(utilityKey + " < -- utilityKey utilityList() UtilityController.java");
		//System.out.println(utilityValue + " < -- utilityValue utilityList() UtilityController.java");
		//System.out.println(beginDate + " < -- beginDate utilityList() UtilityController.java");
		//System.out.println(endDate + " < -- endDate utilityList() UtilityController.java");
		
		String contractShopCode = (String)session.getAttribute("SCODE");
		
		
		/*** 190925 재욱, begin 페이징 ***/
		Map<String, Object> map = utilityService.utilityList(currentPage, contractShopCode, utilityKey, utilityValue, beginDate, endDate);
		//System.out.println(map + " <-- map spendUtility UtilityController.java");
		
		int lastPageNum = (int)map.get("lastPageNum");
		int startPageNum = (int)map.get("startPageNum");
		int lastPage = (int)map.get("lastPage");
		
		@SuppressWarnings("unchecked")
		List<UtilityDTO> utilityList = (List<UtilityDTO>)map.get("list");
		//System.out.println(utilityList + " <-- utilityList spendUtility UtilityController.java");
		
		// 검색 결과가 없을시 텍스트 알림
		if(utilityList.size()==0) {
			model.addAttribute("alert", "검색 결과가 없습니다");
		}
		
		// 페이지 번호 model.addAttribute
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("utilityList", utilityList);
		/*** 190925 재욱, end 페이징 ***/
		

		/*** 190925 재욱, 지출_공과금 등록 계정과목 select box 리스트 ***/ // 
		List<SubjectDTO> subjectList = utilityService.subjectSelectBox();
		model.addAttribute("subjectSelectBox", subjectList);
		

		/*** 190926 재욱, begin 년도에 따른 월별 공과금 지출 금액 차트 ***/
		map.put("columnDate", "spend_utility_date");	// 조회할 날짜 db 컬럼
		map.put("columnInt", "spend_utility_pay"); 		// 합산할 db 컬럼 
		map.put("chartTable", "spend_utility");			// 조회할 db 테이블명
		map.put("contractShopCode", contractShopCode);	// 검색 조건, contractShopCode
		map.put("chartYear", utilityYear);				// 검색할 연도
		
		int[] chartValueArrays = mainService.chartValue(map);
		System.out.println(Arrays.toString(chartValueArrays) + " <-- chartValueArrays spendUtility UtilityController.java");
		/*** 190926 재욱, end 년도에 따른 월별 공과금 지출 금액 차트 ***/
		
		
		return "spend/spendUtilityList";
	}

	// 지출_공과금 화면 
	@GetMapping("/spendUtilityList")
	public String spend(Model model, HttpSession session 
					  , @RequestParam(value = "utilityYear", required = false, defaultValue = "2019") String utilityYear
					  , @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage){

		String contractShopCode = (String)session.getAttribute("SCODE");
		//System.out.println(contractShopCode + " <-- contractShopCode spendUtility UtilityController.java");
		
		String utilityKey = "";
		String utilityValue = "";
		String beginDate = "";
		String endDate = "";
		
		// 페이징
		Map<String, Object> map = utilityService.utilityList(currentPage, contractShopCode, utilityKey, utilityValue, beginDate, endDate);
		//System.out.println(map + " <-- map spendUtility UtilityController.java");
		
		int lastPageNum = (int)map.get("lastPageNum");
		int startPageNum = (int)map.get("startPageNum");
		int lastPage = (int)map.get("lastPage");
		
		@SuppressWarnings("unchecked")
		List<UtilityDTO> utilityList = (List<UtilityDTO>)map.get("list");
		//System.out.println(utilityList + " <-- utilityList spendUtility UtilityController.java");
		
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);

		model.addAttribute("utilityList", utilityList);
		

		// 지출_공과금 등록 계정과목 select box 리스트
		List<SubjectDTO> subjectList = utilityService.subjectSelectBox();
		model.addAttribute("subjectSelectBox", subjectList);

		// 년도에 따른 월별 공과금 지출 금액 
		List<UtilityPay> list = utilityService.utilityPayCheck(utilityYear, contractShopCode);
		//System.out.println(list + " <-- list spendUtility UtilityController.java");
		
		
		// 년도에 따른 월별 공과금 지출 금액 유무, 값이 없을 시 0원으로 보냄
		for(int i=0; i<12; i++) {
			if(i==0) {
				if(list.get(i) == null) {
					model.addAttribute("utilityJanuary", 0);
				} else {
					model.addAttribute("utilityJanuary", list.get(i).getSumUtility());
				}
			} else if(i==1) {
				if(list.get(i) == null) {
					model.addAttribute("utilityFebruary", 0);
				} else {
					model.addAttribute("utilityFebruary", list.get(i).getSumUtility());
				}
			} else if(i==2) {
				if(list.get(i) == null) {
					model.addAttribute("utilityMarch", 0);
				} else {
					model.addAttribute("utilityMarch", list.get(i).getSumUtility());
				}
			} else if(i==3) {
				if(list.get(i) == null) {
					model.addAttribute("utilityApril", 0);
				} else {
					model.addAttribute("utilityApril", list.get(i).getSumUtility());
				}
			} else if(i==4) {
				if(list.get(i) == null) {
					model.addAttribute("utilityMay", 0);
				} else {
					model.addAttribute("utilityMay", list.get(i).getSumUtility());
				}
			} else if(i==5) {
				if(list.get(i) == null) {
					model.addAttribute("utilityJune", 0);
				} else {
					model.addAttribute("utilityJune", list.get(i).getSumUtility());
				}
			} else if(i==6) {
				if(list.get(i) == null) {
					model.addAttribute("utilityJuly", 0);
				} else {
					model.addAttribute("utilityJuly", list.get(i).getSumUtility());
				}
			} else if(i==7) {
				if(list.get(i) == null) {
					model.addAttribute("utilityAugust", 0);
				} else {
					model.addAttribute("utilityAugust", list.get(i).getSumUtility());
				}
			} else if(i==8) {
				if(list.get(i) == null) {
					model.addAttribute("utilitySeptember", 0);
				} else {
					model.addAttribute("utilitySeptember", list.get(i).getSumUtility());
				}
			} else if(i==9) {
				if(list.get(i) == null) {
					model.addAttribute("utilityOctober", 0);
				} else {
					model.addAttribute("utilityOctober", list.get(i).getSumUtility());
				}
			} else if(i==10) {
				if(list.get(i) == null) {
					model.addAttribute("utilityNovember", 0);
				} else {
					model.addAttribute("utilityNovember", list.get(i).getSumUtility());
				}
			} else if(i==11) {
				if(list.get(i) == null) {
					model.addAttribute("utilityDecember", 0);
				} else {
					model.addAttribute("utilityDecember", list.get(i).getSumUtility());
				}
			}

		}

		// 지출_공과금 차트 y축 여유 주기 위한 최대값
		List<UtilityPay> payMax = utilityService.utilityPayMax(utilityYear, contractShopCode);
		if(payMax.size() != 0) {
			model.addAttribute("payMax", payMax.get(0).getSumUtility());
		}
		

		return "spend/spendUtilityList";
	}

	// 지출_공과금 내역 등록
	@PostMapping("/utilityInsert")
	public String utilityInsert(@RequestParam(value = "subjectCode") String subjectCode ,UtilityDTO utilityDTO, HttpSession session) {
		String contractShopCode = (String)session.getAttribute("SCODE");
		//System.out.println(subjectCode + " <-- subjectCode utilityInsert UtilityController.java");
		//System.out.println(utilityDTO.getSpendUtilityPay() + " <-- getSpendUtilityPay() utilityInsert UtilityController.java");
		//System.out.println(utilityDTO.getSpendUtilityContents() + " <-- getSpendUtilityContents() utilityInsert UtilityController.java");
		utilityService.utilityInsert(utilityDTO, contractShopCode);

		return "redirect:/spendUtilityList";
	}

}
