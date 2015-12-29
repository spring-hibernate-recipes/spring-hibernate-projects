package org.aryalinux.eshoppe.commons.response;

import java.util.List;

import org.aryalinux.eshoppe.commons.EmployeeDTO;

public class GetEmployeesByCriteriaResponse extends BaseResponse {
	private List<EmployeeDTO> employees;

	public List<EmployeeDTO> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDTO> employees) {
		this.employees = employees;
	}

}
