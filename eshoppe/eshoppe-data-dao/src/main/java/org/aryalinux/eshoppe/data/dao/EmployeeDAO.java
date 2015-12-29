package org.aryalinux.eshoppe.data.dao;

import org.aryalinux.eshoppe.data.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAO extends GenericDAO<Employee, Integer> {
	public EmployeeDAO() {
		super(Employee.class);
	}
}
