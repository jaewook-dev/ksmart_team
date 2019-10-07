package com.smart.rider.spend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.rider.main.dto.SearchDTO;
import com.smart.rider.main.service.MainService;
import com.smart.rider.spend.dto.SpendAdminDTO;
import com.smart.rider.spend.service.SpendService;

@Controller
public class SpendController {
	
	@Autowired
	private SpendService spendService;

	@Autowired
	private MainService mainService;
	
	@GetMapping("/spendTotal")
	public String spendTotal(@RequestParam(value = "totalYear", required = false, defaultValue = "2019") String totalYear
							,Model model
							,HttpSession session) {
		
		String contractShopCode = (String)session.getAttribute("SCODE");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		/** 191007 재욱, Read : 지출_통합 급여 월별 총 지출 금액 차트 **/
		map.put("columnDate", "spend_salary_date");		// 조회할 날짜 db 컬럼
		map.put("columnInt", "spend_salary_total"); 	// 합산할 db 컬럼 
		map.put("chartTable", "spend_salary");			// 조회할 db 테이블명
		map.put("contractShopCode", contractShopCode);	// 검색 조건, contractShopCode
		map.put("chartYear", totalYear);				// 검색할 연도
		
		int[] salaryChartArrays = mainService.chartValue(map);
		//System.out.println(Arrays.toString(salaryChartArrays) + " <-- salaryChartArrays spendTotal() SpendController.java");
		
		// to view model.addAttribute
		for(int i=0; i<12; i++) { 
			String salaryChart = "salary" + String.valueOf(i);
			model.addAttribute(salaryChart, salaryChartArrays[i]);
		}
		
		/** 191007 재욱, Read : 지출_통합 공과금/기타 월별 총 지출 금액 차트 **/
		map.put("columnDate", "spend_utility_date");	// 조회할 날짜 db 컬럼
		map.put("columnInt", "spend_utility_pay"); 	// 합산할 db 컬럼 
		map.put("chartTable", "spend_utility");			// 조회할 db 테이블명
		map.put("contractShopCode", contractShopCode);	// 검색 조건, contractShopCode
		map.put("chartYear", totalYear);				// 검색할 연도
		
		int[] utilityChartArrays = mainService.chartValue(map);
		//System.out.println(Arrays.toString(utilityChartArrays) + " <-- utilityChartArrays spendTotal SpendController.java");
		
		// to view model.addAttribute
		for(int i=0; i<12; i++) { 
			String utilityChart = "utility" + String.valueOf(i);
			model.addAttribute(utilityChart, utilityChartArrays[i]);
		}
		
		/** 191007 재욱, Read : 지출_통합 매입 월별 총 지출 금액 차트 **/
		map.put("columnDate", "purchase_date");	// 조회할 날짜 db 컬럼
		map.put("columnInt", "purchase_pay"); 	// 합산할 db 컬럼 
		map.put("chartTable", "purchase");			// 조회할 db 테이블명
		map.put("contractShopCode", contractShopCode);	// 검색 조건, contractShopCode
		map.put("chartYear", totalYear);				// 검색할 연도
		
		int[] purchaseChartArrays = mainService.chartValue(map);
		//System.out.println(Arrays.toString(purchaseChartArrays) + " <-- purchaseChartArrays spendTotal() SpendController.java");
		
		// to view model.addAttribute
		for(int i=0; i<12; i++) { 
			String purchaseChart = "purchase" + String.valueOf(i);
			model.addAttribute(purchaseChart, purchaseChartArrays[i]);
		}
		
		model.addAttribute("selectedYear", totalYear);
		
		return "spend/spendTotal";
	}
	
	/**** 191007 재욱, 매장 지출 관리하기 화면이동 ****/
	@PostMapping("/spendAdmin")
	public String spendAdmin() {
		return "spend/spendTotal";
	}
	
	
	/**** 191004 재욱, Modal ajax 호출, 관리자 확인 카운트, 2일 때 관리자 비밀번호와 점주 생년월일 일치 ****/
	@RequestMapping(value = "/adminCheck") // 요청에 반응하는 url
	public @ResponseBody int adminCheck(String contractShopCode, String memberBirth, String adminPw) {
		//System.out.println(contractShopCode + memberBirth + adminPw + " <-- check adminCheck() SpendController.java" );
		int result = spendService.spendAdminCheck(contractShopCode, memberBirth, adminPw); // DB 조회 결과
		//System.out.println(result + " <-- result adminCheck() SpendController.java"); 
		
		return result;
	}
	
	/**** 191004 재욱, Read : 계약된 매장 리스트 상세보기 ****/
	@GetMapping("/spendShopDetails")
	public String spendAdminDetails(String contractShopCode, Model model) {
		//System.out.println(contractShopCode + " <-- contractShopCode spendAdminDetails() SpendController.java");
		List<SpendAdminDTO> list = spendService.spendAdminDetails(contractShopCode);
		model.addAttribute("detailsList", list);
		return "spend/spendShopDetails";
	}
	
	/**** 191007 재욱, Read : 계약된 매장 검색 리스트 ****/
	@PostMapping("/spendShopList")
	public String spendShopList(@RequestParam(value =  "currentPage", required = false, defaultValue = "1") int currentPage
							   ,Model model
							   ,SearchDTO searchDTO) {
		System.out.println(searchDTO.getSearchKey() + " <-- searchDTO.getSearchKey() spendShopList() SpendController.java");
		System.out.println(searchDTO.getSearchValue() + " <-- searchDTO.getSearchKey() spendShopList() SpendController.java");
		System.out.println(searchDTO.getBeginDate() + " <-- searchDTO.getSearchKey() spendShopList() SpendController.java");
		System.out.println(searchDTO.getEndDate() + " <-- searchDTO.getSearchKey() spendShopList() SpendController.java");
		this.spendShop(currentPage, model, searchDTO);
		
		return "spend/spendShopList";
	}
	
	/**** 191004 재욱, Read : 계약된 매장 리스트 ****/
	@GetMapping("/spendShopList")
	public String spendShop(@RequestParam(value =  "currentPage", required = false, defaultValue = "1") int currentPage
							,Model model
							,SearchDTO searchDTO) {
		Map<String, Object> map = spendService.spendShopList(currentPage, searchDTO);
		List<SpendAdminDTO> list = (List<SpendAdminDTO>)map.get("spendShopList");
		//System.out.println(list + " <-- list spendAdmin() SpendController.java");
		model.addAttribute("shopList", list);
		return "spend/spendShopList";
	}

}
