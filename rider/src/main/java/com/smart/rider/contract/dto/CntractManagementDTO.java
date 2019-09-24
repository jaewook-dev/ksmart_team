package com.smart.rider.contract.dto;

public class CntractManagementDTO {

	
	private String memberId;
	private String contractMethod;
	private int contractPay;
	private int contractManagementAmout;
	private int contractManagementUnpaid;
	private String contractManagementState;
	private String contractManagementContents;
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getContractMethod() {
		return contractMethod;
	}
	public void setContractMethod(String contractMethod) {
		this.contractMethod = contractMethod;
	}
	public int getContractPay() {
		return contractPay;
	}
	public void setContractPay(int contractPay) {
		this.contractPay = contractPay;
	}
	public int getContractManagementAmout() {
		return contractManagementAmout;
	}
	public void setContractManagementAmout(int contractManagementAmout) {
		this.contractManagementAmout = contractManagementAmout;
	}
	public int getContractManagementUnpaid() {
		return contractManagementUnpaid;
	}
	public void setContractManagementUnpaid(int contractManagementUnpaid) {
		this.contractManagementUnpaid = contractManagementUnpaid;
	}
	public String getContractManagementState() {
		return contractManagementState;
	}
	public void setContractManagementState(String contractManagementState) {
		this.contractManagementState = contractManagementState;
	}
	public String getContractManagementContents() {
		return contractManagementContents;
	}
	public void setContractManagementContents(String contractManagementContents) {
		this.contractManagementContents = contractManagementContents;
	}
	@Override
	public String toString() {
		return "CntractManagementDTO [memberId=" + memberId + ", contractMethod=" + contractMethod + ", contractPay="
				+ contractPay + ", contractManagementAmout=" + contractManagementAmout + ", contractManagementUnpaid="
				+ contractManagementUnpaid + ", contractManagementState=" + contractManagementState
				+ ", contractManagementContents=" + contractManagementContents + "]";
	}
	
	
}
