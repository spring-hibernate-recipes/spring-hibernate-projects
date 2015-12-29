package org.aryalinux.eshoppe.data.dao;

import org.aryalinux.eshoppe.data.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressDAO extends GenericDAO<Address, Integer> {
	public AddressDAO() {
		super(Address.class);
	}
}
