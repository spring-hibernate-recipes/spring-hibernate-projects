package org.aryalinux.eshoppe.data.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "salaryStructures")
public class Payroll extends BaseEntity {
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "payroll", cascade = CascadeType.ALL)
	private List<FlexiblePayComponent> flexiblePayComponents;
	@Temporal(TemporalType.TIMESTAMP)
	private Date revisedOn;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Employee employee;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "payroll", cascade = CascadeType.ALL)
	private List<BankAccount> bankAccounts;

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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

}
