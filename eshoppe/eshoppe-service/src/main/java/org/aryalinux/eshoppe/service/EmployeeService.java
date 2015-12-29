package org.aryalinux.eshoppe.service;

import java.util.Map;

import org.aryalinux.eshoppe.commons.request.CreateNewEmployeeRequest;
import org.aryalinux.eshoppe.commons.request.UpdateEmployeeRequest;
import org.aryalinux.eshoppe.commons.response.CreateNewEmployeeResponse;
import org.aryalinux.eshoppe.commons.response.DeleteEmployeeResponse;
import org.aryalinux.eshoppe.commons.response.GetEmployeeByIdResponse;
import org.aryalinux.eshoppe.commons.response.GetEmployeesByCriteriaResponse;
import org.aryalinux.eshoppe.commons.response.UpdateEmployeeResponse;

public interface EmployeeService {
	CreateNewEmployeeResponse createNewEmployee(CreateNewEmployeeRequest createNewEmployeeRequest);

	GetEmployeeByIdResponse findEmployeeById(Integer id);

	GetEmployeesByCriteriaResponse getEmployess(Map<String, Object> criteria);

	UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest updateEmployeeRequest);

	DeleteEmployeeResponse deleteEmployee(Integer id);
}
