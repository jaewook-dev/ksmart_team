package com.smart.rider.spend.dto;

public class UtilityPay {

	private String payMonth;
	private int sumUtility;
	
	public String getPayMonth() {
		return payMonth;
	}
	public void setPayMonth(String payMonth) {
		this.payMonth = payMonth;
	}
	public int getSumUtility() {
		return sumUtility;
	}
	public void setSumUtility(int sumUtility) {
		this.sumUtility = sumUtility;
	}
	
	@Override
	public String toString() {
		return "utilityPay [payMonth=" + payMonth + ", sumUtility=" + sumUtility + "]";
	}
}
