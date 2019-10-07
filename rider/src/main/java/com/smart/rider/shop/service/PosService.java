package com.smart.rider.shop.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smart.rider.shop.dto.PosDTO;
import com.smart.rider.shop.dto.SsrHapDTO;
import com.smart.rider.shop.mapper.PosMapper;

@Service
public class PosService {

	@Autowired
	private PosMapper posMapper;
	
	//세션 아이디 값을 대입해서 결과값 얻기
	public List<SsrHapDTO> getMemberId(String memberId) {
		return posMapper.getMemberId(memberId);
	}
	
	//POS생성
	public int posInsert(PosDTO pos) {
		//자동코드 증가
		String posCode = "POS"+ posMapper.posCodeMax();
		if(posCode.equals("POSnull")) { 
			posCode = "POS0001";
		}
		//코드 값 DTO에 대입하기
		pos.setPosCode(posCode);
		return posMapper.posInsert(pos);
	}
	
	//계약매장코드에 해당되는 목록 보기
	public List<PosDTO> getPosList(HttpSession session){
		//로그인 된 권한 확인
		String level = (String)session.getAttribute("SLEVEL");
		System.out.println(level + "로그인된 아이디의 권한 확인");
		//로그인 된 아이디 확인
		String sid =(String)session.getAttribute("SID");
		System.out.println(sid + "로그인된 아이디 확인");
		//로그인된 아이디로 계약매장코드 가져오기
		List<SsrHapDTO> ssrList = posMapper.getMemberId(sid);
		System.out.println(ssrList + "ssrList에 담긴 값 확인");
		String contractShopCode  = ssrList.get(0).getContractShopCode();
		System.out.println(contractShopCode);
		return posMapper.getPosList(contractShopCode,level);
	}
	
	//수정할 데이터 목록
	public List<PosDTO> posUpdate(String posCode){
		return posMapper.posUpdate(posCode);
	}
	
	//입력한 값으로 수정
	public int posUpdateSet(PosDTO pos) {
		return posMapper.posUpdateSet(pos);
	}
}
