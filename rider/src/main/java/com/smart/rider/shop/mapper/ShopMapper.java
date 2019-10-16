package com.smart.rider.shop.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.smart.rider.contract.dto.ContractDTO;
import com.smart.rider.main.dto.SearchDTO;
import com.smart.rider.shop.dto.ShopDTO;
import com.smart.rider.shop.dto.ShopRelationDTO;

@Mapper
public interface ShopMapper {

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
	
	//member에 계약매장코드 수정하기
	public int memberUpdate(String getrelationCode,String getrelationId);
	
	//매장 조회 시
	public List<ShopDTO> shopListYes();
	public List<ShopDTO> shopListNo();
	
	//매장 검색시
	public List<ShopDTO> shopSearchListYes(SearchDTO serach);
	public List<ShopDTO> shopSearchListNo(SearchDTO serach);
	
	//매장리스트 전체조회(매장, 계약코드 수정시 필요)
	public List<ShopDTO> shopListAll();
	
	//명단조회
	public List<ShopDTO> shopList(Map<String, Integer> map);
	/* - shop table의 전체 행의 갯수 -
	 * @brief ShopMapper.xml(id)를 인터페이스 ShopMapper.java(메서드명)와 맵핑
	 * @return int
	 */

	//매장데이터 갯수 조회
	int selectShopCount();
	/* -insert처리-
	 * @param ShopDTO shop
	 * @brief ShopMapper.xml(id)를 인터페이스 ShopMapper.java(메서드명)와 맵핑
	 * @return int
	 */
	
	//매장 인원
	public List<ShopDTO> personnelList(String code);
	
	//코드 값으로 조회(수정)
	public List<ShopDTO> shopUpdate(String shopCode);
	
	//수정하기
	public int shopUpdateSet(ShopDTO shop);
	
	//계약코드로 수정하기
	public int shopUpdateCode(String shopCode,String contractCode);
	
	//계약코드로 데이터 조회하기
	public List<ShopDTO> shopData(String contractCode);
	
	//계약코드 수정 시 필요
	public List<ShopDTO> shopUseList();
	
	//매장계약코드 조회 시
	public List<ShopDTO> relationYes();
	public List<ShopDTO> relationNo();
		
	//매장계약코드 검색시
	public List<ShopDTO> relationSearchYes(SearchDTO search);
	public List<ShopDTO> relationSearchNo(SearchDTO search);
}

