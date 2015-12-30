package org.aryalinux.eshoppe.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employeeBankAccounts")
public class BankAccount extends BaseEntity {
	@Column
	private String number;
	@Column
	private String type;
	@ManyToOne(fetch = FetchType.LAZY)
	private Payroll payroll;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Payroll getSalaryStructure() {
		return payroll;
	}

	public void setSalaryStructure(Payroll salaryStructure) {
		this.payroll = salaryStructure;
	}

}
