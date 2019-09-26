package com.smart.rider.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.contract.dto.ContractDTO;
import com.smart.rider.shop.dto.PosDTO;
import com.smart.rider.shop.dto.ShopDTO;
import com.smart.rider.shop.dto.ShopRelationDTO;

@Mapper
public interface ShopMapper {

	//명단조회
	public List<ShopDTO> shopList();
	
	//shop코드 생성 및 데이터생성
	public int shopInsert(ShopDTO shop);
	
	//데이터중 가장 높은 데이터가져오기
	public String shopCodeMax();
	
	//데이터중 가장 높은 데이터가져오기
	public String relationCodeMax();	
	
	//contractDTO에서 Code를 대입해서 나오는값 가져오기
	public List<ContractDTO> getCode(String Code);
	
	//ShopDTO에서 Code를 대입해서 나오는값 가져오기
	public List<ShopDTO> getScode(String Code);
	
	//relation코드 및 데이터 생성
	public int relationInsert(ShopRelationDTO relation);
	
	//ShopRelationDTO 조회
	public List<ShopRelationDTO> relationList();
	
	//posDTO 조회
	public List<PosDTO> posList();
}
