package com.smart.rider.goods.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smart.rider.goods.dto.GoodsPurchaseDTO;
import com.smart.rider.goods.mapper.GoodsPurchaseMapper;



@Service
@Transactional
public class GoodsPurchaseService {
	@Autowired
	private GoodsPurchaseMapper goodsPurchaseMapper;
	
	//매입리스트
	public List<GoodsPurchaseDTO> purchaseList(){
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
