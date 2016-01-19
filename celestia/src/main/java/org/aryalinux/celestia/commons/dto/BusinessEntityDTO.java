package org.aryalinux.celestia.commons.dto;

import java.util.List;

public class BusinessEntityDTO {
	private String name;
	private String description;
	private List<EntityPropertyDTO> properties;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<EntityPropertyDTO> getProperties() {
		return properties;
	}

	public void setProperties(List<EntityPropertyDTO> properties) {
		this.properties = properties;
	}

}
