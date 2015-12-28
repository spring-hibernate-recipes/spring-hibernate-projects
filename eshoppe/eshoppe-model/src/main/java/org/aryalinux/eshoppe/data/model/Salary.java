package org.aryalinux.eshoppe.data.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Salary extends BaseEntity {
	@Column
	private String grade;
	@Column
	private String panNumber;
	@Column
	private String uanNumber;
	@Column
	private String pfNumber;
	@Column
	private Double costToCompany;
	@Column
	private Double basicPay;
	@OneToMany
	private List<FlexiblePayComponent> flexiblePayComponents;
	@Temporal(TemporalType.TIMESTAMP)
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

	public Date getRevisedOn() {
		return revisedOn;
	}

	public void setRevisedOn(Date revisedOn) {
		this.revisedOn = revisedOn;
	}

	public List<FlexiblePayComponent> getFlexiblePayComponents() {
		return flexiblePayComponents;
	}

	public void setFlexiblePayComponents(List<FlexiblePayComponent> flexiblePayComponents) {
		this.flexiblePayComponents = flexiblePayComponents;
	}

}
