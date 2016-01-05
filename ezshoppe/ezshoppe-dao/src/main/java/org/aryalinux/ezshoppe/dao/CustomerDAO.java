package org.aryalinux.ezshoppe.dao;

import org.aryalinux.ezshoppe.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDAO extends GenericDAO<Customer, Integer> {
	public CustomerDAO() {
		super(Customer.class);
	}
}
