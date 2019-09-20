package com.smart.rider.goods.mapper;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;

import com.smart.rider.goods.dto.GoodsPurchaseDTO;

@Mapper
public interface GoodsPurchaseMapper {
	
	//코드자동증가메서드
	public String purchaseCodeCount();
	//매입inset
	public int purchaseInsert(GoodsPurchaseDTO goodsPurchaseDto);
	
	public List<GoodsPurchaseDTO> purchaseList();	
	
}
