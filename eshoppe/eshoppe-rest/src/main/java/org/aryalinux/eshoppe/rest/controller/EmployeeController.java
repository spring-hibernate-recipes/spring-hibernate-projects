package org.aryalinux.eshoppe.rest.controller;

import org.aryalinux.eshoppe.commons.request.CreateNewEmployeeRequest;
import org.aryalinux.eshoppe.commons.response.CreateNewEmployeeResponse;
import org.aryalinux.eshoppe.commons.response.GetEmployeeByIdResponse;
import org.aryalinux.eshoppe.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@ResponseBody
	@RequestMapping(path = "/eshoppe/employee", method = RequestMethod.POST)
	public CreateNewEmployeeResponse createNewEmployee(CreateNewEmployeeRequest newEmployeeRequest) {
		return employeeService.createNewEmployee(newEmployeeRequest);
	}

	@ResponseBody
	@RequestMapping(path = "/eshoppe/employee", method = RequestMethod.GET)
	public GetEmployeeByIdResponse getEmployeeById(@RequestParam(name = "id") Integer id) {
		return employeeService.findEmployeeById(id);
	}
}
