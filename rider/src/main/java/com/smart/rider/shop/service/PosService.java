package com.smart.rider.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.shop.dto.PosDTO;
import com.smart.rider.shop.dto.ShopRelationDTO;
import com.smart.rider.shop.dto.SsrHapDTO;
import com.smart.rider.shop.mapper.PosMapper;

@Service
public class PosService {

	@Autowired
	private PosMapper posMapper;
	
	public List<SsrHapDTO> getMemberId(String memberId) {
		
		return posMapper.getMemberId(memberId);
	}
	
	public int posInsert(PosDTO pos) {
		
		//자동코드 증가
		String posCode = "POS"+ posMapper.posCodeMax();
		if(posCode.equals("POSnull")) { 
			posCode = "POS0001";
		}
		
		pos.setPosCode(posCode);
 
		
		
		return posMapper.posInsert(pos);
	}
}
