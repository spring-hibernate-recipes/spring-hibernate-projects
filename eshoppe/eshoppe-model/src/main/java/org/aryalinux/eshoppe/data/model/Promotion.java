package org.aryalinux.eshoppe.data.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "promotions")
public class Promotion extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	private Employee employee;
	@ManyToOne
	private Role intialRole;
	@ManyToOne
	private Role newRole;
	@OneToOne
	private SalaryStructure initialSalary;
	@OneToOne
	private SalaryStructure newSalary;

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

	public SalaryStructure getInitialSalary() {
		return initialSalary;
	}

	public void setInitialSalary(SalaryStructure initialSalary) {
		this.initialSalary = initialSalary;
	}

	public SalaryStructure getNewSalary() {
		return newSalary;
	}

	public void setNewSalary(SalaryStructure newSalary) {
		this.newSalary = newSalary;
	}

}
