package org.aryalinux.eshoppe.rest.controller;

import java.util.List;

import org.aryalinux.eshoppe.commons.RoleDTO;
import org.aryalinux.eshoppe.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, path = "/eshoppe/role")
	public List<RoleDTO> getAllRoles() {
		return roleService.getAllRoles();
	}

	@ResponseBody
	@RequestMapping(path = "/eshoppe/role", method = RequestMethod.POST)
	public Integer addRole(RoleDTO roleDTO) {
		return roleService.createNewRole(roleDTO);
	}
}
