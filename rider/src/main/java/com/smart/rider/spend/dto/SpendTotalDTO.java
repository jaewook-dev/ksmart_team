package com.smart.rider.spend.dto;

public class SpendTotalDTO {
	
	private String spendTotalCode;
	private String contractShopCode;
	private String purchaseCode;
	private String spendSalaryCode;
	private String spendUtilityCode;
	private String spendGroupCode;
	private String spendTotalType;
	private String spendTotalWay;
	private int	spendTotalPay;
	private String spendTotalDate;
	
	public String getSpendTotalCode() {
		return spendTotalCode;
	}
	public void setSpendTotalCode(String spendTotalCode) {
		this.spendTotalCode = spendTotalCode;
	}
	public String getContractShopCode() {
		return contractShopCode;
	}
	public void setContractShopCode(String contractShopCode) {
		this.contractShopCode = contractShopCode;
	}
	public String getPurchaseCode() {
		return purchaseCode;
	}
	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}
	public String getSpendSalaryCode() {
		return spendSalaryCode;
	}
	public void setSpendSalaryCode(String spendSalaryCode) {
		this.spendSalaryCode = spendSalaryCode;
	}
	public String getSpendUtilityCode() {
		return spendUtilityCode;
	}
	public void setSpendUtilityCode(String spendUtilityCode) {
		this.spendUtilityCode = spendUtilityCode;
	}
	public String getSpendGroupCode() {
		return spendGroupCode;
	}
	public void setSpendGroupCode(String spendGroupCode) {
		this.spendGroupCode = spendGroupCode;
	}
	public String getSpendTotalType() {
		return spendTotalType;
	}
	public void setSpendTotalType(String spendTotalType) {
		this.spendTotalType = spendTotalType;
	}
	public String getSpendTotalWay() {
		return spendTotalWay;
	}
	public void setSpendTotalWay(String spendTotalWay) {
		this.spendTotalWay = spendTotalWay;
	}
	public int getSpendTotalPay() {
		return spendTotalPay;
	}
	public void setSpendTotalPay(int spendTotalPay) {
		this.spendTotalPay = spendTotalPay;
	}
	public String getSpendTotalDate() {
		return spendTotalDate;
	}
	public void setSpendTotalDate(String spendTotalDate) {
		this.spendTotalDate = spendTotalDate;
	}
	
	@Override
	public String toString() {
		return "SpendTotalDTO [spendTotalCode=" + spendTotalCode + ", contractShopCode=" + contractShopCode
				+ ", purchaseCode=" + purchaseCode + ", spendSalaryCode=" + spendSalaryCode + ", spendUtilityCode="
				+ spendUtilityCode + ", spendGroupCode=" + spendGroupCode + ", spendTotalType=" + spendTotalType
				+ ", spendTotalWay=" + spendTotalWay + ", spendTotalPay=" + spendTotalPay + ", spendTotalDate="
				+ spendTotalDate + "]";
	}
}
