package org.aryalinux.eshoppe.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account extends BaseEntity {
	@Column
	private String description;
	@Column
	private String physicalAccountNumber;
	@Column
	private String physicalAccountBranch;
	@Column
	private Double balance;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhysicalAccountNumber() {
		return physicalAccountNumber;
	}

	public void setPhysicalAccountNumber(String physicalAccountNumber) {
		this.physicalAccountNumber = physicalAccountNumber;
	}

	public String getPhysicalAccountBranch() {
		return physicalAccountBranch;
	}

	public void setPhysicalAccountBranch(String physicalAccountBranch) {
		this.physicalAccountBranch = physicalAccountBranch;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
