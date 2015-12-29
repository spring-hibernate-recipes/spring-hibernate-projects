package org.aryalinux.eshoppe.commons;

import java.util.Date;
import java.util.List;

public class SalaryDTO extends BaseDTO {
	private String grade;
	private String panNumber;
	private String uanNumber;
	private String pfNumber;
	private Double costToCompany;
	private Double basicPay;
	private List<FlexiblePayComponentDTO> flexiblePayComponents;
	private Date revisedOn;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getUanNumber() {
		return uanNumber;
	}

	public void setUanNumber(String uanNumber) {
		this.uanNumber = uanNumber;
	}

	public String getPfNumber() {
		return pfNumber;
	}

	public void setPfNumber(String pfNumber) {
		this.pfNumber = pfNumber;
	}

	public Double getCostToCompany() {
		return costToCompany;
	}

	public void setCostToCompany(Double costToCompany) {
		this.costToCompany = costToCompany;
	}

	public Double getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(Double basicPay) {
		this.basicPay = basicPay;
	}

	public List<FlexiblePayComponentDTO> getFlexiblePayComponents() {
		return flexiblePayComponents;
	}

	public void setFlexiblePayComponents(List<FlexiblePayComponentDTO> flexiblePayComponents) {
		this.flexiblePayComponents = flexiblePayComponents;
	}

	public Date getRevisedOn() {
		return revisedOn;
	}

	public void setRevisedOn(Date revisedOn) {
		this.revisedOn = revisedOn;
	}

}
