package com.smart.rider.goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.goods.dto.GoodsdbDTO;

@Mapper
public interface GoodsdbMapper {
	
	//상품DB삭제 메서드 문영성
	//상품코드.아이디,비밀번호가져오기
	public int goodsDbDelete(String goodsDbCode,String memberId,String memberPw);
	
	//상품코드자동추가하기위한 메서드 문영성
	public int getGoodsDbCodeMax();
	
	//상품DB등록하기 
	//날짜 19-09-10 문영성
	public int goodsDbInsert(GoodsdbDTO goodsdbdto);
	
	//상품DB리스트조회 메서드 문영성
	public List<GoodsdbDTO> goodsDbList();
	
	//상품코드로 상품DB상제조회 메서드 문영성
	public GoodsdbDTO getGoodsDbCode(String goodsDbCode);
	//상품 검색 매서드 문영성
	//19-09-18
	public List<GoodsdbDTO> goodsDbSearchList(String select ,String searchInput,String beginDate,String endDate);
}
