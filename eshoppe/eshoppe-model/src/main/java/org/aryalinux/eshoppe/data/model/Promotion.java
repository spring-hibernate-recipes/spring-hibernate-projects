package org.aryalinux.eshoppe.data.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Promotion extends BaseEntity {
	@OneToOne
	private Employee employee;
	@OneToOne
	private Role intialRole;
	@OneToOne
	private Role newRole;
	@OneToOne
	private Salary initialSalary;
	@OneToOne
	private Salary newSalary;

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

	public Salary getInitialSalary() {
		return initialSalary;
	}

	public void setInitialSalary(Salary initialSalary) {
		this.initialSalary = initialSalary;
	}

	public Salary getNewSalary() {
		return newSalary;
	}

	public void setNewSalary(Salary newSalary) {
		this.newSalary = newSalary;
	}

}
