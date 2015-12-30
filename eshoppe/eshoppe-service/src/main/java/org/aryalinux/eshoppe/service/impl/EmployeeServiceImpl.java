package org.aryalinux.eshoppe.service.impl;

import java.util.Map;

import org.aryalinux.eshoppe.commons.AddressDTO;
import org.aryalinux.eshoppe.commons.EmployeeDTO;
import org.aryalinux.eshoppe.commons.RoleDTO;
import org.aryalinux.eshoppe.commons.request.NewEmployeeRequest;
import org.aryalinux.eshoppe.commons.request.UpdateEmployeeRequest;
import org.aryalinux.eshoppe.commons.response.DeleteEmployeeResponse;
import org.aryalinux.eshoppe.commons.response.GetEmployeeByIdResponse;
import org.aryalinux.eshoppe.commons.response.GetEmployeesByCriteriaResponse;
import org.aryalinux.eshoppe.commons.response.NewEmployeeResponse;
import org.aryalinux.eshoppe.commons.response.UpdateEmployeeResponse;
import org.aryalinux.eshoppe.data.dao.EmployeeDAO;
import org.aryalinux.eshoppe.data.model.Employee;
import org.aryalinux.eshoppe.service.EmployeeService;
import org.aryalinux.eshoppe.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;

	public NewEmployeeResponse createNewEmployee(NewEmployeeRequest NewEmployeeRequest) {
		NewEmployeeResponse NewEmployeeResponse = new NewEmployeeResponse();

		Employee employee = (Employee) ObjectUtil.transferState(NewEmployeeRequest, Employee.class);
		Integer employeeId = employeeDAO.create(employee);
		NewEmployeeResponse.setCode(1);
		NewEmployeeResponse.setMessage("Employee record created successfully. Id: " + employeeId);
		NewEmployeeResponse.setEmployeeId(employeeId);
		return NewEmployeeResponse;
	}

	public GetEmployeeByIdResponse findEmployeeById(Integer id) {
		GetEmployeeByIdResponse employeeByIdResponse = new GetEmployeeByIdResponse();

		Employee employee = employeeDAO.findById(id);
		if (employee == null) {
			employeeByIdResponse.setCode(0);
			employeeByIdResponse.setMessage("Employee details not found.");
			return employeeByIdResponse;
		}
		RoleDTO roleDTO = (RoleDTO) ObjectUtil.transferState(employee.getPresentRole(), RoleDTO.class);
		AddressDTO addressDTO = (AddressDTO) ObjectUtil.transferState(employee.getAddress(), AddressDTO.class);
		EmployeeDTO employeeDTO = (EmployeeDTO) ObjectUtil.transferState(employee, EmployeeDTO.class);
		employeeDTO.setAddress(addressDTO);
		employeeDTO.setRole(roleDTO);

		employeeByIdResponse.setEmployee(employeeDTO);
		employeeByIdResponse.setCode(1);
		employeeByIdResponse.setMessage("Employee details found.");

		return employeeByIdResponse;
	}

	public GetEmployeesByCriteriaResponse getEmployess(Map<String, Object> criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest updateEmployeeRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public DeleteEmployeeResponse deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
