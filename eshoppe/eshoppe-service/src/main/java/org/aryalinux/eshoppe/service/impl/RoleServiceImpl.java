package org.aryalinux.eshoppe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.aryalinux.eshoppe.commons.RoleDTO;
import org.aryalinux.eshoppe.data.dao.GenericDAO;
import org.aryalinux.eshoppe.data.model.Role;
import org.aryalinux.eshoppe.service.RoleService;
import org.aryalinux.eshoppe.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {
	@Autowired
	private GenericDAO<Role, Integer> roleDAO;

	public List<RoleDTO> getAllRoles() {
		List<RoleDTO> roles = new ArrayList<RoleDTO>();
		List<Role> roleModels = roleDAO.fetchAll();
		for (Role role : roleModels) {
			RoleDTO roleDTO = (RoleDTO) ObjectUtil.transferState(role, RoleDTO.class);
			roles.add(roleDTO);
		}
		return roles;
	}

	public Integer createNewRole(RoleDTO roleDTO) {
		Role role = (Role) ObjectUtil.transferState(roleDTO, Role.class);
		return roleDAO.create(role);
	}

}
