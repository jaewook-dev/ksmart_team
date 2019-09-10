package com.smart.rider.contract.dto;

public class ContractDTO {

	private String contract_code;
	private String contract_start;
	private String contract_finish;
	private String contract_valid_date;
	private String contract_state;
	private int contract_pay;
	private String contract_method;
	private int contract_amount;
	private int contract_unpaid;
	private String contract_contents;
	private String contract_information;
	private String contract_date;
	
	
	public String getContract_code() {
		return contract_code;
	}
	public void setContract_code(String contract_code) {
		this.contract_code = contract_code;
	}
	public String getContract_start() {
		return contract_start;
	}
	public void setContract_start(String contract_start) {
		this.contract_start = contract_start;
	}
	public String getContract_finish() {
		return contract_finish;
	}
	public void setContract_finish(String contract_finish) {
		this.contract_finish = contract_finish;
	}
	public String getContract_valid_date() {
		return contract_valid_date;
	}
	public void setContract_valid_date(String contract_valid_date) {
		this.contract_valid_date = contract_valid_date;
	}
	public String getContract_state() {
		return contract_state;
	}
	public void setContract_state(String contract_state) {
		this.contract_state = contract_state;
	}
	public int getContract_pay() {
		return contract_pay;
	}
	public void setContract_pay(int contract_pay) {
		this.contract_pay = contract_pay;
	}
	public String getContract_method() {
		return contract_method;
	}
	public void setContract_method(String contract_method) {
		this.contract_method = contract_method;
	}
	public int getContract_amount() {
		return contract_amount;
	}
	public void setContract_amount(int contract_amount) {
		this.contract_amount = contract_amount;
	}
	public int getContract_unpaid() {
		return contract_unpaid;
	}
	public void setContract_unpaid(int contract_unpaid) {
		this.contract_unpaid = contract_unpaid;
	}
	public String getContract_contents() {
		return contract_contents;
	}
	public void setContract_contents(String contract_contents) {
		this.contract_contents = contract_contents;
	}
	public String getContract_information() {
		return contract_information;
	}
	public void setContract_information(String contract_information) {
		this.contract_information = contract_information;
	}
	public String getContract_date() {
		return contract_date;
	}
	public void setContract_date(String contract_date) {
		this.contract_date = contract_date;
	}
	@Override
	public String toString() {
		return "ContractDTO [contract_code=" + contract_code + ", contract_start=" + contract_start
				+ ", contract_finish=" + contract_finish + ", contract_valid_date=" + contract_valid_date
				+ ", contract_state=" + contract_state + ", contract_pay=" + contract_pay + ", contract_method="
				+ contract_method + ", contract_amount=" + contract_amount + ", contract_unpaid=" + contract_unpaid
				+ ", contract_contents=" + contract_contents + ", contract_information=" + contract_information
				+ ", contract_date=" + contract_date + "]";
	}
	
	
}
