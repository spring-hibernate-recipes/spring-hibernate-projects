package org.aryalinux.eshoppe.service;

import org.aryalinux.eshoppe.commons.AddressDTO;

public interface AddressService {
	Integer newAddress(AddressDTO address);

	AddressDTO getAddress(Integer id);
}
