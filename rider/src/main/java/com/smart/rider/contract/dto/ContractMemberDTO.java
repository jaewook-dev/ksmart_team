package com.smart.rider.contract.dto;


//리스트를 조회하기위해 만든 DTO(db랑 관련 없음)
public class ContractMemberDTO {
	
	private String memberId;
	private String contractStart;
	private String contractFinish;
	private String contractValidDate;
	private String memberName;
	private String memberPhone;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getContractStart() {
		return contractStart;
	}
	public void setContractStart(String contractStart) {
		this.contractStart = contractStart;
	}
	public String getContractFinish() {
		return contractFinish;
	}
	public void setContractFinish(String contractFinish) {
		this.contractFinish = contractFinish;
	}
	public String getContractValidDate() {
		return contractValidDate;
	}
	public void setContractValidDate(String contractValidDate) {
		this.contractValidDate = contractValidDate;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	
	@Override
	public String toString() {
		return "ContractMemberDTO [memberId=" + memberId + ", contractStart=" + contractStart + ", contractFinish="
				+ contractFinish + ", contractValidDate=" + contractValidDate + ", memberName=" + memberName
				+ ", memberPhone=" + memberPhone + "]";
	}

	
	
}
