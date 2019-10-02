package com.smart.rider.shop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.rider.contract.dto.ContractDTO;
import com.smart.rider.main.dto.SearchDTO;
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
	//매장생성시 매장계약코드 자동 생성,매장계약코드 생성시에 아이디에 있는 매장계약코드가 입력된다(수정).
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
		//ShopDTO에 자동 코드 증가 값과 아이디값 담기
		shop.setShopCode(shopCode);
		shop.setMemberId(memberId);
		//result 0으로 설정
		int result = 0;
		//result 리턴데이터를 넣는다(매장)
		result += shopMapper.shopInsert(shop);
		//shop 코드를 조회해서 가장 마지막 코드 값 가져오기
		List<ShopDTO> shopList = shopList();
		String getshopCode = shopList.get(shopList.size()-1).getShopCode();
		String getmemberId = shopList.get(shopList.size()-1).getMemberId();
		System.out.println(getshopCode);
		//세션에 담기
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
		//result에 리턴 값을 넣는다(계약매장).
		result += shopMapper.relationInsert(relation);
			
		//계약매장코드 확인 후 가장 마지막 코드 값 가져오기 및 아이디값 가져오기
		List<ShopRelationDTO> relationList = relationList();
		String getrelationCode = relationList.get(relationList.size()-1).getContractShopCode();
		String getrelationId = relationList.get(relationList.size()-1).getMemberId();
		System.out.println(getrelationCode + "리스트에 마지막에서 가져온 코드값");
		System.out.println(getrelationId + "리스트에 마지막에서 가져온 id값");

		//점주 아이디
		result += shopMapper.memberUpdate(getrelationCode,getrelationId);
		 
		return result;
	}
	//계약매장목록
	public List<ShopRelationDTO> relationList(){
		
		return shopMapper.relationList();
	};
	//POS 목록
	public List<PosDTO> posList(){
		return shopMapper.posList();
	}
	//
	//거래처 조회
	//맵으로 리턴 시키기 위해서 맵으로 선언해준다.
	public Map<String, Object> getShopList(){
		
		//맵으로 선언
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("shopListYes", shopMapper.shopListYes());
		map.put("shopListNo", shopMapper.shopListNo());

		//맵으로 리턴 시킨다.
		return map;
	}
	
	//특정 값으로 목록 조회
		public Map<String,Object> shopSearchList(SearchDTO search){
			
			//맵으로 선언
			Map<String,Object> map = new HashMap<String,Object>();

			//map 넣을 내용을 String,Object 형식으로 넣어준다.
			map.put("shopSearchListYes", shopMapper.shopSearchListYes(search));
			map.put("shopSearchListNo", shopMapper.shopSearchListNo(search));
			
			System.out.println(shopMapper.shopSearchListYes(search) + "yes서비스에서 담긴값 확인");
			System.out.println(shopMapper.shopSearchListNo(search) + " no서비스에서 담긴값 확인");
			
			return map;
	
		}
		
}
