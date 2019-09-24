package com.smart.rider.spend.dto;

public class SalaryDTO {

	private String spendSalaryCode;
	private String contractShopCode;
	private String memberId;
	private int spendSalaryPay;
	private int spendSalaryOverpay;
	private int spendSalaryBouns;
	private int spendSalaryFree;
	private int spendSalaryPlus;
	private int spendSalaryEmployee;
	private int spendSalaryShop;
	private int spendSalaryInsurance;
	private int spendSalaryMinus;
	private int spendSalaryNetpay;
	private String spendSalaryDate;
	
	public String getSpendSalaryCode() {
		return spendSalaryCode;
	}
	public void setSpendSalaryCode(String spendSalaryCode) {
		this.spendSalaryCode = spendSalaryCode;
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
	public int getSpendSalaryPay() {
		return spendSalaryPay;
	}
	public void setSpendSalaryPay(int spendSalaryPay) {
		this.spendSalaryPay = spendSalaryPay;
	}
	public int getSpendSalaryOverpay() {
		return spendSalaryOverpay;
	}
	public void setSpendSalaryOverpay(int spendSalaryOverpay) {
		this.spendSalaryOverpay = spendSalaryOverpay;
	}
	public int getSpendSalaryBouns() {
		return spendSalaryBouns;
	}
	public void setSpendSalaryBouns(int spendSalaryBouns) {
		this.spendSalaryBouns = spendSalaryBouns;
	}
	public int getSpendSalaryFree() {
		return spendSalaryFree;
	}
	public void setSpendSalaryFree(int spendSalaryFree) {
		this.spendSalaryFree = spendSalaryFree;
	}
	public int getSpendSalaryPlus() {
		return spendSalaryPlus;
	}
	public void setSpendSalaryPlus(int spendSalaryPlus) {
		this.spendSalaryPlus = spendSalaryPlus;
	}
	public int getSpendSalaryEmployee() {
		return spendSalaryEmployee;
	}
	public void setSpendSalaryEmployee(int spendSalaryEmployee) {
		this.spendSalaryEmployee = spendSalaryEmployee;
	}
	public int getSpendSalaryShop() {
		return spendSalaryShop;
	}
	public void setSpendSalaryShop(int spendSalaryShop) {
		this.spendSalaryShop = spendSalaryShop;
	}
	public int getSpendSalaryInsurance() {
		return spendSalaryInsurance;
	}
	public void setSpendSalaryInsurance(int spendSalaryInsurance) {
		this.spendSalaryInsurance = spendSalaryInsurance;
	}
	public int getSpendSalaryMinus() {
		return spendSalaryMinus;
	}
	public void setSpendSalaryMinus(int spendSalaryMinus) {
		this.spendSalaryMinus = spendSalaryMinus;
	}
	public int getSpendSalaryNetpay() {
		return spendSalaryNetpay;
	}
	public void setSpendSalaryNetpay(int spendSalaryNetpay) {
		this.spendSalaryNetpay = spendSalaryNetpay;
	}
	public String getSpendSalaryDate() {
		return spendSalaryDate;
	}
	public void setSpendSalaryDate(String spendSalaryDate) {
		this.spendSalaryDate = spendSalaryDate;
	}
	
	@Override
	public String toString() {
		return "SalaryDTO [spendSalaryCode=" + spendSalaryCode + ", contractShopCode=" + contractShopCode
				+ ", memberId=" + memberId + ", spendSalaryPay=" + spendSalaryPay + ", spendSalaryOverpay="
				+ spendSalaryOverpay + ", spendSalaryBouns=" + spendSalaryBouns + ", spendSalaryFree=" + spendSalaryFree
				+ ", spendSalaryPlus=" + spendSalaryPlus + ", spendSalaryEmployee=" + spendSalaryEmployee
				+ ", spendSalaryShop=" + spendSalaryShop + ", spendSalaryInsurance=" + spendSalaryInsurance
				+ ", spendSalaryMinus=" + spendSalaryMinus + ", spendSalaryNetpay=" + spendSalaryNetpay
				+ ", spendSalaryDate=" + spendSalaryDate + "]";
	}	
}
