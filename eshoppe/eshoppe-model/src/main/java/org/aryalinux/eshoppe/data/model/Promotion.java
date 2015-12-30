package org.aryalinux.eshoppe.data.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Promotion extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	private Employee employee;
	@ManyToOne
	private Role intialRole;
	@ManyToOne
	private Role newRole;
	@OneToOne
	private Payroll initialSalary;
	@OneToOne
	private Payroll newSalary;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Role getIntialRole() {
		return intialRole;
	}

	public void setIntialRole(Role intialRole) {
		this.intialRole = intialRole;
	}

	public Role getNewRole() {
		return newRole;
	}

	public void setNewRole(Role newRole) {
		this.newRole = newRole;
	}

	public Payroll getInitialSalary() {
		return initialSalary;
	}

	public void setInitialSalary(Payroll initialSalary) {
		this.initialSalary = initialSalary;
	}

	public Payroll getNewSalary() {
		return newSalary;
	}

	public void setNewSalary(Payroll newSalary) {
		this.newSalary = newSalary;
	}

}
