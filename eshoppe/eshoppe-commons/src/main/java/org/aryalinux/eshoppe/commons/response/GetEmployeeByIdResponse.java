package org.aryalinux.eshoppe.commons.response;

import org.aryalinux.eshoppe.commons.EmployeeDTO;

public class GetEmployeeByIdResponse extends BaseResponse {
	private EmployeeDTO employee;

	public EmployeeDTO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}

}
