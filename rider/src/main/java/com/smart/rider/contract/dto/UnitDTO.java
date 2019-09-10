package com.smart.rider.contract.dto;

public class UnitDTO {
	
	private String contract_unit_code;
	private String contract_unit_month;
	private int contract_unit_oneyear;
	private int contract_unit_twoyear;
	private String contract_unit_date;
	
	
	public String getContract_unit_code() {
		return contract_unit_code;
	}
	public void setContract_unit_code(String contract_unit_code) {
		this.contract_unit_code = contract_unit_code;
	}
	public String getContract_unit_month() {
		return contract_unit_month;
	}
	public void setContract_unit_month(String contract_unit_month) {
		this.contract_unit_month = contract_unit_month;
	}
	public int getContract_unit_oneyear() {
		return contract_unit_oneyear;
	}
	public void setContract_unit_oneyear(int contract_unit_oneyear) {
		this.contract_unit_oneyear = contract_unit_oneyear;
	}
	public int getContract_unit_twoyear() {
		return contract_unit_twoyear;
	}
	public void setContract_unit_twoyear(int contract_unit_twoyear) {
		this.contract_unit_twoyear = contract_unit_twoyear;
	}
	public String getContract_unit_date() {
		return contract_unit_date;
	}
	public void setContract_unit_date(String contract_unit_date) {
		this.contract_unit_date = contract_unit_date;
	}
	@Override
	public String toString() {
		return "UnitDTO [contract_unit_code=" + contract_unit_code + ", contract_unit_month=" + contract_unit_month
				+ ", contract_unit_oneyear=" + contract_unit_oneyear + ", contract_unit_twoyear="
				+ contract_unit_twoyear + ", contract_unit_date=" + contract_unit_date + "]";
	}

	
}
