package org.aryalinux.eshoppe.data.dao;

import org.aryalinux.eshoppe.data.model.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleDAO extends GenericDAO<Role, Integer> {
	public RoleDAO() {
		super(Role.class);
	}
}
