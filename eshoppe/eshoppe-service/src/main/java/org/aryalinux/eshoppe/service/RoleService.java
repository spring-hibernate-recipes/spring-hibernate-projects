package org.aryalinux.eshoppe.service;

import java.util.List;

import org.aryalinux.eshoppe.commons.RoleDTO;

public interface RoleService {
	List<RoleDTO> getAllRoles();
	
	Integer createNewRole(RoleDTO roleDTO);
}
