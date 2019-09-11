package com.smart.rider.shop.dto;

public class PosDTO {

	private String posCode;
	private String shopRelationCode;
	private String posName;
	private int posNumber;
	
	public String getPosCode() {
		return posCode;
	}
	public void setPosCode(String posCode) {
		this.posCode = posCode;
	}
	public String getShopRelationCode() {
		return shopRelationCode;
	}
	public void setShopRelationCode(String shopRelationCode) {
		this.shopRelationCode = shopRelationCode;
	}
	public String getPosName() {
		return posName;
	}
	public void setPosName(String posName) {
		this.posName = posName;
	}
	public int getPosNumber() {
		return posNumber;
	}
	public void setPosNumber(int posNumber) {
		this.posNumber = posNumber;
	}
	@Override
	public String toString() {
		return "PosDTO [posCode=" + posCode + ", shopRelationCode=" + shopRelationCode + ", posName=" + posName
				+ ", posNumber=" + posNumber + "]";
	}

	
}
