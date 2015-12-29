package org.aryalinux.eshoppe.commons;

import java.util.List;

public class RoleDTO extends BaseDTO {
	private String name;
	private List<ResponsibilityDTO> responsibilities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ResponsibilityDTO> getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(List<ResponsibilityDTO> responsibilities) {
		this.responsibilities = responsibilities;
	}

}
