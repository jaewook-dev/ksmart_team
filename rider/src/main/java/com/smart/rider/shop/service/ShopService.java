package com.smart.rider.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.contract.dto.ContractDTO;
import com.smart.rider.shop.dto.ShopDTO;
import com.smart.rider.shop.dto.ShopRelationDTO;
import com.smart.rider.shop.mapper.ShopMapper;

@Service
public class ShopService {
	@Autowired
	private ShopMapper shopMapper;

	public List<ShopDTO> shopList() {

		return shopMapper.shopList();
	}

	public int shopInsert(ShopDTO shop) {
		// 담겨있는 contractCode로 contractDTO조회
		String contractCode = shop.getContractCode();
		System.out.println(contractCode + "-->담겨 있는 값");
		// 조회된 값에서 id만 가져오기 및 확인작업
		List<ContractDTO> List = shopMapper.getCode(contractCode);
		System.out.println(List + "<--담긴 데이터");
		String memberId = List.get(0).getMemberId();
		System.out.println(memberId+"<--담긴 ID값");
		 
		//자동코드 증가
		String shopCode = "S"+ shopMapper.shopCodeMax();
		if(shopCode.equals("Cnull")) { 
			shopCode = "S0001";
		}

		shop.setShopCode(shopCode);
		shop.setMemberId(memberId);
		 

		return shopMapper.shopInsert(shop);
	}
	public int relationInsert(ShopRelationDTO relation) {
		// relation에 담겨 있는 값으로 id 조회하기
		String shopCode = relation.getShopCode();
		System.out.println(shopCode + "-->담겨 있는 값");
		// 조회된 값에서 id값만 가져오기 및 확인작업
		List<ShopDTO> List = shopMapper.getScode(shopCode);
		System.out.println(List + "<--담긴 데이터");
		String memberId = List.get(0).getMemberId();
		System.out.println(memberId+"<--담긴 ID값");
		 
		//자동코드 증가
		String relationCode = "SR"+ shopMapper.relationCodeMax();
		if(relationCode.equals("SRnull")) { 
			relationCode = "SR0001";
		}

		relation.setContractShopCode(relationCode);
		relation.setMemberId(memberId);
		 

		return shopMapper.relationInsert(relation);
	}
	
	
}
