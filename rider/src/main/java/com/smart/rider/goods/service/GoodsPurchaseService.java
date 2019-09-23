package com.smart.rider.goods.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smart.rider.goods.dto.GoodsHapDTO;
import com.smart.rider.goods.dto.GoodsPurchaseDTO;
import com.smart.rider.goods.mapper.GoodsPurchaseMapper;



@Service
@Transactional
public class GoodsPurchaseService {
	@Autowired
	private GoodsPurchaseMapper goodsPurchaseMapper;
	
	//매입삭제 메서드
	public int purchaseDelete(String purchaseCode,String memberId,String memberPw) {
		return goodsPurchaseMapper.purchaseDelete(purchaseCode, memberId, memberPw); 
	}
	
	//매입 검색 메서드
	public List<GoodsHapDTO> purchaseSearchList(String select, String searchInput ){
		List<GoodsHapDTO> search = goodsPurchaseMapper.purchaseSearchList(select, searchInput);
		return search;
	}
	
	//매입 상세조회
	public GoodsHapDTO getPurchaseList(String purchaseCode) {
		return goodsPurchaseMapper.getPurchaseList(purchaseCode);
	}
	
	//매입리스트
	public List<GoodsHapDTO> purchaseList(){
		return goodsPurchaseMapper.purchaseList();
	}
	
	
	//매입insert
	public int purchaseInsert(GoodsPurchaseDTO goodsPurchaseDto) {
		//코드자동증가 
		String purchaseCode = "P" + goodsPurchaseMapper.purchaseCodeCount();
		System.out.println(purchaseCode+"lllllllllllllllllllllllllll");
		
		
		if(purchaseCode.equals("Pnull")) {
			purchaseCode = "P0001";
		}
		goodsPurchaseDto.setPurchaseCode(purchaseCode);
	
		/*
		 * Map<String, Object> map = new HashMap<String, Object>();
		 * map.put("purchaseCode", goodsPurchaseDto.getPurchaseCode());
		 * map.put("accountCode", goodsPurchaseDto.getAccountCode());
		 * map.put("contractShopCode", goodsPurchaseDto.getContractShopCode());
		 * map.put("goodsDbCode", goodsPurchaseDto.getGoodsDbCode());
		 * map.put("purchasePay", goodsPurchaseDto.getPurchasePay());
		 * map.put("purchaseState", goodsPurchaseDto.getPurchaseState());
		 */
		
		return goodsPurchaseMapper.purchaseInsert(goodsPurchaseDto);		
		 
		
	}

}
