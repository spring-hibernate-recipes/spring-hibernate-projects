package org.aryalinux.eshoppe.commons.request;

import org.aryalinux.eshoppe.commons.EmployeeDTO;

public class UpdateEmployeeRequest {
	private EmployeeDTO employee;

	public EmployeeDTO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}

}
