package org.aryalinux.eshoppe.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class AccountTransaction extends BaseEntity {
	@ManyToOne
	private Account account;
	@Column
	private Double amount;
	@Column
	private Date dateOfTransaction;
	@Column
	private String particulars;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public String getParticulars() {
		return particulars;
	}

	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}

}
