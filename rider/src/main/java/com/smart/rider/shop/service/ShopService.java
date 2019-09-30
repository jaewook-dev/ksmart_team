package com.smart.rider.shop.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.contract.dto.ContractDTO;
import com.smart.rider.shop.dto.PosDTO;
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

	public int shopInsert(ShopDTO shop,HttpSession session,ShopRelationDTO relation) {
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
		
		int result = 0;
		result += shopMapper.shopInsert(shop);
		
		//shop 코드를 조회해서 가장 마지막 코드 값 가져오기
		List<ShopDTO> shopList = shopList();
		String getshopCode = shopList.get(shopList.size()-1).getShopCode();
		String getmemberId = shopList.get(shopList.size()-1).getMemberId();
		System.out.println(getshopCode);
		session.setAttribute("SSHOPCODE",getshopCode);
		

		//자동코드 증가
		String relationCode = "SR"+ shopMapper.relationCodeMax();
		if(relationCode.equals("SRnull")) { 
			relationCode = "SR0001";
		}
		//relation 에 가장 마지막에 담은 Code 값과 id 값 담고 조합된 relationCode 생성
		relation.setContractShopCode(relationCode);
		relation.setMemberId(getmemberId);
		relation.setShopCode(getshopCode);

		result += shopMapper.relationInsert(relation);

		return result;
	}
	

	public List<ShopRelationDTO> relationList(){
		
		return shopMapper.relationList();
	};
	public List<PosDTO> posList(){
	
		return shopMapper.posList();
	}
	
}
