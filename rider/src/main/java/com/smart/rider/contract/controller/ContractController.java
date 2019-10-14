package com.smart.rider.contract.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.rider.contract.dto.AgreementDTO;
import com.smart.rider.contract.dto.ContractDTO;
import com.smart.rider.contract.dto.ManagementDTO;
import com.smart.rider.contract.dto.UnitDTO;
import com.smart.rider.contract.service.ContractService;
import com.smart.rider.contract.service.ManagementService;
import com.smart.rider.contract.service.UnitService;
import com.smart.rider.main.dto.SearchDTO;


@Controller
public class ContractController {

	@Autowired 
	private ContractService contractService;
	@Autowired 
	private UnitService unitService;
	
	//계약관리 화면
	@GetMapping("/contract")
	public String contract(Model model,HttpSession session) {
		List<UnitDTO>  UnitDTO = contractService.unitNew();
		model.addAttribute("unitNew", contractService.unitNew());
		//System.out.println(UnitDTO.toString());
		
		return "/contract/contract";
	}
	//계약쪽 화면
	@GetMapping("/agreement")
	public String agreementList(Model model,HttpSession session) {
		//입력값 확인
		//System.out.println("=====test=====");
		//System.out.println("agreement:"+contractService.agreementList());
		model.addAttribute("agreement", contractService.agreementList(session));
		model.addAttribute("SLEVEL", (String)session.getAttribute("SLEVEL"));
		model.addAttribute("size", contractService.agreementList(session).size());
		List<UnitDTO>  UnitDTO = contractService.unitNew();
		//최근 계약 단가표 코드 session으로 받아오기
		String getContractUnitCode = null;
		if(UnitDTO.size() != 0) {
		getContractUnitCode = UnitDTO.get(0).getContractUnitCode();
		//System.out.println(getContractUnitCode + "<--최근 단가표 값 받는가 확인");
		session.setAttribute("SCUC",getContractUnitCode);
		}
		
		return "/contract/agreement";
	}
	
	//계약된 매장 목록
	@GetMapping("/contractList")
	public String contractList(Model model) {
		List<ContractDTO> contractList =  contractService.contractList();
		//System.out.println("=====test=====");
		//System.out.println("contractList:"+contractList);
		model.addAttribute("contractList", contractList);
		
		return "contract/contractList";
	}

	//계약 내용 검색
	@PostMapping("/contractSearchList")
	public String contractSearchList(SearchDTO search, Model model) {
		//System.out.println(search + "<-입력받은값");
		List<ContractDTO> contractList = contractService.contractSearchList(search);
		//System.out.println(contractList + "<- 계약내용 검색 결과값");
		model.addAttribute("contractList", contractList);
		//조회 결과가 없으면 나오는 문장
		if(contractList.size()  == 0) {
			model.addAttribute("alert", "검색 결과가 없습니다");
		}
		
		return "/contract/contractList";
	}

	//계약 생성화면
	@GetMapping("/contractInsert")
	public String contractInsert(Model model){
		List<UnitDTO> contractInsert =   contractService.unitNew();
		//System.out.println("=====test=====");
		//System.out.println("contractList:"+contractInsert);
		model.addAttribute("contractInsert", contractInsert);
		
		return "/contract/contractInsert";
	}
	
	//계약 생성하기
	@PostMapping("/contractInsert")
	public String contractInsert(ContractDTO contract,HttpSession session,ManagementDTO management) {
		//System.out.println(contract.toString() + "<-- contract.toString");
		contractService.contractInsert(contract, session, management);
		
		return "redirect:/contractList";
	}
	
	//점주 ,특정 계약코드 조회
	@GetMapping("/agreementList")
	public String getAgreementList(@RequestParam(value="contractCode")String contractCode,Model model) {
		//넘어오는코드 값 확인
		//System.out.println("계약코드값 : " + contractCode);
		//대입결과 확인
		List<AgreementDTO> getAgreementList = contractService.getAgreementList(contractCode);
		//System.out.println("getAgreementList 값 : " + getAgreementList);
		model.addAttribute("getAgreementList", getAgreementList);
		
		return "contract/agreementList";
	}
	
	//관리자 ,특정 계약코드 조회
	@GetMapping("/getContractList")
	public String getContractList(@RequestParam(value="contractCode")String contractCode
								,@RequestParam(value="contractUnitCode")String contractUnitCode
								,Model model){
		//System.out.println(contractCode + "<--계약코드 값");
		//System.out.println(contractUnitCode + "입력받은 계약단가표 값");
		List<ContractDTO> contractList = contractService.getContractList(contractCode);
		//System.out.println(contractList + "계약코드 값으로 데이터 조회 결과 확인");
		model.addAttribute("contractList", contractList);
		if(contractList != null) {
		model.addAttribute("contractMethod", contractList.get(0).getContractMethod());
		//System.out.println("납부방식에 담겨 있는값 :" +contractList.get(0).getContractMethod());
		String unitCode = contractList.get(0).getContractUnitCode();
		model.addAttribute("contractUnitCode", contractUnitCode);
		//System.out.println(unitCode + " <-- 담겨있는 코드값");
			 		}
		//수정시 계약 단가표를 수정 할 수 있게
		List<UnitDTO> uList =  unitService.unitList();
		model.addAttribute("uList", uList);
		List<UnitDTO> unitList = contractService.getUnitList(contractUnitCode);
		model.addAttribute("unitList", unitList);
		return "contract/contractUpdate";
	}

}
