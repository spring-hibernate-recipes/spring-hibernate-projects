package org.aryalinux.eshoppe.service.impl;

import org.aryalinux.eshoppe.commons.AddressDTO;
import org.aryalinux.eshoppe.data.dao.GenericDAO;
import org.aryalinux.eshoppe.data.model.Address;
import org.aryalinux.eshoppe.service.AddressService;
import org.aryalinux.eshoppe.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressServiceImpl implements AddressService {
	@Autowired
	private GenericDAO<Address, Integer> addressDAO;

	public Integer newAddress(AddressDTO address) {
		Address address2 = (Address) ObjectUtil.transferState(address, Address.class);
		return addressDAO.create(address2);
	}

	public AddressDTO getAddress(Integer id) {
		Address address = addressDAO.findById(id);
		AddressDTO addressDTO = (AddressDTO) ObjectUtil.transferState(address, AddressDTO.class);
		return addressDTO;
	}

}
