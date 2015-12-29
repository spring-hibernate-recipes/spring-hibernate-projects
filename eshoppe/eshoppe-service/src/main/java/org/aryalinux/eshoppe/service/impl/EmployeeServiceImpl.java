package org.aryalinux.eshoppe.service.impl;

import java.util.Map;

import org.aryalinux.eshoppe.commons.AddressDTO;
import org.aryalinux.eshoppe.commons.EmployeeDTO;
import org.aryalinux.eshoppe.commons.RoleDTO;
import org.aryalinux.eshoppe.commons.request.CreateNewEmployeeRequest;
import org.aryalinux.eshoppe.commons.request.UpdateEmployeeRequest;
import org.aryalinux.eshoppe.commons.response.CreateNewEmployeeResponse;
import org.aryalinux.eshoppe.commons.response.DeleteEmployeeResponse;
import org.aryalinux.eshoppe.commons.response.GetEmployeeByIdResponse;
import org.aryalinux.eshoppe.commons.response.GetEmployeesByCriteriaResponse;
import org.aryalinux.eshoppe.commons.response.UpdateEmployeeResponse;
import org.aryalinux.eshoppe.data.dao.AddressDAO;
import org.aryalinux.eshoppe.data.dao.EmployeeDAO;
import org.aryalinux.eshoppe.data.dao.RoleDAO;
import org.aryalinux.eshoppe.data.model.Address;
import org.aryalinux.eshoppe.data.model.Employee;
import org.aryalinux.eshoppe.data.model.Role;
import org.aryalinux.eshoppe.service.EmployeeService;
import org.aryalinux.eshoppe.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private RoleDAO roleDAO;
	@Autowired
	private AddressDAO addressDAO;

	public CreateNewEmployeeResponse createNewEmployee(CreateNewEmployeeRequest createNewEmployeeRequest) {
		CreateNewEmployeeResponse createNewEmployeeResponse = new CreateNewEmployeeResponse();
		Role role = roleDAO.findById(createNewEmployeeRequest.getEmployee().getRole().getId());
		if (role == null) {
			createNewEmployeeResponse.setCode(0);
			createNewEmployeeResponse.setMessage("Could not locate role to assign for id: "
					+ createNewEmployeeRequest.getEmployee().getRole().getId());
			return createNewEmployeeResponse;
		}
		Address address = (Address) ObjectUtil.transferState(createNewEmployeeRequest.getEmployee().getAddress(),
				Address.class);
		Integer addressId = addressDAO.create(address);
		Employee employee = (Employee) ObjectUtil.transferState(createNewEmployeeRequest.getEmployee(), Employee.class);
		Integer employeeId = employeeDAO.create(employee);
		createNewEmployeeResponse.setCode(1);
		createNewEmployeeResponse
				.setMessage("Employee record created successfully. Id: " + employeeId + ", Address Id: " + addressId);
		createNewEmployeeResponse.setEmployeeId(employeeId);
		return createNewEmployeeResponse;
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
