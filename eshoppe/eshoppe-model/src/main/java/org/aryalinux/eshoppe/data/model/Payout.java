package org.aryalinux.eshoppe.data.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "payouts")
public class Payout extends BaseEntity {
	@Temporal(TemporalType.DATE)
	private Date payDate;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "payout")
	private PaySlip paySlip;
	@ManyToOne(fetch = FetchType.LAZY)
	private Employee employee;
	@ManyToOne(fetch = FetchType.LAZY)
	private Account debitAccount;
	@Column
	private String remarks;

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public PaySlip getPaySlip() {
		return paySlip;
	}

	public void setPaySlip(PaySlip paySlip) {
		this.paySlip = paySlip;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Account getDebitAccount() {
		return debitAccount;
	}

	public void setDebitAccount(Account debitAccount) {
		this.debitAccount = debitAccount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
