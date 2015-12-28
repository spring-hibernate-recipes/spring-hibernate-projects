package org.aryalinux.eshoppe.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Employee extends BaseEntity {
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String emailAddress;
	@Column
	private String password;
	@OneToOne
	private Salary currentSalary;
	@OneToOne
	private Role presentRole;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Salary getCurrentSalary() {
		return currentSalary;
	}

	public void setCurrentSalary(Salary currentSalary) {
		this.currentSalary = currentSalary;
	}

	public Role getPresentRole() {
		return presentRole;
	}

	public void setPresentRole(Role presentRole) {
		this.presentRole = presentRole;
	}

}
