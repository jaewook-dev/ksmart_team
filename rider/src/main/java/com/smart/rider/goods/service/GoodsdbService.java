package com.smart.rider.goods.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smart.rider.goods.dto.GoodsdbDTO;
import com.smart.rider.goods.mapper.GoodsdbMapper;



@Service
@Transactional
public class GoodsdbService {
	@Autowired
	private GoodsdbMapper goodsdbmapper;

	//코드자동추가메서드를 합하여 상품db등록 메서드선언 
	//dto멤버아이디에 세션 셋팅
	//19-19-10 문영성

	public int goodsdbInsert(GoodsdbDTO goodsdbdto, HttpSession session) {
		int max = goodsdbmapper.getGoodsdbCodeMax()+1;
		String tempCode ="goods_database_code";

		goodsdbdto.setMember_id((String) session.getAttribute("SID"));
		goodsdbdto.setGoods_database_code(tempCode+max);

		return goodsdbmapper.goodsdbInsert(goodsdbdto);
		
		}

		/*
		 * 상품DB등록 확인메서드
		 * public int goodsdbInsert(GoodsdbDTO goodsdbdto) {
		 * 
		 * return goodsdbmapper.goodsdbInsert(goodsdbdto);
		 * 
		 * }
		 */

}
