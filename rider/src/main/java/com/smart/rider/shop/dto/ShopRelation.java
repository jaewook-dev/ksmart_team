package com.smart.rider.shop.dto;

public class ShopRelation {

	
	private String contractShopCode;
	private String memberId;
	private String shopCode;
	private String use;
	
	
	
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getContractShopCode() {
		return contractShopCode;
	}
	public void setContractShopCode(String contractShopCode) {
		this.contractShopCode = contractShopCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getShopCode() {
		return shopCode;
	}
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
	
	@Override
	public String toString() {
		return "ShopRelation [contractShopCode=" + contractShopCode + ", memberId=" + memberId + ", shopCode="
				+ shopCode + ", use=" + use + "]";
	}
	
	
	
}
