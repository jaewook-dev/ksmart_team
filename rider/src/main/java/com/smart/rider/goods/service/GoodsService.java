package com.smart.rider.goods.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smart.rider.goods.dto.GoodsDTO;
import com.smart.rider.goods.dto.GoodsHapDTO;
import com.smart.rider.goods.mapper.GoodsMapper;

@Service
@Transactional
public class GoodsService {
	@Autowired	
	private GoodsMapper goodsMapper;
	
	//매출등록시 판매상품 상태병경
	public int goodsSalesUpdate(GoodsDTO goodsDto) {
		return goodsMapper.goodsSalesUpdate(goodsDto);
	}
	
	//삭제가능상품 리스트상세보기
	public GoodsHapDTO yesGoodsList(String goodsCode) {
		return goodsMapper.yesGoodsList(goodsCode);
	}
	//삭제 불 가능상품리스트
	public List<GoodsHapDTO> goodsNlist(String select ,String searchInput,String beginDate,String endDate){
		return goodsMapper.goodsNlist(select, searchInput, beginDate, endDate);
		}
	//삭제가능상품리스트
	public List<GoodsHapDTO> goodsYlist(String select ,String searchInput,String beginDate,String endDate){
		return goodsMapper.goodsYlist(select, searchInput, beginDate, endDate);
	}
	
	
	//상품검색추가
	public List<GoodsDTO> goodsSearchList(String select ,String searchInput,String beginDate,String endDate){
		List<GoodsDTO> search = goodsMapper.goodsSearchList(select, searchInput, beginDate, endDate);
		return search;
	}
	//상품삭제
	public int goodsDelete(String goodsCode,String memberId,String memberPw) {
		return goodsMapper.goodsDelete(goodsCode, memberId, memberPw);
	}
	
	//상품수정처리	
	public int goodsUpdate(GoodsDTO goodsDto) {
		return goodsMapper.goodsUpdate(goodsDto);
	}
	
	//판매상품 상세보기
	public GoodsHapDTO getGoodsList(String goodsCode) {
		return goodsMapper.getGoodsList(goodsCode);
	}
	
	//01판매상품 리스트조회 메서드
	//문영성
	public List<GoodsHapDTO> goodsList(){
		
		return goodsMapper.goodsList();
	}
	
	//02판매상품 등록메서드
	public int goodsInsert(GoodsDTO goodsDto) {
		String goodsCode = "G" + goodsMapper.goodsCodeCount();
		//System.out.println(goodsCode+"lllllllllllllllllllllllllll");
		
		if(goodsCode.equals("Gnull")) {
			goodsCode = "G0001";
		}
		goodsDto.setGoodsCode(goodsCode);
		return goodsMapper.goodsInsert(goodsDto);
	}
}
