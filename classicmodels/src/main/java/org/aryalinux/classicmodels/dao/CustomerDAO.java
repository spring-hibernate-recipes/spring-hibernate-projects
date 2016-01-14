package org.aryalinux.classicmodels.dao;

import org.aryalinux.classicmodels.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDAO extends GenericDAO<Customer, Integer> {

	public CustomerDAO() {
		super(Customer.class);
	}
}
